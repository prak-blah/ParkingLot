package com.prak.model;

import com.prak.model.enums.Size;

public class ParkingSpot {
    private final int spotNumber;
    private final Size size;
    private Vehicle vehicle;
    private final ParkingLevel parkingLevel;
    private final int rowNumber;
    private final int levelNumber;

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSpot(int spotNumber, Size size, ParkingLevel parkingLevel, int rowNumber, int levelNumber) {
        this.spotNumber = spotNumber;
        this.size = size;
        this.parkingLevel = parkingLevel;
        this.rowNumber = rowNumber;
        this.levelNumber = levelNumber;
        this.vehicle = null;
    }

    public boolean canUseSpot(Vehicle vehicle) {
        return isAvailable() && vehicle.canVehicleUseSpotSize(this.size);
    }

    public void parkVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        vehicle.parkVehicle(this);
    }

    public void unParkVehicle() {
        makeSpotAvailable();
    }

    public boolean isAvailable() {
        return vehicle == null;
    }

    public void makeSpotAvailable() {
        vehicle = null;
    }

    public ParkingLevel getParkingLevel() {
        return parkingLevel;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public int getLevelNumber() {
        return levelNumber;
    }
}
