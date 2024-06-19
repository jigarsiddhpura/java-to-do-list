package dev.jigar.Features;

import java.util.Scanner;

import dev.jigar.App.Task;
import dev.jigar.App.ToDoList;

public class RemoveTask extends Actions{
    @Override
    public void showActionsInformation() {
        System.out.println("\nTo remove a task, enter ID and press ENTER\n");
        System.out.println("Enter 0 to RETURN");
    }

    @Override
    public String readUserInput() {

        while (true) {
            System.out.println("");
            System.out.print("Enter ID: ");
            Scanner in = new Scanner(System.in);
            try {
                String userInput = in.nextLine();
                if (!userInput.equals("0")) {
                    Task task = ToDoList.tasks.get(userInput);
                    if (task != null) {
                        return userInput;
                    } else {
                        System.out.println("ID doesn't exist, try another ID: ");
                    }
                } else {
                    return userInput;
                }

            } catch (Exception err) {
                System.out.println("Please enter a valid ID or 0 to RETURN");
            }
        }
    }

    @Override
    public void executeAction(String command) {
        ToDoList.tasks.remove(command);

        System.out.println("IP.TodoListApplication.App.Task with ID: " + command + ", was successfully removed...");

    }
}
