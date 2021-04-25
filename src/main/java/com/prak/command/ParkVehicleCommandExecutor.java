package com.prak.command;

import com.prak.exception.ParkingLotException;
import com.prak.model.Command;
import com.prak.model.ParkingSpot;
import com.prak.model.Vehicle;
import com.prak.model.VehicleFactory;
import com.prak.service.ParkingLotService;

import java.util.List;

public class ParkVehicleCommandExecutor extends CommandExecutor{
    public static final String COMMAND_NAME = "park_vehicle";

    public ParkVehicleCommandExecutor(ParkingLotService parkingLotService) {
        super(parkingLotService);
    }

    // will have car type (car, bus or motorcycle) and reg number as second.
    @Override
    public boolean validateCommand(Command command) {
        List<String> parameters = command.getParameters();
        return parameters.size() == 2 && parameters.get(1).length() >= 1 &&
                parameters.get(0).length()>=1;
    }

    @Override
    public void executeCommand(Command command) {
        List<String> parameters = command.getParameters();
        try {
            VehicleFactory vehicleFactory = new VehicleFactory(parameters.get(1));
            Vehicle vehicle = vehicleFactory.getVehicle(parameters.get(0));
            List<ParkingSpot> parkingSpots = parkingLotService.parkVehicle(vehicle);
            System.out.println("Vehicle Parked at Parking Spots: ");
            for (ParkingSpot parkingSpot: parkingSpots) {
                System.out.println("Floor: " + parkingSpot.getLevelNumber() +
                        " SpotNumber: " + parkingSpot.getSpotNumber() + " Row: " + parkingSpot.getRowNumber());
            }
        } catch (ParkingLotException e) {
            System.out.println("Encountered exception while parking the car with error: " + e);
        }
    }
}
