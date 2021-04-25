package com.prak.model;


public class ParkingLotPhysicalDetails {
    private final int numberOfLevels;
    private final int numberOfRowsPerLevel;
    private final int numberOfParkingSpotsPerRow;
    private final int numberOfMotorcycleSpotsPerRow;
    private final int numberOfCompactSpotsPerRow;
    private final int numberOfLargeSpotsPerRow;

    public ParkingLotPhysicalDetails(int numberOfLevels, int numberOfRowsPerLevel, int numberOfParkingSpotsPerRow,
                                     int numberOfMotorcycleSpotsPerRow, int numberOfCompactSpotsPerRow,
                                     int numberOfLargeSpotsPerRow) {
        this.numberOfLevels = numberOfLevels;
        this.numberOfRowsPerLevel = numberOfRowsPerLevel;
        this.numberOfParkingSpotsPerRow = numberOfParkingSpotsPerRow;
        this.numberOfMotorcycleSpotsPerRow = numberOfMotorcycleSpotsPerRow;
        this.numberOfCompactSpotsPerRow = numberOfCompactSpotsPerRow;
        this.numberOfLargeSpotsPerRow = numberOfLargeSpotsPerRow;
    }

    public int getNumberOfLevels() {
        return numberOfLevels;
    }

    public int getNumberOfRowsPerLevel() {
        return numberOfRowsPerLevel;
    }

    public int getNumberOfParkingSpotsPerRow() {
        return numberOfParkingSpotsPerRow;
    }

    public int getNumberOfMotorcycleSpotsPerRow() {
        return numberOfMotorcycleSpotsPerRow;
    }

    public int getNumberOfCompactSpotsPerRow() {
        return numberOfCompactSpotsPerRow;
    }

    public int getNumberOfLargeSpotsPerRow() {
        return numberOfLargeSpotsPerRow;
    }
}
