package it.xpug.kata.birthdaygreetings;

import static org.junit.Assert.*;

import it.xpug.kata.birthdaygreetings.birthday.MonthDayDate;
import org.junit.*;



public class MonthDayDateTest {
	@Test
	public void getters() throws Exception {
		MonthDayDate date = new MonthDayDate("1789/01/24");
		assertEquals(1, date.getMonth());
		assertEquals(24, date.getDay());
	}

	@Test
	public void isSameDate() throws Exception {
		MonthDayDate date = new MonthDayDate("1789/01/24");
		MonthDayDate sameDay = new MonthDayDate("2001/01/24");
		MonthDayDate notSameDay = new MonthDayDate("1789/01/25");
		MonthDayDate notSameMonth = new MonthDayDate("1789/02/25");

		assertTrue("same", date.isSameDay(sameDay));
		assertFalse("not same day", date.isSameDay(notSameDay));
		assertFalse("not same month", date.isSameDay(notSameMonth));
	}

	@Test
	public void equality() throws Exception {
		MonthDayDate base = new MonthDayDate("2000/01/02");
		MonthDayDate same = new MonthDayDate("2000/01/02");
		MonthDayDate different = new MonthDayDate("2000/01/04");

		assertFalse(base.equals(null));
		assertFalse(base.equals(""));
		assertTrue(base.equals(base));
		assertTrue(base.equals(same));
		assertFalse(base.equals(different));
	}

}
