package com.prak.dao.impl;

import com.prak.dao.ParkingLotDataStore;
import com.prak.exception.ParkingLotException;
import com.prak.model.*;
import com.prak.model.enums.Size;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class InMemoryParkingLotDataStore implements ParkingLotDataStore {
    private static ParkingLot parkingLot;
//    private Map<String>

    InMemoryParkingLotDataStore() {
        parkingLot=null;
    }

    @Override
    public ParkingSpot putVehicleInParkingLot(Vehicle vehicle) throws ParkingLotException {
        validateParkingLotExists();

        return null;
    }

    @Override
    public void createParkingLotDataStore(ParkingLotPhysicalDetails parkingLotPhysicalDetails) throws ParkingLotException {
        validateParkingLotDoesNotExists();
        parkingLot = new ParkingLot();
        parkingLot.setNumberOfLevels(parkingLotPhysicalDetails.getNumberOfLevels());
        final List<ParkingLevel> parkingLevels = new ArrayList<>();
        IntStream.range(0,parkingLotPhysicalDetails.getNumberOfLevels())
                .forEach(level -> parkingLevels.add(createParkingLevel(parkingLotPhysicalDetails,level)));
        parkingLot.setParkingLevels(parkingLevels);
    }

    private ParkingLevel createParkingLevel(ParkingLotPhysicalDetails parkingLotPhysicalDetails, int level) {
        ParkingLevel parkingLevel = new ParkingLevel();
        parkingLevel.setLevelNumber(level);
        parkingLevel.setNumberOfRows(parkingLotPhysicalDetails.getNumberOfRowsPerLevel());
        parkingLevel.setNumberOfParkingSpotsPerRow(parkingLotPhysicalDetails.getNumberOfParkingSpotsPerRow());
        AtomicInteger spotNumber  = new AtomicInteger();
        final List<ParkingSpot> parkingSpots = new ArrayList<>();
        IntStream.range(0,parkingLotPhysicalDetails.getNumberOfRowsPerLevel())
                .forEach(row -> {
                   IntStream.range(0,parkingLotPhysicalDetails.getNumberOfMotorcycleSpotsPerRow())
                           .forEach(spot -> parkingSpots.add(createParkingSpot(spotNumber.getAndIncrement(),
                                   Size.MOTORCYCLE, parkingLevel)));
                   IntStream.range(0,parkingLotPhysicalDetails.getNumberOfCompactSpotsPerRow())
                            .forEach(spot -> parkingSpots.add(createParkingSpot(spotNumber.getAndIncrement(),
                                    Size.COMPACT, parkingLevel)));
                   IntStream.range(0,parkingLotPhysicalDetails.getNumberOfLargeSpotsPerRow())
                            .forEach(spot -> parkingSpots.add(createParkingSpot(spotNumber.getAndIncrement(),
                                    Size.LARGE, parkingLevel)));
                });
        parkingLevel.setParkingSpots(parkingSpots);
        return parkingLevel;
    }

    private ParkingSpot createParkingSpot(int spotNumber, Size size, ParkingLevel parkingLevel) {
        ParkingSpot parkingSpot = new ParkingSpot();
        parkingSpot.setParkingLevel(parkingLevel);
        parkingSpot.setSpotNumber(spotNumber);
        parkingSpot.setAvailable(true);
        parkingSpot.setSize(size);
        return parkingSpot;
    }

    private void validateParkingLotExists() {
        if (parkingLot == null) {
            throw new ParkingLotException("Parking lot does not exists to park.");
        }
    }

    private void validateParkingLotDoesNotExists() {
        if (parkingLot != null) {
            throw new ParkingLotException("Parking lot already exists.");
        }
    }
}
