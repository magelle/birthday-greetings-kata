package it.xpug.kata.birthdaygreetings;
import it.xpug.kata.birthdaygreetings.birthday.EmployeeBirthday;
import it.xpug.kata.birthdaygreetings.birthday.Birthdate;
import it.xpug.kata.birthdaygreetings.repository.Employee;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;



public class EmployeeTest {

	@Test
	public void testBirthday() throws Exception {
		EmployeeBirthday employeeBirthday = new Employee("foo", "bar", new Birthdate("1990/01/31"), "a@b.c");
		assertFalse("not his birthday", employeeBirthday.isBirthday(new Birthdate("2008/01/30")));
		assertTrue("his birthday", employeeBirthday.isBirthday(new Birthdate("2008/01/31")));
	}

	@Test
	public void equality() throws Exception {
		EmployeeBirthday base = new Employee("First", "Last", new Birthdate("1999/09/01"), "first@last.com");
		EmployeeBirthday same = new Employee("First", "Last", new Birthdate("1999/09/01"), "first@last.com");
		EmployeeBirthday different = new Employee("First", "Last", new Birthdate("1999/09/01"), "boom@boom.com");

		assertFalse(base.equals(null));
		assertFalse(base.equals(""));
		assertTrue(base.equals(same));
		assertFalse(base.equals(different));
	}
}
