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
     * @return newly added task in the list and the number of remaining tasks to complete
     */
    public static String printTodo(ArrayList<Task> tasks, String userInput) {
        String todo = userInput.substring(4);
        tasks.add(new Todo(todo));
        String taskType = "    " + tasks.get(getNumberOfTasks() - 1).getTaskType();
        String statusIcon = "[" + tasks.get(getNumberOfTasks() - 1).getStatusIcon() + "]" + todo + Print.LS;
        String tasksLeft = "    Now you have " + (getRemainingTasks())
                + " more tasks to complete. Good luck!" + Print.LS;
        return ADDED + taskType + statusIcon + tasksLeft;
    }
}
