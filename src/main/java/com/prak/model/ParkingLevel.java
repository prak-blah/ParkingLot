package com.prak.model;

import com.prak.exception.ParkingLotException;
import com.prak.exception.VehicleAlreadyParkedException;
import com.prak.model.enums.Size;
import com.prak.util.ParkingSpotUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class ParkingLevel {
    private final int levelNumber;
    private final int numberOfRows;
    private final List<ParkingSpot> parkingSpots;
    private final int numberOfParkingSpotsPerRow;
    private final Map<String, List<ParkingSpot>> registrationIdToParkingSpot;

    public ParkingLevel(int levelNumber, ParkingLotPhysicalDetails parkingLotPhysicalDetails) {
        this.numberOfRows = parkingLotPhysicalDetails.getNumberOfRowsPerLevel();
        this.numberOfParkingSpotsPerRow = parkingLotPhysicalDetails.getNumberOfParkingSpotsPerRow();
        this.levelNumber = levelNumber;
        int spotNumber = 0;
        parkingSpots = new ArrayList<>();
        registrationIdToParkingSpot = new HashMap<>();
        //TODO can we use stream? May cause race condition?
        for (int row=0;row<this.numberOfRows;row++) {
            for (int spot=0;spot<parkingLotPhysicalDetails.getNumberOfMotorcycleSpotsPerRow();spot++) {
                this.parkingSpots.add(new ParkingSpot(spotNumber++, Size.MOTORCYCLE, this, row, levelNumber));
            }
            for (int spot=0;spot<parkingLotPhysicalDetails.getNumberOfCompactSpotsPerRow();spot++) {
                this.parkingSpots.add(new ParkingSpot(spotNumber++, Size.COMPACT, this, row, levelNumber));
            }
            for (int spot=0;spot<parkingLotPhysicalDetails.getNumberOfLargeSpotsPerRow();spot++) {
                this.parkingSpots.add(new ParkingSpot(spotNumber++, Size.LARGE, this, row, levelNumber));
            }
        }
    }

    public boolean parkVehicle(Vehicle vehicle) throws ParkingLotException {
        validateParkingLevelInitialised();
        if (isVehicleParkedWithRegistrationNumber(vehicle.vehicleRegistrationNumber))
            throw new VehicleAlreadyParkedException();

        int startingParkingSpotNumber = findNextAvailableSpot(vehicle);
        if(startingParkingSpotNumber==-1) {
            return false;
        }

        List<ParkingSpot> spotsWhereVehicleIsParked = new ArrayList<>();
        IntStream.range(0, vehicle.getNumberOfSpotsNeeded())
                .forEach(spotOffset -> {
                    ParkingSpot spot = parkingSpots.get(startingParkingSpotNumber + spotOffset);
                    spot.parkVehicle(vehicle);
                    spotsWhereVehicleIsParked.add(spot);
                });
        registrationIdToParkingSpot.put(vehicle.vehicleRegistrationNumber, spotsWhereVehicleIsParked);
        return true;
    }

    public boolean isVehicleParkedWithRegistrationNumber(String vehicleRegistrationNumber) {
        return registrationIdToParkingSpot.containsKey(vehicleRegistrationNumber);
    }

    public List<ParkingSpot> getVehicleParkingSpots(String vehicleRegistrationNumber) throws ParkingLotException{
        if (!isVehicleParkedWithRegistrationNumber(vehicleRegistrationNumber))
            throw new ParkingLotException("Parking leve: " + this.levelNumber
                    + " does not contain the vehicle with registration number: " + vehicleRegistrationNumber);
        return registrationIdToParkingSpot.get(vehicleRegistrationNumber);
    }

    public boolean unParkVehicle(String vehicleRegistrationNumber) throws ParkingLotException {
        validateParkingLevelInitialised();
        if (!isVehicleParkedWithRegistrationNumber(vehicleRegistrationNumber)) {
            return false;
        }
        getVehicleParkingSpots(vehicleRegistrationNumber).get(0).getVehicle().unParkVehicle();
        registrationIdToParkingSpot.remove(vehicleRegistrationNumber);
        return true;
    }

    private int findNextAvailableSpot(Vehicle vehicle) {
        int numberOfSpotsNeededByVehicle = vehicle.getNumberOfSpotsNeeded();
        int numberOfSpotsAvailable = 0;
        for (int spotNumber=0;spotNumber<parkingSpots.size();spotNumber++) {
            if(isStartOfNewRow(spotNumber)) {
                numberOfSpotsAvailable = 0;
            }

            if (parkingSpots.get(spotNumber).canUseSpot(vehicle)) {
                numberOfSpotsAvailable++;
            } else {
                numberOfSpotsAvailable=0;
            }

            if (numberOfSpotsAvailable == numberOfSpotsNeededByVehicle) {
                return spotNumber - (numberOfSpotsNeededByVehicle-1);
            }
        }
        return -1;
    }

    private boolean isStartOfNewRow(int spotNumber) {
        return ParkingSpotUtil.isFirstSpotInTheRow(spotNumber, this.numberOfParkingSpotsPerRow);
    }


    private void validateParkingLevelInitialised() {
        if (parkingSpots == null) {
            throw new ParkingLotException("Parking Level Not Initialised Yet");
        }
    }

    public int getLevelNumber() {
        return levelNumber;
    }

}
