package com.andrew.command;

import com.andrew.command.general.FindAllVacanciesWithInfoCommand;
import com.andrew.command.user.LanguageChangeCommand;
import com.andrew.command.user.UserAutorisationCommand;
import com.andrew.command.user.UserLogOutCommand;
import com.andrew.command.user.ViewVacancyCommand;


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