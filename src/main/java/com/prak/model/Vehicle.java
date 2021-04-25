package com.prak.model;

import com.prak.model.enums.Size;

import java.util.ArrayList;
import java.util.List;

public abstract class Vehicle {
    protected String vehicleRegistrationNumber;
    protected Size size;
    protected int numberOfSpotsNeeded;
    protected List<ParkingSpot> parkingSpots = new ArrayList<>();

    public Vehicle (String vehicleRegistrationNumber, Size size, int numberOfSpotsNeeded) {
        this.vehicleRegistrationNumber = vehicleRegistrationNumber;
        this.size = size;
        this.numberOfSpotsNeeded = numberOfSpotsNeeded;
    }

    public int getNumberOfSpotsNeeded() {
        return numberOfSpotsNeeded;
    }

    public void parkVehicle(ParkingSpot spot) {
        parkingSpots.add(spot);
    }

    public void unParkVehicle() {
        for(ParkingSpot spot : parkingSpots) {
            spot.unParkVehicle();
        }
        parkingSpots.clear();
    }

    /**
     * this just checks if the vehicle can use a particular kind of parking spot.
     * even if this returns true it doesn't vehicle can be parked in the current
     * spot as a vehicle may need more than one spot of a kind to park. Eg. bus.
     * @param parkingSpotSize size of the parking spot.
     * @return true if the parking spot is appropriate.
     */
    public abstract boolean canVehicleUseSpotSize(Size parkingSpotSize);
}
