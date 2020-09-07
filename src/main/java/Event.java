import java.util.ArrayList;

public class Event extends Task {
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
     * @return newly added task in the list and the number of remaining tasks to complete
     */
    public static String printEvent(ArrayList<Task> tasks, String userInput) throws DukeException {
        int atIndex = userInput.indexOf("/at");
        if (userInput.substring(5).isBlank()) {
            throw new DukeException("no event");
        } else if (!userInput.contains("/at") || userInput.substring(5, atIndex).isBlank()
                || userInput.substring(atIndex + 3).isBlank()) {
            throw new DukeException("invalid event");
        }
        String event = userInput.substring(5).replace("/at","(at:");
        tasks.add(new Event(event));
        String taskType = "    " + tasks.get(getNumberOfTasks() - 1).getTaskType();
        String statusIcon = "[" + tasks.get(getNumberOfTasks() - 1).getStatusIcon() + "]" + event + ")" + Print.LS;
        String tasksLeft = "    Now you have " + (getRemainingTasks())
                + " more tasks to complete. Good luck!"+ Print.LS;
        return ADDED + taskType + statusIcon + tasksLeft;
    }
}
