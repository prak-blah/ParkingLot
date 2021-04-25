package com.prak.service;

import com.prak.exception.ParkingLotException;
import com.prak.model.ParkingLot;
import com.prak.model.ParkingLotPhysicalDetails;
import com.prak.model.ParkingSpot;
import com.prak.model.Vehicle;

import java.util.List;

public class ParkingLotService {
    ParkingLot parkingLot;

    public void CreateParkingLot(ParkingLotPhysicalDetails parkingLotPhysicalDetails) {
        if (parkingLot != null) {
            throw new ParkingLotException("Parking lot already exists.");
        }
        parkingLot = new ParkingLot(parkingLotPhysicalDetails);
    }

    public List<ParkingSpot> parkVehicle(Vehicle vehicle) {
        validateParkingLotInitiation();
        return parkingLot.parkVehicle(vehicle);
    }

    public void unParkVehicle(String vehicleRegistrationNumber) {
        validateParkingLotInitiation();
        parkingLot.unParkVehicle(vehicleRegistrationNumber);
    }

    private void validateParkingLotInitiation() {
        if (parkingLot == null)
            throw new ParkingLotException("Parking Lot Not Initiated Yer.");
    }


}
