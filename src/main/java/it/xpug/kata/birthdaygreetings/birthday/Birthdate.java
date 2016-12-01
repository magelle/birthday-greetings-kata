package it.xpug.kata.birthdaygreetings.birthday;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Birthdate {

	private Date date;

	public Birthdate() {
		date = new Date();
	}

	public Birthdate(String yyyyMMdd) throws ParseException {
		date = new SimpleDateFormat("yyyy/MM/dd").parse(yyyyMMdd);
	}

	public int getDay() {
		return getPartOfDate(GregorianCalendar.DAY_OF_MONTH);
	}

	public int getMonth() {
		return 1 + getPartOfDate(GregorianCalendar.MONTH);
	}

	public boolean isSameDay(Birthdate anotherDate) {
		return anotherDate.getDay() == this.getDay() && anotherDate.getMonth() == this.getMonth();
	}

	@Override
	public int hashCode() {
		return date.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Birthdate))
			return false;
		Birthdate other = (Birthdate) obj;
		return other.date.equals(this.date);
	}

	private int getPartOfDate(int part) {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		return calendar.get(part);
	}
}
