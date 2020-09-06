import java.util.ArrayList;

public class Deadline extends Task {
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
     * @return newly added task in the list and the number of remaining tasks to complete
     */
    public static String printDeadline(ArrayList<Task> tasks, String userInput) {
        String deadline = userInput.substring(9).replace("/by","(by:");
        tasks.add(new Deadline(deadline));
        String taskType = "    " + tasks.get(getNumberOfTasks() - 1).getTaskType();
        String statusIcon = "[" + tasks.get(getNumberOfTasks() - 1).getStatusIcon() + "] " + deadline + ")" + Print.LS;
        String tasksLeft = "    Now you have " + (getRemainingTasks())
                + " more tasks to complete. Good luck!" + Print.LS;
        return ADDED + taskType + statusIcon + tasksLeft;
    }
}
