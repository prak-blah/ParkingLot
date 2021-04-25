package com.prak;

import com.prak.command.CommandExecutor;
import com.prak.command.CommandExecutorFactory;
import com.prak.command.ExitCommandExecutor;
import com.prak.exception.InvalidCommandException;
import com.prak.exception.ParkingLotException;
import com.prak.model.Command;
import com.prak.service.ParkingLotService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(final String[] args) throws IOException {
        ParkingLotService parkingLotService = new ParkingLotService();
        CommandExecutorFactory commandExecutorFactory =
                new CommandExecutorFactory(parkingLotService);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            final String input = reader.readLine();
            final Command command = new Command(input);
            try {
                executeCommands(command, commandExecutorFactory);
            } catch (ParkingLotException e) {
                System.out.println("Found exception while executing a command: " + e);
            }
            if (command.getCommandName().equals(ExitCommandExecutor.COMMAND_NAME)) {
                break;
            }
        }
    }

    private static void executeCommands(Command command, CommandExecutorFactory commandExecutorFactory) {
        CommandExecutor commandExecutor = commandExecutorFactory.getCommandExecutor(command);
        if (commandExecutor.validateCommand(command)) {
            commandExecutor.executeCommand(command);
        } else {
            throw new InvalidCommandException();
        }
    }
}
