package dev.jigar.Features;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import dev.jigar.App.Task;
import dev.jigar.App.ToDoList;
import dev.jigar.DataSorting.DateSorting;

public class AddTask extends Actions {

    @Override
    public void showActionsInformation() {
        System.out.println("Follow Below Format To Add Task");
        System.out.println("<unique_id>,<title_of_the_task>,<due-date-in-format:DD-MM-YYYY>,<status>,<description>");
        System.out.println("");
    }

    @Override
    public String readUserInput() {
        while(true) {
            System.out.println("Enter task - ");
            Scanner sc = new Scanner(System.in);
            String userInput = sc.nextLine();

            String[] taskDetails = userInput.split(",");

            if (taskDetails.length == 5) {
                if (DateSorting.isDateValid("dd-MM-yyyy", taskDetails[2])) {
                    if (ToDoList.tasks.get(taskDetails[0]) == null) {
                        return userInput;
                    } else {
                        System.out.println("ID already exists");
                    }
                } else {
                    System.out.println("Input must have correct date format");
                }
            } else {
                System.out.println("Input must be in mentioned format");
            }
        }
    }

    @Override
    public void executeAction(String command) {
        String[] taskDetails = command.split(",");
        Task task = new Task(taskDetails[0], taskDetails[1], DateSorting.parseDate("dd-MM-yyyy", taskDetails[2]), taskDetails[3], taskDetails[4]);

        ToDoList.tasks.put(task.getId(), task);
        System.out.println("\ndev.jigar.App.Task successfully");
    }

    
}
