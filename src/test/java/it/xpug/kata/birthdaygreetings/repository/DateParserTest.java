package it.xpug.kata.birthdaygreetings.repository;

import org.junit.Test;

/**
 * Created by gelle on 08/12/2016.
 */
public class DateParserTest {
    @Test
    public void parse() throws Exception {
        new DateParser().parse("2011-01-01");
    }

}