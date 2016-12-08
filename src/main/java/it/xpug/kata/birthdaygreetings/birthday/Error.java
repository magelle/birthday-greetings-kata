package it.xpug.kata.birthdaygreetings.birthday;

public class Error implements Failure {

    private final String message;

    public Error(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
