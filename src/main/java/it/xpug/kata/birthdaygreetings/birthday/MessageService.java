package it.xpug.kata.birthdaygreetings.birthday;

import it.xpug.kata.birthdaygreetings.message.Mail;

public interface MessageService {
    void sendMessage(Mail greetingsMail);
    void sendErrorMessage(String message, Failure failure);
    void sendBirthdayGreetings(Employee employeeBirthday);
}
