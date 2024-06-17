package dev.jigar.App;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ToDoList {
    
    public static Map<String, Task> tasks = new LinkedHashMap<>();
    public static boolean isAppRunning = true;

    public void start() {
        showApplicationTitle();
        while (isAppRunning) {
            showAvailableActions();
            int action = readAction();
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
        System.out.println("4. Get Task");
        System.out.println("5. Display All Tasks");
        System.out.println("6. Sort By Due Date");
        System.out.println("7. Display All Tasks");
        System.out.println("8. Save to file");
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
}