package it.xpug.kata.birthdaygreetings.message;

public abstract class Mail {

    final String recipient;
    final String body;
    final String subject;

    public Mail(String recipient, String body, String subject) {
        this.recipient = recipient;
        this.body = body;
        this.subject = subject;
    }
}
