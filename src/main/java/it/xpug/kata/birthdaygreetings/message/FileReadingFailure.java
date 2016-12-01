package it.xpug.kata.birthdaygreetings.message;

import it.xpug.kata.birthdaygreetings.birthday.Failure;

public class FileReadingFailure implements Failure {

    private String message;

    public FileReadingFailure(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
