package com.prak.command;

import com.prak.model.Command;
import com.prak.service.ParkingLotService;

import java.util.List;

public abstract class CommandExecutor {
    ParkingLotService parkingLotService;

    public CommandExecutor(ParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }

    public abstract boolean validateCommand(Command command);

    public abstract void executeCommand(Command command);
}
