import java.util.ArrayList;

public class Todo extends Task {
    public static final String ADD_LIAO = "    Ok I add this task to ur list liao:\n";

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
    public static String printTodo(ArrayList<Task> tasks, String userInput, int numberOfTasks, int remainingTasks) {
        String todo = userInput.substring(4);
        tasks.add(new Todo(todo));
        String taskType = "    " + tasks.get(numberOfTasks - 1).getTaskType();
        String statusIcon = "[" + tasks.get(numberOfTasks - 1).getStatusIcon() + "]" + todo + "\n";
        String tasksLeft = "    Now you have " + (remainingTasks) + " more tasks to complete. Good luck!\n";
        return ADD_LIAO + taskType + statusIcon + tasksLeft;
    }
}
