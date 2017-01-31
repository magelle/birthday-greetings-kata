package it.xpug.kata.birthdaygreetings.message;

import it.xpug.kata.birthdaygreetings.birthday.Employee;
import it.xpug.kata.birthdaygreetings.birthday.MessageService;
import it.xpug.kata.birthdaygreetings.message.mail.MailService;

import javax.mail.MessagingException;

public class MailMessageService implements MessageService {
    private final MailService mailService;

    public MailMessageService(MailService mailService) {
        this.mailService = mailService;
    }

    public void sendBirthdayGreetings(Employee employeeBirthday) {
        sendMessage(new GreetingsMail(employeeBirthday));
    }

    public void sendMessage(Mail mail) {
        try {
            sendMessage("sender@here.com", mail);
        } catch (MessagingException e) {
            throw new RuntimeException("Error while sending mail", e);
        }
    }

    private void sendMessage(String sender, Mail mail) throws MessagingException {
        mailService.sendMessage(sender, mail.subject, mail.body, mail.recipient);
    }
}