package com.prak.model;

import com.prak.model.enums.Size;

public class ParkingSpot {
    private int spotNumber;
    private Size size;
    private boolean isAvailable;
    private Vehicle vehicle;
    //TODO see if this is the correct way.
    private ParkingLevel parkingLevel;

    public int getSpotNumber() {
        return spotNumber;
    }

    public void setSpotNumber(int spotNumber) {
        this.spotNumber = spotNumber;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public ParkingLevel getParkingLevel() {
        return parkingLevel;
    }

    public void setParkingLevel(ParkingLevel parkingLevel) {
        this.parkingLevel = parkingLevel;
    }

    public void makeParkingSpotUnavailable() {
        this.setAvailable(false);
        this.setVehicle(null);
    }
}
