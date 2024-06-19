package dev.jigar.App;

import java.time.LocalDate;

import dev.jigar.DataSorting.DateSorting;

public class Task {
    private String id;
    private String title;
    private LocalDate dueDate;
    private String status;
    private String description;
    
    public Task(String id, String title, LocalDate dueDate, String status, String description) {
        this.id = id;
        this.title = title;
        this.dueDate = dueDate;
        this.status = status;
        this.description = description;
    }
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

    public void setTitle(String _title) {
        this.title = _title;
    }
    public void setDueDate(LocalDate _date) {
        this.dueDate = _date;
    }
    public void setStatus(String _status) {
        this.status = _status;
    }
    public void setDescription(String _desc) {
        this.description = _desc;
    }

    @Override
    public String toString() {
        return id + "," + title + "," + DateSorting.convertDateToString(dueDate, "dd-MM-yyyy") + "," + status + "," + description;
    }

}
