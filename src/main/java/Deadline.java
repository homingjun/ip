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
     * @param numberOfTasks number of tasks in the list
     * @return newly added task in the list and the number of remaining tasks to complete
     */
    public static String printDeadline(ArrayList<Task> tasks, String userInput, int numberOfTasks, int remainingTasks) {
        String deadline = userInput.substring(9).replace("/by","(by:");
        tasks.add(new Deadline(deadline));
        return "    Ok I add this task to ur list liao:\n" + "    " + tasks.get(numberOfTasks - 1).getTaskType()
                + "[" + tasks.get(numberOfTasks - 1).getStatusIcon() + "] " + deadline + ")" + "\n"
                + "    Now you have " + (remainingTasks) + " more tasks to complete. Good luck!\n";
    }
}
