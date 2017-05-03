package com.andrew.holder;

import com.andrew.command.Command;
import com.andrew.command.RegistrationCommand;
import com.andrew.command.FindAllVacanciesWithInfoCommand;
import com.andrew.command.admin.AdminAutorisationCommand;
import com.andrew.command.admin.AdminLogOutCommand;
import com.andrew.command.admin.application.*;
import com.andrew.command.admin.message.*;
import com.andrew.command.admin.user.ViewAllUsersCommand;
import com.andrew.command.admin.user.ViewRecruitedUsersCommand;
import com.andrew.command.admin.user.ViewUserCommand;
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

        commands.put("all_users", new ViewAllUsersCommand());
        commands.put("vacancies_admin", new ViewAllVacanciesCommand());
        commands.put("messages_admin", new ViewAllMessagesCommand());
        commands.put("applications_admin", new ViewAllApplicationsCommand());

        commands.put("user", new ViewUserCommand());
        commands.put("vacancy", new AdminViewVacancyCommand());
        commands.put("message", new ViewMessageCommand());
        commands.put("application", new ViewApplicationCommand());

        commands.put("usapps", new ViewApplicationsOfUserCommand());
        commands.put("usmess", new ViewMessagesForUserCommand());
        commands.put("vapps", new ViewApplicationsOfVacancyCommand());
        commands.put("vdelapps", new ViewDeletedApplicationsOfVacancyCommand());

        commands.put("new_vacancy", new AddVacancyCommand());
        commands.put("new_message", new NewMessageCommand());
        commands.put("send_message", new SendMessageCommand());

        commands.put("edit_vacancy", new EditVacancyCommand());
        commands.put("update_vacancy", new UpdateVacancyCommand());

        commands.put("delete_vacancy", new DeleteVacancyCommand());
        commands.put("restore_vacancy", new RestoreVacancyCommand());
        commands.put("deleted_vacancies", new ViewDeletedVacanciesCommand());

        commands.put("delete_application_admin", new AdminDeleteApplicationCommand());
        commands.put("restore_application", new RestoreApplicationCommand());
        commands.put("deleted_applications", new ViewDeletedApplicationsCommand());

        commands.put("change_status", new ChangeStatusCommand());
        commands.put("recruited_users", new ViewRecruitedUsersCommand());

        //User commands
        commands.put("log_out", new UserLogOutCommand());
        commands.put("log_in", new UserAutorisationCommand());

        commands.put("profile", new ViewProfileCommand());
        commands.put("change_password", new ChangePasswordCommand());

        commands.put("edit_profile", new EditUserCommand());
        commands.put("update_profile", new UpdateUserCommand());

        commands.put("my_messages", new UserViewMessagesCommand());
        commands.put("my_message", new UserViewMessageCommand());
        commands.put("my_applications", new UserViewApplicationsCommand());

        commands.put("new_application", new NewApplicationCommand());

        commands.put("delete_application", new UserDeleteApplicationCommand());
        commands.put("change_language", new LanguageChangeCommand());

        commands.put("vacancies", new FindAllVacanciesWithInfoCommand());
        commands.put("registration", new RegistrationCommand());
        commands.put("view_vacancy", new ViewVacancyCommand());
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