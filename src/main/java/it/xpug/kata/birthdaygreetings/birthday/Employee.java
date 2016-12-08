package it.xpug.kata.birthdaygreetings.birthday;

import java.time.LocalDate;

public class Employee {

    private final String firstname;
    private final String lastname;
    private final LocalDate birthday;
    private final String email;

    Employee(String firstname, String lastname, LocalDate birthday, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthday = birthday;
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public String getEmail() {
        return email;
    }
}
