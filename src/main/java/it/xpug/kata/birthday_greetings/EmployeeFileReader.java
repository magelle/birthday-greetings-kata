package it.xpug.kata.birthday_greetings;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

public class EmployeeFileReader {
    public EmployeeFileReader() {
    }

    BufferedReader getEmployeeLineReader(String fileName) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(fileName));
        String str;
        str = in.readLine();
        return in;
    }

    Employee parseEmployee(String str) throws ParseException {
        String[] employeeData = str.split(", ");
        return new Employee(employeeData[1], employeeData[0], employeeData[2], employeeData[3]);
    }
}