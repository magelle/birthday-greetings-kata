package it.xpug.kata.birthday_greetings;

import static org.junit.Assert.*;

import org.junit.*;



public class AnniversaryDateTest {
	@Test
	public void getters() throws Exception {
		AnniversaryDate date = new AnniversaryDate("1789/01/24");
		assertEquals(1, date.getMonth());
		assertEquals(24, date.getDay());
	}

	@Test
	public void isSameDate() throws Exception {
		AnniversaryDate date = new AnniversaryDate("1789/01/24");
		AnniversaryDate sameDay = new AnniversaryDate("2001/01/24");
		AnniversaryDate notSameDay = new AnniversaryDate("1789/01/25");
		AnniversaryDate notSameMonth = new AnniversaryDate("1789/02/25");

		assertTrue("same", date.isSameDay(sameDay));
		assertFalse("not same day", date.isSameDay(notSameDay));
		assertFalse("not same month", date.isSameDay(notSameMonth));
	}

	@Test
	public void equality() throws Exception {
		AnniversaryDate base = new AnniversaryDate("2000/01/02");
		AnniversaryDate same = new AnniversaryDate("2000/01/02");
		AnniversaryDate different = new AnniversaryDate("2000/01/04");

		assertFalse(base.equals(null));
		assertFalse(base.equals(""));
		assertTrue(base.equals(base));
		assertTrue(base.equals(same));
		assertFalse(base.equals(different));
	}

}
