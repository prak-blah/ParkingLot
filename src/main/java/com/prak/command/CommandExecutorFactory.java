package com.prak.command;

import com.prak.exception.InvalidCommandException;
import com.prak.model.Command;
import com.prak.service.ParkingLotService;

import java.util.HashMap;
import java.util.Map;

public class CommandExecutorFactory {
    Map<String, CommandExecutor> commands = new HashMap<>();

    CommandExecutorFactory(ParkingLotService parkingLotService) {
        //add commands here;
    }

    public CommandExecutor getCommand (Command command) {
        CommandExecutor commandExecutor = commands.get(command.getCommandName());
        if (commandExecutor == null)
            throw new InvalidCommandException();
        return commandExecutor;
    }

}
