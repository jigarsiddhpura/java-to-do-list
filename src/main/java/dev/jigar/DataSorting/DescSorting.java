package dev.jigar.DataSorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import dev.jigar.App.Task;
import dev.jigar.App.ToDoList;
import dev.jigar.Features.Actions;

public class DescSorting extends Actions{

    @Override
    public void showActionsInformation() {
        throw new UnsupportedOperationException("The requested operation is not supported.")
    }
    @Override
    public String readUserInput() {
        throw new UnsupportedOperationException("The requested operation is not supported.")
    }

    @Override
    public void executeAction(String command) {

        List<Map.Entry<String, Task>> entries = new ArrayList<>(ToDoList.tasks.entrySet());

        Collections.sort(entries, new Comparator<Map.Entry<String, Task>>() {

            @Override
            public int compare(Map.Entry<String, Task> task1, Map.Entry<String, Task> task2) {
                String date1 = task1.getValue().getDescription();
                String date2 = task2.getValue().getDescription();
                return date1.compareTo(date2);
            }
        });

        ToDoList.tasks.clear();
        for(Map.Entry<String, Task> entry : entries) {
            ToDoList.tasks.put(entry.getKey(), entry.getValue());
        }

        System.out.println("Task sorted by description successfully");
    }


}
