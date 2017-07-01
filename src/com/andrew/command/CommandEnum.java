package com.andrew.command;

import com.andrew.command.admin.AdminAutorisationCommand;
import com.andrew.command.admin.AdminLogOutCommand;
import com.andrew.command.admin.application.*;
import com.andrew.command.admin.message.*;
import com.andrew.command.admin.user.ViewAllUsersCommand;
import com.andrew.command.admin.user.ViewRecruitedUsersCommand;
import com.andrew.command.admin.user.ViewUserCommand;
import com.andrew.command.admin.vacancy.*;
import com.andrew.command.general.FindAllVacanciesWithInfoCommand;
import com.andrew.command.general.RegistrationCommand;
import com.andrew.command.user.*;


enum CommandEnum {

    vacancies {
        {
            this.command = new FindAllVacanciesWithInfoCommand();
        }
    },

    view_vacancy {
        {
            this.command = new ViewVacancyCommand();
        }
    },

    log_in {
        {
            this.command = new UserAutorisationCommand();
        }
    },

    log_out {
        {
            this.command = new UserLogOutCommand();
        }
    },

    registration {
        {
            this.command = new RegistrationCommand();
        }
    },

    delete_application {
        {
            this.command = new UserDeleteApplicationCommand();
        }
    },

    new_application {
        {
            this.command = new NewApplicationCommand();
        }
    },

    my_applications {
        {
            this.command = new UserViewApplicationsCommand();
        }
    },

    my_message {
        {
            this.command = new UserViewMessageCommand();
        }
    },

    my_messages {
        {
            this.command = new UserViewMessagesCommand();
        }
    },

    update_profile {
        {
            this.command = new UpdateUserCommand();
        }
    },

    edit_profile {
        {
            this.command = new EditUserCommand();
        }
    },

    change_password {
        {
            this.command = new ChangePasswordCommand();
        }
    },

    profile {
        {
            this.command = new ViewProfileCommand();
        }
    },

    // Admin commands

    recruited_users {
        {
            this.command = new ViewRecruitedUsersCommand();
        }
    },

    change_status {
        {
            this.command = new ChangeStatusCommand();
        }
    },

    deleted_applications {
        {
            this.command = new ViewDeletedApplicationsCommand();
        }
    },

    restore_application {
        {
            this.command = new RestoreApplicationCommand();
        }
    },

    delete_application_admin {
        {
            this.command = new AdminDeleteApplicationCommand();
        }
    },

    deleted_vacancies {
        {
            this.command = new ViewDeletedVacanciesCommand();
        }
    },

    restore_vacancy {
        {
            this.command = new RestoreVacancyCommand();
        }
    },

    delete_vacancy {
        {
            this.command = new DeleteVacancyCommand();
        }
    },

    update_vacancy {
        {
            this.command = new UpdateVacancyCommand();
        }
    },

    edit_vacancy {
        {
            this.command = new EditVacancyCommand();
        }
    },

    send_message {
        {
            this.command = new SendMessageCommand();
        }
    },

    new_message {
        {
            this.command = new NewMessageCommand();
        }
    },

    new_vacancy {
        {
            this.command = new AddVacancyCommand();
        }
    },

    vdelapps {
        {
            this.command = new ViewDeletedApplicationsOfVacancyCommand();
        }
    },

    vapps {
        {
            this.command = new ViewApplicationsOfVacancyCommand();
        }
    },

    usmess {
        {
            this.command = new ViewMessagesForUserCommand();
        }
    },

    usapps {
        {
            this.command = new ViewApplicationsOfUserCommand();
        }
    },

    application {
        {
            this.command = new ViewApplicationCommand();
        }
    },

    message {
        {
            this.command = new ViewMessageCommand();
        }
    },

    vacancy {
        {
            this.command = new AdminViewVacancyCommand();
        }
    },

    user {
        {
            this.command = new ViewUserCommand();
        }
    },

    applications_admin {
        {
            this.command = new ViewAllApplicationsCommand();
        }
    },

    messages_admin {
        {
            this.command = new ViewAllMessagesCommand();
        }
    },

    vacancies_admin {
        {
            this.command = new ViewAllVacanciesCommand();
        }
    },

    all_users {
        {
            this.command = new ViewAllUsersCommand();
        }
    },

    log_in_admin {
        {
            this.command = new AdminAutorisationCommand();
        }
    },

    log_out_admin {
        {
            this.command = new AdminLogOutCommand();
        }
    },

    change_language {
        {
            this.command = new LanguageChangeCommand();
        }
    };


    Command command;

    public Command getCurrentCommand() {
        return command;
    }
}

