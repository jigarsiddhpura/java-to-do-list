package dev.jigar.App;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import dev.jigar.Features.Actions;
import dev.jigar.Features.AddTask;
import dev.jigar.Features.MarkAsDone;
import dev.jigar.Features.UpdateTask;

public class ToDoList {
    
    public static Map<String, Task> tasks = new LinkedHashMap<>();
    public static boolean isAppRunning = true;

    public void start() {
        showApplicationTitle();
        while (isAppRunning) {
            showAvailableActions();
            int action = readAction();
            executeAction(action);
        }
    }

    public void showApplicationTitle() {
        System.out.println("ToDo List Application");
        System.out.println("---------------------");
    }

    public void showAvailableActions() {
        System.out.println("Available Actions - ");
        System.out.println("1. Add Task");
        System.out.println("2. Update Task");
        System.out.println("3. Mark Task As Done");
        System.out.println("4. Remove Task");
        System.out.println("5. Display All Tasks");
        System.out.println("6. Sort By Due Date");
        System.out.println("7. Sort By Description");
        System.out.println("8. Save To File");
        System.out.println("8. Read From File");
        System.out.println("9. Exit");
        System.out.println("");
    }

    public int readAction() {
        Scanner sc = new Scanner(System.in);
        List<Integer> availableActions = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        while(true) {
            try {
                System.out.println("Enter your action: ");
                int action = sc.nextInt();
                if (availableActions.contains(action)) {
                    return action;
                } else {
                    System.out.println("Action not available. Choose from above list only");
                }
            } catch (Exception e) {
                System.out.println("Action must be a number");
            }
        }
    }

    public void executeAction(int actionNum) {
        Actions action;
        switch (actionNum) {
            case Actions.ADD_TASK:
                action = new AddTask();
                action.showActionsInformation();
                String input = action.readUserInput();
                action.executeAction(input);
                break;
            
            case Actions.MARK_AS_DONE:
                if (tasks.size() > 0) {
                    action = new MarkAsDone();
                    action.showActionsInformation();
                    String idToMark = action.readUserInput();
                    if (!idToMark.equals("0")) {
                        action.executeAction(idToMark);
                    }
                } else {
                    System.out.println("\nNo tasks in the list. Enter a task first");
                }
                break;
            
            case Actions.UPDATE_TASK:
                if (tasks.size() > 0) {
                    action = new UpdateTask();
                    action.showActionsInformation();
                    String idToMark = action.readUserInput();
                    if (!idToMark.equals("0")) {
                        action.executeAction(idToMark);
                    }
                } else {
                    System.out.println("\nNo tasks in the list. Enter a task first");
                }
                break;
            
        }
    }
}
