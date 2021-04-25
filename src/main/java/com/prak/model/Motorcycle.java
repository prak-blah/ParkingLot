package com.prak.model;

import com.prak.model.enums.Size;

public class Motorcycle extends Vehicle{

    public static final String VEHICLE_NAME = "motorcycle";

    public Motorcycle(String motorcycleRegistrationNumber) {
        super(motorcycleRegistrationNumber, Size.MOTORCYCLE, 1);
    }

    @Override
    public boolean canVehicleUseSpotSize(Size parkingSpotSize) {
        return parkingSpotSize.equals(Size.MOTORCYCLE) || parkingSpotSize.equals(Size.COMPACT)
                || parkingSpotSize.equals(Size.LARGE);
    }
}
