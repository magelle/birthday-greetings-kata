package it.xpug.kata.birthdaygreetings;

import static org.junit.Assert.*;

import it.xpug.kata.birthdaygreetings.birthday.Birthdate;
import org.junit.*;



public class BirthdateTest {
	@Test
	public void getters() throws Exception {
		Birthdate date = new Birthdate("1789/01/24");
		assertEquals(1, date.getMonth());
		assertEquals(24, date.getDay());
	}

	@Test
	public void isSameDate() throws Exception {
		Birthdate date = new Birthdate("1789/01/24");
		Birthdate sameDay = new Birthdate("2001/01/24");
		Birthdate notSameDay = new Birthdate("1789/01/25");
		Birthdate notSameMonth = new Birthdate("1789/02/25");

		assertTrue("same", date.isSameDay(sameDay));
		assertFalse("not same day", date.isSameDay(notSameDay));
		assertFalse("not same month", date.isSameDay(notSameMonth));
	}

	@Test
	public void equality() throws Exception {
		Birthdate base = new Birthdate("2000/01/02");
		Birthdate same = new Birthdate("2000/01/02");
		Birthdate different = new Birthdate("2000/01/04");

		assertFalse(base.equals(null));
		assertFalse(base.equals(""));
		assertTrue(base.equals(base));
		assertTrue(base.equals(same));
		assertFalse(base.equals(different));
	}

}
