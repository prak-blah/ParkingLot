package com.prak.dao;

import com.prak.exception.ParkingLotException;
import com.prak.model.ParkingLotPhysicalDetails;
import com.prak.model.ParkingSpot;
import com.prak.model.Vehicle;

public interface ParkingLotDataStore {

    /**
     * Persist the vehicle in the parking lot data store.
     * @param vehicle that needs to be persisted.
     * @return Parking Spot object.
     * @throws ParkingLotException when no parking slot is found.
     */
    public ParkingSpot putVehicleInParkingLot(Vehicle vehicle) throws ParkingLotException;

    /**
     * Create new parking lot data store
     * @param parkingLotPhysicalDetails dimensions of parking lot.
     * @throws ParkingLotException when parking lot is already created.
     */
    public void createParkingLotDataStore (ParkingLotPhysicalDetails parkingLotPhysicalDetails) throws ParkingLotException;
}
