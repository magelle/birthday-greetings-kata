package it.xpug.kata.birthdaygreetings;

import com.dumbster.smtp.SimpleSmtpServer;
import com.dumbster.smtp.SmtpMessage;
import it.xpug.kata.birthdaygreetings.birthday.BirthdayGreetings;
import it.xpug.kata.birthdaygreetings.birthday.EmployeeFactory;
import it.xpug.kata.birthdaygreetings.repository.DateParser;
import it.xpug.kata.birthdaygreetings.failure.FailureHandler;
import it.xpug.kata.birthdaygreetings.failure.MessageFailureHandler;
import it.xpug.kata.birthdaygreetings.message.MailMessageService;
import it.xpug.kata.birthdaygreetings.message.mail.MailService;
import it.xpug.kata.birthdaygreetings.repository.EmployeeFileRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;


public class AcceptanceTest {

	private static final int NONSTANDARD_PORT = 9999;
	private BirthdayGreetings birthdayGreetings;
	private SimpleSmtpServer mailServer;
	private EmployeeFileRepository employeeCatalog;
	private MailMessageService birthdayGreetingsMailService;
	private MailService mailService;
	private FailureHandler failureHandler;

	@Before
	public void setUp() throws Exception {
		mailServer = SimpleSmtpServer.start(NONSTANDARD_PORT);
		EmployeeFactory employeeFactory = new EmployeeFactory();
		employeeCatalog = new EmployeeFileRepository("employee_data.txt", employeeFactory);
		mailService = new MailService("localhost", NONSTANDARD_PORT);
		birthdayGreetingsMailService = new MailMessageService(mailService);
		failureHandler = new MessageFailureHandler(birthdayGreetingsMailService);
		birthdayGreetings = new BirthdayGreetings(birthdayGreetingsMailService, failureHandler);
	}

	@After
	public void tearDown() throws Exception {
		mailServer.stop();
		Thread.sleep(200);
	}

	@Test
	public void willSendGreetings_whenItsSomebodysBirthday() throws Exception {

		birthdayGreetings.sendGreetings(employeeCatalog, parseDate("2008-10-08"));

		assertEquals("message not sent?", 1, mailServer.getReceivedEmailSize());
		SmtpMessage message = (SmtpMessage) mailServer.getReceivedEmail().next();
		assertEquals("Happy Birthday, dear John", message.getBody());
		assertEquals("Happy Birthday!", message.getHeaderValue("Subject"));
		String[] recipients = message.getHeaderValues("To");
		assertEquals(1, recipients.length);
		assertEquals("john.doe@foobar.com", recipients[0].toString());
	}

	@Test
	public void willNotSendEmailsWhenNobodysBirthday() throws Exception {
		birthdayGreetings.sendGreetings(employeeCatalog, parseDate("2008-01-01"));

		assertEquals("what? messages?", 0, mailServer.getReceivedEmailSize());
	}

	private LocalDate parseDate(String yyyyMMdd) {
		return new DateParser().parse(yyyyMMdd).getValue().get();
	}
}
