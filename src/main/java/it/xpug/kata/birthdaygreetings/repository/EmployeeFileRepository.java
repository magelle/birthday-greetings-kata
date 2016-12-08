package it.xpug.kata.birthdaygreetings.repository;

import it.xpug.kata.birthdaygreetings.birthday.Employee;
import it.xpug.kata.birthdaygreetings.birthday.EmployeeCatalog;
import it.xpug.kata.birthdaygreetings.birthday.EmployeeFactory;
import it.xpug.kata.birthdaygreetings.birthday.Failure;
import it.xpug.kata.birthdaygreetings.util.Result;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.stream.Stream;

public class EmployeeFileRepository implements EmployeeCatalog {

    private final EmployeeFactory employeeFactory;
    private final String fileName;
    private final DateParser dateParser;

    public EmployeeFileRepository(String fileName, EmployeeFactory employeeFactory) {
        this.fileName = fileName;
        this.employeeFactory = employeeFactory;
        this.dateParser = new DateParser();
    }

    private Result<Employee, Failure> parseEmployee(String str) {
        String[] employeeData = str.split(", ");
        return dateParser.parse(employeeData[2])
                .recover(failure -> Result.failure("Unable to parse emplyee birthdate"))
                .map(date -> employeeFactory.getInstance(employeeData[1], employeeData[0], date, employeeData[3])).get();
    }

    public Stream<Employee> stream() {
        try {
            Path path = Paths.get(fileName);
            return Files.lines(path)
                    .skip(1)
                    .map(this::parseEmployee)
                    .filter(Result::isSuccess)
                    .map(Result::getValue)
                    .map(Optional::get);
        } catch (IOException e) {
            return Stream.empty();
        }
    }
}