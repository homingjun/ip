package duke.task;

import java.util.ArrayList;

import duke.Duke;
import duke.exception.DukeException;

public class Event extends Task {
    /**
     * Sets the duke.task description and it's duke.task type to Events.
     *
     * @param description description of the duke.task
     */
    public Event(String description) {
        super(description + ")");
        this.taskType = "E";
    }

    /**
     * Returns the newly added duke.task in the list and the number of remaining tasks to complete.
     *
     * @param tasks a list used to store the tasks
     * @param userInput user input
     * @return newly added duke.task in the list and the number of remaining tasks to complete
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
        String statusIcon = "[" + tasks.get(getNumberOfTasks() - 1).getStatusIcon() + "]"
                + event + ")" + Duke.LS;
        String tasksLeft = "    Now you have " + (getRemainingTasks())
                + " more tasks to complete. Good luck!"+ Duke.LS;
        return ADDED + taskType + statusIcon + tasksLeft;
    }
}
