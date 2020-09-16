package duke.task;

import java.util.ArrayList;

import duke.Duke;
import duke.exception.DukeException;

public class Event extends Task {
    private String at;

    /**
     * Sets the task description and it's task type to Events.
     *
     * @param description description of the duke.task
     */
    public Event(String description, String at) {
        super(description + "(at:" + at + ")");
        this.at = at;
        this.taskType = "E";
    }

    public String getAt() {
        return at;
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
        String[] event = userInput.substring(5).split("/at ");
        tasks.add(new Event(event[0], event[1]));
        String taskType = "    " + tasks.get(getNumberOfTasks() - 1).getTaskType();
        String statusIcon = "[" + tasks.get(getNumberOfTasks() - 1).getStatusIcon() + "]"
                + event[0] + "(at:" + event[1] + ")" + Duke.LS;
        String tasksLeft = "    Now you have " + (getRemainingTasks())
                + " more tasks to complete. Good luck!"+ Duke.LS;
        return ADDED + taskType + statusIcon + tasksLeft;
    }
}
