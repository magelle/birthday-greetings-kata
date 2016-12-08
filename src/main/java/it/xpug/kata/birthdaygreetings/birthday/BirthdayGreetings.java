package it.xpug.kata.birthdaygreetings.birthday;

import it.xpug.kata.birthdaygreetings.failure.FailureHandler;

import java.time.LocalDate;

public class BirthdayGreetings {

    private final MessageService messageService;
    private final BirthdayComparator birthdayComparator;
    private FailureHandler failureHandler;

    public BirthdayGreetings(MessageService messageService, FailureHandler failureHandler) {
        this.messageService = messageService;
        this.failureHandler = failureHandler;
        birthdayComparator = new BirthdayComparator();
    }

    public void sendGreetings(EmployeeCatalog employeeCatalog, LocalDate date) {
        employeeCatalog.stream()
                .filter(employee -> birthdayComparator.isEmployeeBirthday(employee, date))
                .forEach(messageService::sendBirthdayGreetings);
    }

}
