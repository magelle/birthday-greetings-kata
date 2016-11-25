package it.xpug.kata.birthdaygreetings.message;

import it.xpug.kata.birthdaygreetings.birthday.EmployeeBirthday;

public class GreetingsMail {
    final String recipient;
    final String body;
    final String subject;

    GreetingsMail(EmployeeBirthday employeeBirthday) {
        recipient = employeeBirthday.getEmail();
        body = "Happy Birthday, dear %NAME%".replace("%NAME%", employeeBirthday.getFirstName());
        subject = "Happy Birthday!";
    }

}
