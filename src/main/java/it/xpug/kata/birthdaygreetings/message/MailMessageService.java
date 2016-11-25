package it.xpug.kata.birthdaygreetings.message;

import it.xpug.kata.birthdaygreetings.birthday.EmployeeBirthday;
import it.xpug.kata.birthdaygreetings.birthday.MessageService;
import it.xpug.kata.birthdaygreetings.message.mail.MailService;

import javax.mail.MessagingException;

public class MailMessageService implements MessageService {
    private final MailService mailService;

    public MailMessageService(MailService mailService) {
        this.mailService = mailService;
    }

    public void sendBirthdayGreetings(EmployeeBirthday employeeBirthday) {
        sendMessage(new GreetingsMail(employeeBirthday));
    }

    public void sendMessage(GreetingsMail greetingsMail) {
        try {
            sendMessage("sender@here.com", greetingsMail);
        } catch (MessagingException e) {
            throw new RuntimeException("Error while sending mail", e);
        }
    }

    private void sendMessage(String sender, GreetingsMail greetingsMail) throws MessagingException {
        mailService.sendMessage(sender, greetingsMail.subject, greetingsMail.body, greetingsMail.recipient);
    }
}