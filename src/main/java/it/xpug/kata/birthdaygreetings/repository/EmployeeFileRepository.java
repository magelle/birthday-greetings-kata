package it.xpug.kata.birthdaygreetings.repository;

import it.xpug.kata.birthdaygreetings.birthday.EmployeeBirthday;
import it.xpug.kata.birthdaygreetings.birthday.EmployeeCatalog;
import it.xpug.kata.birthdaygreetings.birthday.MonthDayDate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeFileRepository implements EmployeeCatalog {
    private String fileName;

    public EmployeeFileRepository(String fileName) {
        this.fileName = fileName;
    }

    public List<EmployeeBirthday> getAll() {
        return parseEmployes();
    }

    private List<EmployeeBirthday> parseEmployes() {
        return stream().collect(Collectors.toList());
    }

    private EmployeeBirthday parseEmployee(String str) {
        String[] employeeData = str.split(", ");
        try {
            return new Employee(employeeData[1], employeeData[0], new MonthDayDate(employeeData[2]), employeeData[3]);
        } catch (ParseException e) {
            throw new RuntimeException("Error while reading employees file", e);
        }
    }

    public Stream<EmployeeBirthday> stream() {
        try {
            Path path = Paths.get(fileName);
            return Files.lines(path)
                    .skip(1)
                    .map(this::parseEmployee);
        } catch (IOException e) {
            throw new RuntimeException("Error while reading employees file", e);
        }
    }
}