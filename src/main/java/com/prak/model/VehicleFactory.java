package com.prak.model;

import com.prak.exception.ParkingLotException;

import java.util.HashMap;
import java.util.Map;

public class VehicleFactory {
    Map<String, Vehicle> vehicle = new HashMap<>();

    public VehicleFactory(String vehicleRegistrationNumber) {
        vehicle.put(Car.VEHICLE_NAME, new Car(vehicleRegistrationNumber));
        vehicle.put(Bus.VEHICLE_NAME, new Car(vehicleRegistrationNumber));
        vehicle.put(Motorcycle.VEHICLE_NAME, new Car(vehicleRegistrationNumber));
    }

    public boolean isValidVehicleType(String vehicleType) {
        return vehicle.containsKey(vehicleType.toLowerCase());
    }

    public Vehicle getVehicle(String vehicleType) {
        if (!isValidVehicleType(vehicleType)) {
            throw new ParkingLotException("Invalid Vehicle Type while getting factory");
        }
        return vehicle.get(vehicleType.toLowerCase());
    }

}
