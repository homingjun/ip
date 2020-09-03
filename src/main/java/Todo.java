import java.util.ArrayList;

public class Todo extends Task {
    /**
     * Sets the task description and it's task type to Todo.
     *
     * @param description description of the task
     */
    public Todo(String description) {
        super(description);
        this.taskType = "T";
    }

    /**
     * Returns the newly added task in the list and the number of remaining tasks to complete.
     *
     * @param tasks a list used to store the tasks
     * @param userInput user input
     * @param numberOfTasks number of tasks in the list
     * @return newly added task in the list and the number of remaining tasks to complete
     */
    public static String printToDo(ArrayList<Task> tasks, String userInput, int numberOfTasks, int remainingTasks) {
        String split = userInput.substring(4);
        tasks.add(new Todo(split));
        return "    Ok I add this task to ur list liao:\n" + "    " + tasks.get(numberOfTasks - 1).getTaskType()
                + "[" + tasks.get(numberOfTasks - 1).getStatusIcon() + "]" + split + "\n"
                + "    Now you have " + (remainingTasks) + " more tasks to complete. Good luck!\n";
    }
}
