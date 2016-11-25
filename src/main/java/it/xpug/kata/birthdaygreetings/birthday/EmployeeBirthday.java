package it.xpug.kata.birthdaygreetings.birthday;

public interface EmployeeBirthday {
    boolean isBirthday(MonthDayDate today);

    String getEmail();

    String getFirstName();
}
