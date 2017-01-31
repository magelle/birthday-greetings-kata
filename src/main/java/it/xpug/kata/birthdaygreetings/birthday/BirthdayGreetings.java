package it.xpug.kata.birthdaygreetings.birthday;

import java.time.LocalDate;
import java.util.function.Predicate;

public class BirthdayGreetings {

    private final MessageService messageService;
    private final BirthdayComparator birthdayComparator;

    public BirthdayGreetings(MessageService messageService) {
        this.messageService = messageService;
        birthdayComparator = new BirthdayComparator();
    }

    public void sendGreetings(EmployeeCatalog employeeCatalog, LocalDate date) {
        Predicate<Employee> isEmployeeBirthday = birthdayComparator.isEmployeeBirthday(date);
        employeeCatalog.stream()
                .filter(isEmployeeBirthday)
                .forEach(messageService::sendBirthdayGreetings);
    }

}
