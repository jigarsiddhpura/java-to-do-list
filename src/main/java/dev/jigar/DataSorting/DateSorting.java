package dev.jigar.DataSorting;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import dev.jigar.App.Task;
import dev.jigar.App.ToDoList;
import dev.jigar.Features.Actions;

public class DateSorting extends Actions{

    @Override
    public void showActionsInformation() {
        throw new UnsupportedOperationException("The requested operation is not supported.");
    }
    @Override
    public String readUserInput() {
        throw new UnsupportedOperationException("The requested operation is not supported.");
    }

    @Override
    public void executeAction(String command) {

        List<Map.Entry<String, Task>> entries = new ArrayList<>(ToDoList.tasks.entrySet());

        Collections.sort(entries, new Comparator<Map.Entry<String, Task>>() {

            @Override
            public int compare(Map.Entry<String, Task> task1, Map.Entry<String, Task> task2) {
                LocalDate date1 = task1.getValue().getDueDate();
                LocalDate date2 = task2.getValue().getDueDate();
                return date1.compareTo(date2);
            }
        });

        ToDoList.tasks.clear();
        for(Map.Entry<String, Task> entry : entries) {
            ToDoList.tasks.put(entry.getKey(), entry.getValue());
        }

        System.out.println("Task sorted by due date successfully");
    }

    public static String convertDateToString(LocalDate date, String format) {
        DateTimeFormatter formattings = DateTimeFormatter.ofPattern(format);
        String result = null;
        try {
            result = date.format(formattings);
        } catch (DateTimeParseException e) {

        }
        return result;
    }

    // ⭐ .parse : (String->LocalDate) :: .format : (LocalDate->String)

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
