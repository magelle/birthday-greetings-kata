package it.xpug.kata.birthdaygreetings.birthday;

import it.xpug.kata.birthdaygreetings.failure.FailureHandler;

import java.util.stream.Stream;

public class BirthdayGreetings {

    private final MessageService messageService;
    private FailureHandler failureHandler;

    public BirthdayGreetings(MessageService messageService, FailureHandler failureHandler) {
        this.messageService = messageService;
        this.failureHandler = failureHandler;
    }

    public void sendGreetings(EmployeeCatalog employeeCatalog, Birthdate birthdate) {
        employeeCatalog.stream()
                .handle(
                        stream -> sendGreetings(birthdate, stream),
                        failureHandler::handleFailure
                );
    }

    private void sendGreetings(Birthdate birthdate, Stream<EmployeeBirthday> stream) {
        stream.filter(employeeBirthday -> employeeBirthday.isBirthday(birthdate))
                .forEach(messageService::sendBirthdayGreetings);
    }

}
