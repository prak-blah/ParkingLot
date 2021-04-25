package com.prak.command;

import com.prak.exception.InvalidCommandException;
import com.prak.model.Command;
import com.prak.service.ParkingLotService;

import java.util.HashMap;
import java.util.Map;

public class CommandExecutorFactory {
    Map<String, CommandExecutor> commands = new HashMap<>();

    public CommandExecutorFactory(ParkingLotService parkingLotService) {
        //add commands here;
        commands.put(CreateNewParkingLotCommandExecutor.COMMAND_NAME,
                new CreateNewParkingLotCommandExecutor(parkingLotService));
        commands.put(ParkVehicleCommandExecutor.COMMAND_NAME,
                new CreateNewParkingLotCommandExecutor(parkingLotService));
        commands.put(UnParkVehicleCommandExecutor.COMMAND_NAME,
                new CreateNewParkingLotCommandExecutor(parkingLotService));
    }

    public CommandExecutor getCommandExecutor (Command command) {
        CommandExecutor commandExecutor = commands.get(command.getCommandName());
        if (commandExecutor == null)
            throw new InvalidCommandException();
        return commandExecutor;
    }

}
