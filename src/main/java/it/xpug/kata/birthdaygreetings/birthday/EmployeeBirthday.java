package it.xpug.kata.birthdaygreetings.birthday;

public interface EmployeeBirthday {
    boolean isBirthday(Birthdate today);

    String getEmail();

    String getFirstName();
}
