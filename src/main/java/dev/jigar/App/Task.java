package dev.jigar.App;

import java.time.LocalDate;

public class Task {
    private String id;
    private String title;
    private LocalDate dueDate;
    private String status;
    private String description;

    public String getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public LocalDate getDueDate() {
        return dueDate;
    }
    public String getStatus() {
        return status;
    }
    public String getDescription() {
        return description;
    }
}
