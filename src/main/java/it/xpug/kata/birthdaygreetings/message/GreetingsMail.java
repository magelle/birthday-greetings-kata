package it.xpug.kata.birthdaygreetings.message;

import it.xpug.kata.birthdaygreetings.birthday.EmployeeBirthday;

public class GreetingsMail extends Mail {

    GreetingsMail(EmployeeBirthday employeeBirthday) {
        super(employeeBirthday.getEmail(),
                "Happy Birthday, dear %NAME%".replace("%NAME%", employeeBirthday.getFirstName()),
                "Happy Birthday!");
    }

}
