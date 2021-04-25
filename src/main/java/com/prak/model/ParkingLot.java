package com.prak.model;

import com.prak.exception.InvalidRegistrationNumberException;
import com.prak.exception.ParkingLotException;
import com.prak.exception.UnavailableParkingSpotsException;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private final int numberOfLevels;
    private final List<ParkingLevel> parkingLevels;

    public ParkingLot(ParkingLotPhysicalDetails parkingLotPhysicalDetails) {
        numberOfLevels = parkingLotPhysicalDetails.getNumberOfLevels();
        parkingLevels = new ArrayList<>();
        for (int level = 0; level < numberOfLevels; level++) {
            parkingLevels.add(new ParkingLevel(level, parkingLotPhysicalDetails));
        }
    }

    public List<ParkingSpot> parkVehicle(Vehicle vehicle) throws ParkingLotException{
        validateParkingLotInitialised();

        for (ParkingLevel parkingLevel: parkingLevels) {
            if (parkingLevel.parkVehicle(vehicle)) {
                return parkingLevel.getVehicleParkingSpots(vehicle.vehicleRegistrationNumber);
            }
        }
        throw new UnavailableParkingSpotsException();
    }

    public void unParkVehicle(String vehicleRegistrationNumber) throws ParkingLotException {
        validateParkingLotInitialised();

        for (ParkingLevel parkingLevel: parkingLevels) {
            if (parkingLevel.isVehicleParkedWithRegistrationNumber(vehicleRegistrationNumber)) {
                parkingLevel.unParkVehicle(vehicleRegistrationNumber);
                return;
            }
        }
        throw new InvalidRegistrationNumberException();
    }

    public List<ParkingLevel> getParkingLevels() {
        return parkingLevels;
    }

    public int getNumberOfLevels() {
        return numberOfLevels;
    }

    private void validateParkingLotInitialised() {
        if (parkingLevels == null) {
            throw new ParkingLotException("Parking Lot Not Initialised Yet");
        }
    }
}
