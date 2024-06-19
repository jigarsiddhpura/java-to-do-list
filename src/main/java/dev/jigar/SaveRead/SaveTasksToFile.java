package dev.jigar.SaveRead;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import dev.jigar.App.Task;
import dev.jigar.App.ToDoList;
import dev.jigar.Features.Actions;

public class SaveTasksToFile extends Actions {
    @Override
    public void showActionsInformation() {
        System.out.println("\nPlease enter path to read:\n");
        System.out.println("Enter 0 to RETURN");
    }

    @Override
    public String readUserInput() {
        while (true) {
            System.out.println("Enter path: ");
            Scanner sc = new Scanner(System.in);
            String userInput = sc.nextLine();
            return userInput;
        }
    }

    @Override
    public void executeAction(String path) {
        try {
            // FileOutputStream - used for writing streams to a file
            // When you create a new FileOutputStream, it opens the file specified by the path. If the file does not exist, it will create a new file. If the file already exists, it will be truncated (its content will be cleared).
            PrintWriter pw = new PrintWriter(path);

            List<String> lines = new ArrayList<>();
            for(Map.Entry<String, Task> entry : ToDoList.tasks.entrySet()) {
                lines.add(entry.getValue().toString());
            }

            for(String line : lines) {
                pw.println(line);
            }
            pw.close();
            System.out.println("task succesfully saved into file: " + path);

        } catch (FileNotFoundException e) {
            System.out.println("Path or file doesn't exist..");
        }
    }
}
