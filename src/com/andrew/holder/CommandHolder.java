package com.andrew.holder;

import com.andrew.command.Command;
import com.andrew.command.RegistrationCommand;
import com.andrew.command.TakeAllVacanciesWithInfoCommand;
import com.andrew.command.admin.AdminAutorisationCommand;
import com.andrew.command.admin.AdminLogOutCommand;
import com.andrew.command.admin.application.*;
import com.andrew.command.admin.message.*;
import com.andrew.command.admin.user.TakeAllUsersCommand;
import com.andrew.command.admin.user.TakeRecruitedUsersCommand;
import com.andrew.command.admin.user.TakeUserCommand;
import com.andrew.command.admin.vacancy.*;
import com.andrew.command.user.*;
import com.andrew.exception.NoCommandException;
import org.apache.log4j.Logger;

import java.util.Map;
import java.util.TreeMap;


public class CommandHolder {
    private static final Logger LOG = Logger.getLogger(CommandHolder.class);

    private static Map<String, Command> commands = new TreeMap<>();

    static {
        //Admin commands
        commands.put("log_out_admin", new AdminLogOutCommand());
        commands.put("log_in_admin", new AdminAutorisationCommand());

        commands.put("all_users", new TakeAllUsersCommand());
        commands.put("vacancies_admin", new TakeAllVacanciesCommand());
        commands.put("messages_admin", new TakeAllMessagesCommand());
        commands.put("applications_admin", new TakeAllApplicationsCommand());

        commands.put("user", new TakeUserCommand());
        commands.put("vacancy", new TakeVacancyByAdminCommand());
        commands.put("message", new TakeMessageCommand());
        commands.put("application", new TakeApplicationCommand());

        commands.put("usapps", new TakeApplicationsOfUserCommand());
        commands.put("usmess", new TakeMessagesForUserCommand());
        commands.put("vapps", new TakeApplicationsOfVacancyCommand());
        commands.put("vdelapps", new TakeDeletedApplicationsOfVacancyCommand());

        commands.put("new_vacancy", new AddNewVacancyCommand());
        commands.put("new_message", new NewMessageCommand());
        commands.put("send_message", new SendMessageCommand());

        commands.put("edit_vacancy", new EditVacancyCommand());
        commands.put("update_vacancy", new UpdateVacancyCommand());

        commands.put("delete_vacancy", new DeleteVacancyCommand());
        commands.put("restore_vacancy", new RestoreVacancyCommand());
        commands.put("deleted_vacancies", new TakeDeletedVacanciesCommand());

        commands.put("delete_application_admin", new DeleteApplicationByAdminCommand());
        commands.put("restore_application", new RestoreApplicationCommand());
        commands.put("deleted_applications", new TakeDeletedApplicationsCommand());

        commands.put("change_status", new ChangeStatusCommand());
        commands.put("recruited_users", new TakeRecruitedUsersCommand());

        //User commands
        commands.put("log_out", new LogOutCommand());
        commands.put("log_in", new AutorisationCommand());

        commands.put("profile", new ProfileCommand());
        commands.put("change_password", new ChangePasswordCommand());

        commands.put("edit_profile", new EditUserCommand());
        commands.put("update_profile", new UpdateUserCommand());

        commands.put("my_messages", new TakeUserMessagesCommand());
        commands.put("my_message", new TakeUserMessageCommand());
        commands.put("my_applications", new TakeUserApplicationsCommand());

        commands.put("new_application", new NewApplicationCommand());

        commands.put("delete_application", new DeleteApplicationCommand());
        commands.put("change_language", new LanguageChangeCommand());

        commands.put("vacancies", new TakeAllVacanciesWithInfoCommand());
        commands.put("registration", new RegistrationCommand());
        commands.put("view_vacancy", new TakeVacancyCommand());
    }

    public static Command get(String commandName) {
        if (commandName == null || !commands.containsKey(commandName)) {
            try {
                throw new NoCommandException();
            } catch (NoCommandException e) {
                LOG.error("Command not found, name --> " + commandName);
            }
        }
        return commands.get(commandName);
    }
}