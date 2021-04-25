package com.prak.command;

import com.prak.exception.ParkingLotException;
import com.prak.model.Command;
import com.prak.service.ParkingLotService;

import java.util.List;

public class UnParkVehicleCommandExecutor extends CommandExecutor{
    public static final String COMMAND_NAME = "un_park_vehicle";

    public UnParkVehicleCommandExecutor(ParkingLotService parkingLotService) {
        super(parkingLotService);
    }

    // one parameter with registration number (string) as value
    @Override
    public boolean validateCommand(Command command) {
        List<String> parameters = command.getParameters();
        return parameters.size()==1 && parameters.get(0).length()>=1;
    }

    @Override
    public void executeCommand(Command command) {
        List<String> parameters = command.getParameters();
        try {
            parkingLotService.unParkVehicle(parameters.get(0));
            System.out.println("Successfully Un Parked the car");
        } catch (ParkingLotException e) {
            System.out.println("Encountered exception while un_parking the car with error: " + e);
        }
    }
}
