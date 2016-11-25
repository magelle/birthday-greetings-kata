package it.xpug.kata.birthdaygreetings.birthday;

import it.xpug.kata.birthdaygreetings.message.GreetingsMail;

public interface MessageService {
    void sendMessage(GreetingsMail greetingsMail);
    void sendBirthdayGreetings(EmployeeBirthday employeeBirthday);
}
