import java.util.ArrayList;

public class Events extends Task {
    /**
     * Sets the task description and it's task type to Events.
     *
     * @param description description of the task
     */
    public Events(String description) {
        super(description + ")");
        this.taskType = "E";
    }

    /**
     * Returns the newly added task in the list and the number of remaining tasks to complete.
     *
     * @param tasks a list used to store the tasks
     * @param userInput user input
     * @param numberOfTasks number of tasks in the last
     * @return newly added task in the list and the number of remaining tasks to complete
     */
    public static String printEvent(ArrayList<Task> tasks, String userInput, int numberOfTasks, int remainingTasks) {
        String event = userInput.substring(5).replace("/at","(at:");
        tasks.add(new Events(event));

        return "    Ok I add this task to ur list liao:\n" + "    " + tasks.get(numberOfTasks - 1).getTaskType()
                + "[" + tasks.get(numberOfTasks - 1).getStatusIcon() + "]" + event + ")" + "\n"
                + "    Now you have " + (remainingTasks) + " more tasks to complete. Good luck!\n";
    }
}
