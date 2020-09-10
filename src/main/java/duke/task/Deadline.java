package duke.task;

import java.util.ArrayList;

import duke.Duke;
import duke.exception.DukeException;

public class Deadline extends Task {
    /**
     * Sets the duke.task description and it's duke.task type to Deadlines.
     *
     * @param description description of the duke.task
     */
    public Deadline(String description) {
        super(" " + description + ")");
        this.taskType = "D";
    }

    /**
     * Returns the newly added duke.task in the list and the number of remaining tasks to complete.
     *
     * @param tasks a list used to store the tasks
     * @param userInput user input
     * @return newly added duke.task in the list and the number of remaining tasks to complete
     */
    public static String printDeadline(ArrayList<Task> tasks, String userInput) throws DukeException {
        int byIndex = userInput.indexOf("/by");
        if (userInput.substring(8).isBlank()) {
            throw new DukeException("no deadline");
        } else if (!userInput.contains("/by") || userInput.substring(8, byIndex).isBlank()
                || userInput.substring(byIndex + 3).isBlank()) {
            throw new DukeException("invalid deadline");
        }
        String deadline = userInput.substring(9).replace("/by","(by:");
        tasks.add(new Deadline(deadline));
        String taskType = "    " + tasks.get(getNumberOfTasks() - 1).getTaskType();
        String statusIcon = "[" + tasks.get(getNumberOfTasks() - 1).getStatusIcon() + "] "
                + deadline + ")" + Duke.LS;
        String tasksLeft = "    Now you have " + (getRemainingTasks())
                + " more tasks to complete. Good luck!" + Duke.LS;
        return ADDED + taskType + statusIcon + tasksLeft;
    }
}
