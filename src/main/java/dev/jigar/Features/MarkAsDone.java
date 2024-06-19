package dev.jigar.Features;

import java.util.Scanner;

import dev.jigar.App.Task;
import dev.jigar.App.ToDoList;

public class MarkAsDone extends Actions{
    @Override
    public void showActionsInformation() {
        System.out.println("To mark a task as done, enter ID and press ENTER:");
        System.out.println("");
    }

    @Override
    public String readUserInput() {
        while(true) {
            System.out.println("Enter task ID - ");
            
            try {
                Scanner sc = new Scanner(System.in);
                String userInput = sc.nextLine();
                if (!userInput.equals("0")) {
                    Task task = ToDoList.tasks.get(userInput);
                    if (task != null) {
                        return userInput;
                    } else {
                        System.out.println("No task found with ID " + userInput + ". Please try again");
                    }
                } else {
                    return userInput;
                }
            } catch (Exception e) {
                System.out.println("Enter a valid ID or or 0 to RETURN");
            }   
        }
    }

    @Override
    public void executeAction(String command) {
        ToDoList.tasks.get(command).setStatus("Done");
        System.out.println("\ndev.jigar.App.Task successfully marked as done");
    }
}
