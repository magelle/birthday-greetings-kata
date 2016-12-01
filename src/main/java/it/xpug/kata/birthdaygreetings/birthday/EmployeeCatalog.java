package it.xpug.kata.birthdaygreetings.birthday;

import it.xpug.kata.birthdaygreetings.util.Result;

import java.util.List;
import java.util.stream.Stream;

public interface EmployeeCatalog {

    Result<List<EmployeeBirthday>, Failure> getAll();
    Result<Stream<EmployeeBirthday>, Failure> stream();

}
