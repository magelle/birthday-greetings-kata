package it.xpug.kata.birthdaygreetings.birthday;

import java.time.LocalDate;
import java.time.temporal.ChronoField;

public class BirthdayComparator {
    public BirthdayComparator() {
    }

    boolean isEmployeeBirthday(Employee employee, LocalDate date) {
        LocalDate birthdate = employee.getBirthday();
        return birthdate.get(ChronoField.MONTH_OF_YEAR) == date.get(ChronoField.MONTH_OF_YEAR)
                && birthdate.get(ChronoField.DAY_OF_MONTH) == date.get(ChronoField.DAY_OF_MONTH);
    }
}