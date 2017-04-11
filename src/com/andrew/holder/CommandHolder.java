package com.andrew.holder;

import com.andrew.command.Command;
import com.andrew.command.TakeAllVacanciesWithInfoCommand;
import com.andrew.command.admin.AdminAutorisationCommand;
import com.andrew.command.admin.AdminLogOutCommand;
import com.andrew.command.admin.application.TakeAllApplicationsCommand;
import com.andrew.command.admin.application.TakeApplicationCommand;
import com.andrew.command.admin.application.TakeApplicationsOfUserCommand;
import com.andrew.command.admin.application.TakeApplicationsOfVacancyCommand;
import com.andrew.command.admin.message.*;
import com.andrew.command.admin.user.TakeAllUsersCommand;
import com.andrew.command.admin.user.TakeUserCommand;
import com.andrew.command.admin.vacancy.*;
import com.andrew.command.user.AutorisationCommand;
import com.andrew.command.user.LogOutCommand;
import com.andrew.command.user.ProfileCommand;
import com.andrew.command.user.RegistrationCommand;
import org.apache.log4j.Logger;

import java.util.Map;
import java.util.TreeMap;


public class CommandHolder {
    private static final Logger LOG = Logger.getLogger(CommandHolder.class);

    private static Map<String, Command> commands = new TreeMap<>();

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
        commands.put("new_message", new NewMessageCommand());
        commands.put("send_message", new SendMessageCommand());
        commands.put("edit_vacancy", new EditVacancyCommand());
        commands.put("update_vacancy", new UpdateVacancyCommand());
        commands.put("vacancies", new TakeAllVacanciesWithInfoCommand());
        commands.put("profile", new ProfileCommand());


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