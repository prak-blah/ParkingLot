package com.prak.model;

import java.util.List;

public class ParkingLevel {
    private int levelNumber;
    private int numberOfRows;
    private List<ParkingSpot> parkingSpots;
    private int numberOfParkingSpotsPerRow;

    public int getLevelNumber() {
        return levelNumber;
    }

    public void setLevelNumber(int levelNumber) {
        this.levelNumber = levelNumber;
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public void setNumberOfRows(int numberOfRows) {
        this.numberOfRows = numberOfRows;
    }

    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    public void setParkingSpots(List<ParkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }

    public int getNumberOfParkingSpotsPerRow() {
        return numberOfParkingSpotsPerRow;
    }

    public void setNumberOfParkingSpotsPerRow(int numberOfParkingSpotsPerRow) {
        this.numberOfParkingSpotsPerRow = numberOfParkingSpotsPerRow;
    }

}
