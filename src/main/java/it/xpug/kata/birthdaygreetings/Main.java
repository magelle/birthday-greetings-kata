package it.xpug.kata.birthdaygreetings;

import it.xpug.kata.birthdaygreetings.birthday.BirthdayGreetings;
import it.xpug.kata.birthdaygreetings.birthday.EmployeeCatalog;
import it.xpug.kata.birthdaygreetings.birthday.EmployeeFactory;
import it.xpug.kata.birthdaygreetings.birthday.MessageService;
import it.xpug.kata.birthdaygreetings.failure.FailureHandler;
import it.xpug.kata.birthdaygreetings.failure.MessageFailureHandler;
import it.xpug.kata.birthdaygreetings.message.MailMessageService;
import it.xpug.kata.birthdaygreetings.message.mail.MailService;
import it.xpug.kata.birthdaygreetings.repository.EmployeeFileRepository;

import javax.mail.MessagingException;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;

public class Main {

	private final EmployeeCatalog employeeCatalog;
	private final BirthdayGreetings service;

	public Main() {
		EmployeeFactory employeeFactory = new EmployeeFactory();
		MailService mailService = new MailService("localhost", 25);
		MessageService messageService = new MailMessageService(mailService);
		FailureHandler failureHandler = new MessageFailureHandler(messageService);

		employeeCatalog = new EmployeeFileRepository("employee_data.txt", employeeFactory);
		service = new BirthdayGreetings(messageService, failureHandler);
	}

	public static void main(String[] args) throws IOException, ParseException, MessagingException {
		new Main().run();
	}

	public void run () {
		service.sendGreetings(employeeCatalog, LocalDate.now());
	}

}
