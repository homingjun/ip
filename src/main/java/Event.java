import java.util.ArrayList;

public class Event extends Task {
    public static final String ADD_LIAO = "    Ok I add this task to ur list liao:\n";

    /**
     * Sets the task description and it's task type to Events.
     *
     * @param description description of the task
     */
    public Event(String description) {
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
        tasks.add(new Event(event));
        String taskType = "    " + tasks.get(numberOfTasks - 1).getTaskType();
        String statusIcon = "[" + tasks.get(numberOfTasks - 1).getStatusIcon() + "]" + event + ")" + "\n";
        String tasksLeft = "    Now you have " + (remainingTasks) + " more tasks to complete. Good luck!\n";
        return ADD_LIAO + taskType + statusIcon + tasksLeft;
    }
}
