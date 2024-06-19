package dev.jigar.Features;

import java.util.Map;

import dev.jigar.App.Task;
import dev.jigar.App.ToDoList;

public class DisplayTasks extends Actions{
    
    @Override
    public void showActionsInformation() {
        System.out.println("\nBelow are all the tasks\n");
    }

    @Override
    public String readUserInput() {
        throw new UnsupportedOperationException("The requested operation is not supported");
    }

    @Override
    public void executeAction(String command){
        // ToDoList.tasks.forEach((key, task) -> {
        //     System.out.println("ID: " + key + ", Title: " + task.getTitle() + ", Due date: " + task.getDueDate() + ", Status: " + task.getStatus() + ", Description: " + task.getDescription());
        // });
        for(Map.Entry<String,Task> entry : ToDoList.tasks.entrySet()) {
            String key = entry.getKey();
            Task task = entry.getValue();
            System.out.println("ID: " + key + ", Title: " + task.getTitle() + ", Due date: " + task.getDueDate() + ", Status: " + task.getStatus() + ", Description: " + task.getDescription());
        }
        System.out.println("");
    }
}
