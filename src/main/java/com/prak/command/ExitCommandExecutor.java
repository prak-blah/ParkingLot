package com.prak.command;
import com.prak.model.Command;
import com.prak.service.ParkingLotService;

/**
 * Executor to handle command of exiting from the parking lot service. This is used in interactive
 * mode to exit.
 */
public class ExitCommandExecutor extends CommandExecutor {
    public static String COMMAND_NAME = "exit";

    public ExitCommandExecutor(ParkingLotService parkingLotService) {
        super(parkingLotService);
    }

    @Override
    public boolean validateCommand(Command command) {
        return command.getParameters().isEmpty();
    }

    @Override
    public void executeCommand(Command command) {
        System.out.println("Ending...");
    }
}