package it.xpug.kata.birthdaygreetings.birthday;

import java.time.LocalDate;
import java.util.function.Predicate;

public class BirthdayComparator {
    private final DateUtils dateUtils = new DateUtils();

    public BirthdayComparator() {
    }

    Predicate<Employee> isEmployeeBirthday(LocalDate date) {
        Predicate<LocalDate> isSameDayFct = dateUtils.isSameDay(date);
        return (Employee employee) -> isSameDayFct.test(employee.getBirthday());
    }
}