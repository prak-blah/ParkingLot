package com.prak.model;

import com.prak.model.enums.Size;

public class Bus extends Vehicle{

    public static final String VEHICLE_NAME = "bus";

    public Bus(String busRegistrationNumber) {
        super(busRegistrationNumber, Size.LARGE, 5);
    }

    @Override
    public boolean canVehicleUseSpotSize(Size parkingSpotSize) {
        return parkingSpotSize.equals(Size.LARGE);
    }
}
