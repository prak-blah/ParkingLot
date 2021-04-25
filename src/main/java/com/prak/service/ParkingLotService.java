package com.prak.service;

import com.prak.exception.ParkingLotException;
import com.prak.model.ParkingLot;
import com.prak.model.ParkingLotPhysicalDetails;

public class ParkingLotService {
    ParkingLot parkingLot;

    public void CreateParkingLot(ParkingLotPhysicalDetails parkingLotPhysicalDetails) {
        if (parkingLot != null) {
            throw new ParkingLotException("Parking lot already exists.");
        }
        parkingLot = new ParkingLot(parkingLotPhysicalDetails);
    }

}
