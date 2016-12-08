package it.xpug.kata.birthdaygreetings.birthday;

import it.xpug.kata.birthdaygreetings.util.Result;

import java.time.LocalDate;

public class EmployeeFactory {
    public Result<Employee, Failure> getInstance(String firstname, String lastname, LocalDate birthdate, String email) {
        if (firstname == null || firstname.isEmpty())
            return Result.failure(new Error("An employee should not have an empty firstname"));

        if (lastname == null || lastname.isEmpty())
            return Result.failure(new Error("An employee should not have an empty lastname"));

        if (birthdate == null)
            return Result.failure(new Error("An employee should not have an empty birthdate"));

        if (email == null || email.isEmpty())
            return Result.failure(new Error("An employee should not have an empty email"));

        return Result.success(new Employee(firstname, lastname, birthdate, email));
    }
}