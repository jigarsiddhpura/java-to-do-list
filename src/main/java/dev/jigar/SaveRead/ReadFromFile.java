package dev.jigar.SaveRead;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import dev.jigar.App.Task;
import dev.jigar.App.ToDoList;
import dev.jigar.DataSorting.DateSorting;
import dev.jigar.Features.Actions;

public class ReadFromFile extends Actions{
    
    @Override
    public void showActionsInformation() {
        // eg : file path - src/main/java/dev/jigar/File/file.txt
        System.out.println("\nEnter file path to read from:\n");
        System.out.println("Enter 0 to RETURN");
    }

    @Override
    public String readUserInput() {
        while (true) {
            System.out.println("");
            System.out.print("path:");

            Scanner scan = new Scanner(System.in);
            String userInput = scan.nextLine();

            return userInput;
        }
    }

    @Override
    public void executeAction(String path) {
        try {
            Scanner sc = new Scanner(new File(path));
            while(sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] taskDetails = line.split(",");
                Task task = new Task(taskDetails[0], taskDetails[1], DateSorting.parseDate("dd-MM-yyyy", taskDetails[2]), taskDetails[3], taskDetails[4]);
                
                if (ToDoList.tasks.get(task.getId()) != null) {
                    ToDoList.tasks.replace(task.getId(), task);
                } else {
                    ToDoList.tasks.put(task.getId(), task);
                }
            }

            sc.close();
            System.out.println("task succesfully read from file: " + path);
        } catch (FileNotFoundException e) {
            System.out.println("Path or file do not exist...");

        }
    }


}
