package dev.jigar.DataSorting;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateSorting {

    public static boolean isDateValid(String format, String value) {
        DateTimeFormatter formattings = DateTimeFormatter.ofPattern(format);
        try {
            LocalDate localDate = LocalDate.parse(value, formattings);
            String result = localDate.format(formattings);
            return result.equals(value);
        } catch (Exception e) {
            System.out.println("Date validation failed");
        }
        return false;
    }


    public static LocalDate parseDate(String format, String value) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        LocalDate localDate = LocalDate.parse(value,formatter);
        return localDate;
    }
}
