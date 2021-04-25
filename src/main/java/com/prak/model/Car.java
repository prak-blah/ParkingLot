package com.prak.model;

import com.prak.model.enums.Size;

public class Car extends Vehicle{

    public Car(String carRegistrationNumber) {
        super(carRegistrationNumber, Size.COMPACT, 1);
    }

    @Override
    public boolean canVehicleUseSpotSize(Size parkingSpotSize) {
        return parkingSpotSize.equals(Size.COMPACT) || parkingSpotSize.equals(Size.LARGE);
    }
}
