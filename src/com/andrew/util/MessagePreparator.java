package com.andrew.util;

/**
 * Created by Andrew on 20.04.2017.
 */
public class MessagePreparator {

    public static String prepareStatusChangedMessage(String applicantName, String vacancyPosition, String newStatus) {
        return "Hello, " + applicantName + ".\n" + "Your applicant status for the vacancy "
                + vacancyPosition + " has been changed on '" + newStatus + "'.";
    }

    public static String prepareVacancyDeletedMessage(String vacancyPosition) {
        return "Vacancy '" + vacancyPosition + "' has been deleted. Work with us on other positions.";
    }
}
