package com.andrew.command;

import com.andrew.command.all.FindAllVacanciesWithInfoCommand;
import com.andrew.command.user.ViewVacancyCommand;


public enum CommandEnum {

    vacancies {
        {
            this.command = new FindAllVacanciesWithInfoCommand();
        }
    },

    view_vacancy {
        {
            this.command = new ViewVacancyCommand();
        }
    };

    Command command;

    public Command getCurrentCommand() {
        return command;
    }
}