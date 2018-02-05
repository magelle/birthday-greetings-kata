package it.xpug.kata.birthday_greetings;

import java.io.*;
import java.text.ParseException;

import javax.mail.*;
import javax.mail.internet.*;

public class Main {

	public static void main(String[] args) throws AddressException, IOException, ParseException, MessagingException {
		BirthdayService service = new BirthdayService(new BirthdayGreetingsMailSender("localhost", 25, "sender@here.com"));
		service.sendGreetings("employee_data.txt", new AnniversaryDate());
	}

}
