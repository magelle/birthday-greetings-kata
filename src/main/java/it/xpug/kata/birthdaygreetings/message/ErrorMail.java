package it.xpug.kata.birthdaygreetings.message;

import it.xpug.kata.birthdaygreetings.birthday.Failure;

public class ErrorMail extends Mail {
    public ErrorMail(String message, Failure failure) {
        super("ip@here.com",
                message + "\nError:\n" + failure.getMessage(),
                "Error");
    }
}
