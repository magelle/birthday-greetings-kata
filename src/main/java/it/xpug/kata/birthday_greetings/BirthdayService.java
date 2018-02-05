package it.xpug.kata.birthday_greetings;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.ParseException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public class BirthdayService {

	private final BirthdayGreetingsMailSender birthdayGreetingsMailSender;
	private final EmployeeFileReader employeeFileReader = new EmployeeFileReader();

	public BirthdayService(BirthdayGreetingsMailSender birthdayGreetingsMailSender) {
		this.birthdayGreetingsMailSender = birthdayGreetingsMailSender;
	}

	public void sendGreetings(String fileName, AnniversaryDate anniversaryDate) throws IOException, ParseException, AddressException, MessagingException {
		BufferedReader in = employeeFileReader.getEmployeeLineReader(fileName);
		String str;
		while ((str = in.readLine()) != null) {
			Employee employee = employeeFileReader.parseEmployee(str);
			sendGreeting(anniversaryDate, employee);
		}
	}

	private void sendGreeting(AnniversaryDate xDate, Employee employee) throws MessagingException {
		if (employee.isBirthday(xDate)) {
            birthdayGreetingsMailSender.sendMail(employee);
        }
	}

}
