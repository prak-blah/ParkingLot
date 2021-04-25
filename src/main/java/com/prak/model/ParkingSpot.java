package com.prak.model;

import com.prak.model.enums.Size;

public class ParkingSpot {
    private int spotNumber;
    private Size size;
    private Vehicle vehicle;
    private ParkingLevel parkingLevel;

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSpot(int spotNumber, Size size, ParkingLevel parkingLevel) {
        this.spotNumber = spotNumber;
        this.size = size;
        this.parkingLevel = parkingLevel;
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
}
