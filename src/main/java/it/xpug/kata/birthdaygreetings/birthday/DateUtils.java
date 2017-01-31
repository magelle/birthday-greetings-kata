package it.xpug.kata.birthdaygreetings.birthday;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.function.Predicate;

public class DateUtils {
    public DateUtils() {
    }

    Predicate<LocalDate> isSameDay(LocalDate date) {
        return (LocalDate date2) ->
                date2.get(ChronoField.MONTH_OF_YEAR) == date.get(ChronoField.MONTH_OF_YEAR)
                && date2.get(ChronoField.DAY_OF_MONTH) == date.get(ChronoField.DAY_OF_MONTH);
    }
}