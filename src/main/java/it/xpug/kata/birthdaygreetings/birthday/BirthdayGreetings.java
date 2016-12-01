package it.xpug.kata.birthdaygreetings.birthday;

import java.util.stream.Stream;

public class BirthdayGreetings {

    private final MessageService messageService;

    public BirthdayGreetings(MessageService messageService) {
        this.messageService = messageService;
    }

    public void sendGreetings(EmployeeCatalog employeeCatalog, Birthdate birthdate) {
        employeeCatalog.stream()
                .handle(
                        stream -> sendGreetings(birthdate, stream),
                        this::sendErrorMessage
                );
    }

    private void sendGreetings(Birthdate birthdate, Stream<EmployeeBirthday> stream) {
        stream.filter(employeeBirthday -> employeeBirthday.isBirthday(birthdate))
                .forEach(messageService::sendBirthdayGreetings);
    }

    private void sendErrorMessage(Failure failure) {
        messageService.sendErrorMessage("Error while sending brithday greetings", failure);
    }

}
