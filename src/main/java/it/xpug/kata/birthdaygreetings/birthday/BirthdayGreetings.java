package it.xpug.kata.birthdaygreetings.birthday;

import it.xpug.kata.birthdaygreetings.util.Result;

import java.util.Optional;
import java.util.stream.Stream;

public class BirthdayGreetings {

    private final MessageService messageService;

    public BirthdayGreetings(MessageService messageService) {
        this.messageService = messageService;
    }

    public Optional<Failure> sendGreetings(EmployeeCatalog employeeCatalog, Birthdate birthdate) {
        Result<Stream<EmployeeBirthday>, Failure> employeeStream = employeeCatalog.stream();
        employeeStream.ifSuccess(stream -> stream
                .filter(employeeBirthday -> employeeBirthday.isBirthday(birthdate))
                .forEach(messageService::sendBirthdayGreetings));
        return employeeStream.getFailure();
    }

}
