package com.andrew.holder;

import com.andrew.command.Command;
import com.andrew.command.admin.*;
import com.andrew.command.user.AutorisationCommand;
import com.andrew.command.user.LogOutCommand;
import com.andrew.command.user.RegistrationCommand;
import org.apache.log4j.Logger;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Andrew on 01.04.2017.
 */
public class CommandHolder {
    private static final Logger LOG = Logger.getLogger(CommandHolder.class);

    private static Map<String, Command> commands = new TreeMap<String, Command>();

    static {
        commands.put("log_out", new LogOutCommand());
        commands.put("log_out_admin", new AdminLogOutCommand());
        commands.put("log_in", new AutorisationCommand());
        commands.put("log_in_admin", new AdminAutorisationCommand());
        commands.put("all_users", new TakeAllUsersCommand());
        commands.put("registration", new RegistrationCommand());
        commands.put("vacancies_admin", new TakeAllVacanciesCommand());
        commands.put("messages_admin", new TakeAllMessagesCommand());
        commands.put("applications_admin", new TakeAllApplicationsCommand());
        commands.put("user", new TakeUserCommand());
        commands.put("vacancy", new TakeVacancyCommand());
        commands.put("message", new TakeMessageCommand());
        commands.put("application", new TakeApplicationCommand());
        commands.put("usapps", new TakeApplicationsOfUserCommand());
        commands.put("usmess", new TakeMessagesForUserCommand());
        commands.put("vapps", new TakeApplicationsOfVacancyCommand());

        commands.put("new_vacancy", new AddNewVacancyCommand());


        LOG.trace("Number of commands --> " + commands.size());
    }

    public static Command get(String commandName) {
        if (commandName == null || !commands.containsKey(commandName)) {
            LOG.trace("Command not found, name --> " + commandName);
            return commands.get("noCommand");
        }

        return commands.get(commandName);
    }
}