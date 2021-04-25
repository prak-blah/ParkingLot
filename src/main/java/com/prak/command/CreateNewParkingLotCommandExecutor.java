package com.prak.command;

import com.prak.model.Command;
import com.prak.model.ParkingLot;
import com.prak.model.ParkingLotPhysicalDetails;
import com.prak.service.ParkingLotService;
import com.prak.util.IntegerUtil;

import java.util.ArrayList;
import java.util.List;

public class CreateNewParkingLotCommandExecutor extends CommandExecutor {
    public static final String COMMAND_NAME = "create_parking_lot";

    public CreateNewParkingLotCommandExecutor(ParkingLotService parkingLotService) {
        super(parkingLotService);
    }

    // Input will have numberOfFloors, numberOfRowsPerFloors, numberOfSpotsPerRow, numberOfSmallSpots,
    // numberOfCompactSpots, numberOfLargeSpots
    @Override
    public boolean validateCommand(Command command) {
        List<String> parameters = command.getParameters();
        if (parameters.size()!=6)
            return false;
        for (String parameter: parameters) {
            System.out.println(parameter + " " + Integer.parseInt(parameter));
            if(!IntegerUtil.isInteger(parameter) || Integer.parseInt(parameter)>0) {
                return false;
            }
        }
        return Integer.parseInt(parameters.get(3)) + Integer.parseInt(parameters.get(4)) + Integer.parseInt(parameters.get(5))
                == Integer.parseInt(parameters.get(2));
    }

    @Override
    public void executeCommand(Command command) {
        List<String> parameters = command.getParameters();
        List<Integer> intParams = new ArrayList<>();
        for (String parameter: parameters) {
            intParams.add(Integer.parseInt(parameter));
        }
        parkingLotService.CreateParkingLot(new ParkingLotPhysicalDetails(
                intParams.get(0),intParams.get(1),intParams.get(2),intParams.get(3),intParams.get(4),intParams.get(5)
        ));
        System.out.println("Successfully Created A Parking Lot");
    }
}
