package it.xpug.kata.birthdaygreetings;

import it.xpug.kata.birthdaygreetings.birthday.Birthdate;
import it.xpug.kata.birthdaygreetings.birthday.BirthdayGreetings;
import it.xpug.kata.birthdaygreetings.birthday.EmployeeCatalog;
import it.xpug.kata.birthdaygreetings.birthday.MessageService;
import it.xpug.kata.birthdaygreetings.failure.FailureHandler;
import it.xpug.kata.birthdaygreetings.failure.MessageFailureHandler;
import it.xpug.kata.birthdaygreetings.message.MailMessageService;
import it.xpug.kata.birthdaygreetings.message.mail.MailService;
import it.xpug.kata.birthdaygreetings.repository.EmployeeFileRepository;

import javax.mail.MessagingException;
import java.io.IOException;
import java.text.ParseException;

public class Main {

	public static void main(String[] args) throws IOException, ParseException, MessagingException {
		EmployeeCatalog employeeCatalog = new EmployeeFileRepository("employee_data.txt");
		MailService mailService = new MailService("localhost", 25);
		MessageService messageService = new MailMessageService(mailService);
		FailureHandler failureHandler = new MessageFailureHandler(messageService);

		BirthdayGreetings service = new BirthdayGreetings(messageService, failureHandler);
		service.sendGreetings(employeeCatalog, new Birthdate());
	}

}
