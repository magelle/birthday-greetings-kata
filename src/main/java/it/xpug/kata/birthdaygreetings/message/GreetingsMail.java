package it.xpug.kata.birthdaygreetings.message;

import it.xpug.kata.birthdaygreetings.birthday.Employee;

public class GreetingsMail extends Mail {

    GreetingsMail(Employee employee) {
        super(employee.getEmail(),
                "Happy Birthday, dear %NAME%".replace("%NAME%", employee.getFirstname()),
                "Happy Birthday!");
    }

}
