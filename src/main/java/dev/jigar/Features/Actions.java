package dev.jigar.Features;

import java.util.Objects;

public abstract class Actions {
    
    public static final int ADD_TASK = 1;
    public static final int UPDATE_TASK = 2;
    public static final int MARK_AS_DONE = 3;
    public static final int REMOVE_TASK = 4;
    public static final int DISPLAY_ALL_TASKS = 5;
    public static final int SORT_TASKS_BY_DATE = 6;
    public static final int SORT_TASKS_BY_DESC = 7;
    public static final int SAVE_TASKS_TO_FILE = 8;
    public static final int READ_FROM_FILE = 9;
    public static final int EXIT = 10;

    // below is the implementation of `loose coupling` to redue dependencies between features (add, remove, update, etc)

    //  Coupling defines how closely two objects are connected together. There are two types of coupling, loose coupling, and tight coupling.

    // Objects that are independent of one another and do not directly modify the state of other objects is called loosely coupled. Loose coupling makes the code more flexible, changeable, and easier to work with.

    public abstract void showActionsInformation();

    public abstract String readUserInput();

    public abstract void executeAction(String command);

}
