package it.xpug.kata.birthdaygreetings.birthday;

import java.util.List;
import java.util.stream.Stream;

public interface EmployeeCatalog {

    List<EmployeeBirthday> getAll();
    Stream<EmployeeBirthday> stream();

}
