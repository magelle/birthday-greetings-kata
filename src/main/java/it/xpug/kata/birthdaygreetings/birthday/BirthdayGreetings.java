package it.xpug.kata.birthdaygreetings.birthday;

public class BirthdayGreetings {

    private final MessageService mailService;
    private final EmployeeCatalog employeeCatalog;

    public BirthdayGreetings(EmployeeCatalog employeeCatalog, MessageService mailService) {
        this.employeeCatalog = employeeCatalog;
        this.mailService = mailService;
    }

    public void sendGreetings(MonthDayDate monthDayDate) {
        employeeCatalog.stream()
                .filter(employeeBirthday -> employeeBirthday.isBirthday(monthDayDate))
                .forEach(mailService::sendBirthdayGreetings);
    }

}
