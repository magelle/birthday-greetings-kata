package it.xpug.kata.birthdaygreetings.failure;

import it.xpug.kata.birthdaygreetings.birthday.Failure;
import it.xpug.kata.birthdaygreetings.birthday.MessageService;

public class MessageFailureHandler implements FailureHandler {
    private final MessageService messageService;

    public MessageFailureHandler(MessageService messageService) {
        this.messageService = messageService;
    }

    @Override
    public void handleFailure(Failure failure) {
        messageService.sendErrorMessage("Error while sending brithday greetings", failure);
    }
}