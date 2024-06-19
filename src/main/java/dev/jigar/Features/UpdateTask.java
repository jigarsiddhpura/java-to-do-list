package dev.jigar.Features;

import java.util.Scanner;

import dev.jigar.App.Task;
import dev.jigar.App.ToDoList;
import dev.jigar.DataSorting.DateSorting;

public class UpdateTask extends Actions{
    @Override
    public void showActionsInformation() {
        System.out.println("to update a task, follow the instructions and press ENTER: ");
        System.out.println("<unique_id>,<title_of_the_task>,<due-date-in-format:DD-MM-YYYY>,<status>,<description>");
        System.out.println("ID here represent the ID of the task u wanna update");
        System.out.println("insert a (-) if update is not required in the specific parameter\n");
    }

    @Override
    public String readUserInput() {
        while (true) {
            System.out.println("Enter the information - ");
            Scanner sc = new Scanner(System.in);
            String userInput = sc.nextLine();

            if (!userInput.equals("0")) {
                String[] taskDetails = userInput.split(",");
                if (taskDetails.length == 5) {

                    if (ToDoList.tasks.get(taskDetails[0]) != null) {
                        boolean isDateValid = true, dateValidationRequired = true;
                        if (taskDetails[2].equals("-")) {
                            dateValidationRequired = false;
                        }

                        if (dateValidationRequired) {
                            isDateValid = DateSorting.isDateValid("dd-MM-yyyy", taskDetails[2]);
                        }

                        if (isDateValid) {
                            return userInput;   
                        } else {
                            System.out.println("Please follow instructions. try again:");
                        }
                    } else {
                        System.out.println("ID doesn't exist, try again: ");
                    }

                } else {
                    return userInput;
                }
            }
        }
    }

    @Override
    public void executeAction(String command) {
        String[] taskDetails = command.split(",");

        boolean taskEdited = false;
        if (!taskDetails[1].equals("-")) {
            ToDoList.tasks.get(taskDetails[0]).setTitle(taskDetails[1]);
            taskEdited = true;
        }
        if (!taskDetails[2].equals("-")) {
            ToDoList.tasks.get(taskDetails[0]).setDueDate(DateSorting.parseDate("dd-MM-yyyy", taskDetails[2]));
            taskEdited = true;
        }
        if (!taskDetails[3].equals("-")) {
            ToDoList.tasks.get(taskDetails[0]).setStatus(taskDetails[3]);
            taskEdited = true;
        }
        if (!taskDetails[4].equals("-")) {
            ToDoList.tasks.get(taskDetails[0]).setDescription(taskDetails[4]);
            taskEdited = true;
        }

        if (taskEdited) {
            System.out.println("Task updated successfully");
        } else {
            System.out.println("No changes applied");
        }
    }
}
