import java.util.ArrayList;

public class Deadline extends Task {
    public static final String ADD_LIAO = "    Ok I add this task to ur list liao:\n";

    /**
     * Sets the task description and it's task type to Deadlines.
     *
     * @param description description of the task
     */
    public Deadline(String description) {
        super(" " + description + ")");
        this.taskType = "D";
    }

    /**
     * Returns the newly added task in the list and the number of remaining tasks to complete.
     *
     * @param tasks a list used to store the tasks
     * @param userInput user input
     * @param numberOfTasks number of tasks in the list
     * @return newly added task in the list and the number of remaining tasks to complete
     */
    public static String printDeadline(ArrayList<Task> tasks, String userInput, int numberOfTasks, int remainingTasks) {
        String deadline = userInput.substring(9).replace("/by","(by:");
        tasks.add(new Deadline(deadline));
        String taskType = "    " + tasks.get(numberOfTasks - 1).getTaskType();
        String statusIcon = "[" + tasks.get(numberOfTasks - 1).getStatusIcon() + "] " + deadline + ")" + "\n";
        String tasksLeft = "    Now you have " + (remainingTasks) + " more tasks to complete. Good luck!\n";
        return ADD_LIAO + taskType + statusIcon + tasksLeft;
    }
}
