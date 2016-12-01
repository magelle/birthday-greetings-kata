package it.xpug.kata.birthdaygreetings.repository;

import it.xpug.kata.birthdaygreetings.birthday.EmployeeBirthday;
import it.xpug.kata.birthdaygreetings.birthday.EmployeeCatalog;
import it.xpug.kata.birthdaygreetings.birthday.Birthdate;
import it.xpug.kata.birthdaygreetings.birthday.Failure;
import it.xpug.kata.birthdaygreetings.message.FileReadingFailure;
import it.xpug.kata.birthdaygreetings.util.Result;

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

    public Result<List<EmployeeBirthday>, Failure> getAll() {
        return parseEmployes();
    }

    private Result<List<EmployeeBirthday>, Failure> parseEmployes() {
        return stream().map(stream -> stream.collect(Collectors.toList()));
    }

    private EmployeeBirthday parseEmployee(String str) {
        String[] employeeData = str.split(", ");
        try {
            return new Employee(employeeData[1], employeeData[0], new Birthdate(employeeData[2]), employeeData[3]);
        } catch (ParseException e) {
            throw new RuntimeException("Error while reading employees file", e);
        }
    }

    public Result<Stream<EmployeeBirthday>, Failure> stream() {
        try {
            Path path = Paths.get(fileName);
            return Result.success(
                    Files.lines(path)
                    .skip(1)
                    .map(this::parseEmployee)
            );
        } catch (IOException e) {
            return Result.failure(new FileReadingFailure(e.getMessage()));
        }
    }
}