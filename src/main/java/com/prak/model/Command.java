package com.prak.model;

import com.prak.exception.InvalidCommandException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Command {
    private static final String SPACE_DELIMITER = " ";
    private String commandName;
    private List<String> parameters;

    public String getCommandName() {
        return commandName;
    }

    public List<String> getParameters() {
        return parameters;
    }

    public Command(final String inputLine) {
        final List<String> tokensList = Arrays.stream(inputLine.trim().split(SPACE_DELIMITER))
                .map(String::trim)
                .filter(token -> (token.length() > 0)).collect(Collectors.toList());

        if (tokensList.size() == 0) {
            throw new InvalidCommandException();
        }

        commandName = tokensList.get(0).toLowerCase();
        tokensList.remove(0);
        parameters = tokensList;
    }
}
