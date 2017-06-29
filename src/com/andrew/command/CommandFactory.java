package com.andrew.command;

import org.apache.log4j.Logger;

/**
 * Created by Andrew on 28.06.2017.
 */
public class CommandFactory {
    private static final Logger logger = Logger.getLogger(CommandFactory.class);

    public Command defineCommand(String commandName) {
        Command current = null;

        try {
            CommandEnum currentEnum = CommandEnum.valueOf(commandName);
            current = currentEnum.getCurrentCommand();
        } catch (IllegalArgumentException e) {
           // current = CommandEnum.WRONG.getCurrentCommand();
        }

        return current;
    }
}
