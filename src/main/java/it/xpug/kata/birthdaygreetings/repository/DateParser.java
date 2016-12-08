package it.xpug.kata.birthdaygreetings.repository;

import it.xpug.kata.birthdaygreetings.birthday.Failure;
import it.xpug.kata.birthdaygreetings.util.Result;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateParser {

	public Result<LocalDate, Failure> parse(String yyyyMMdd) {
		if (yyyyMMdd == null)
			return null;
		return Result.success(LocalDate.parse(yyyyMMdd, DateTimeFormatter.ISO_LOCAL_DATE));
	}

}
