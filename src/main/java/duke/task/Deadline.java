package duke.task;

import java.util.ArrayList;

import duke.Duke;
import duke.exception.DukeException;

public class Deadline extends Task {
    /**
     * Sets the task description and it's task type to Deadlines.
     *
     * @param description Description of the task.
     */
    public Deadline(String description) {
        super(" " + description + ")");
        this.taskType = "D";
    }

    /**
     * Returns the newly added task in the list and the number of remaining tasks to complete.
     *
     * @param tasks A list used to store the tasks.
     * @param userInput User input.
     * @return Newly added task in the list and the number of remaining tasks to complete.
     * @throws DukeException If no deadline is given or deadline is invalid.
     */
    public static String printDeadline(ArrayList<Task> tasks, String userInput) throws DukeException {
        int byIndex = userInput.indexOf("/by");
        if (userInput.substring(8).isBlank()) {
            throw new DukeException("    Wah u so free ah no deadlines to meet one :>" + Duke.LS);
        } else if (!userInput.contains("/by") || userInput.substring(8, byIndex).isBlank()
                || userInput.substring(byIndex + 3).isBlank()) {
            throw new DukeException("    Ur deadline looks wrong leh pls check it" + Duke.LS);
        }
        String deadline = userInput.substring(9).replace("/by","(by:");
        tasks.add(new Deadline(deadline));
        String taskType = "    " + tasks.get(getNumberOfTasks() - 1).getTaskType();
        String statusIcon = "[" + tasks.get(getNumberOfTasks() - 1).getStatusIcon() + "] "
                + deadline + ")" + Duke.LS;
        String tasksLeft = "    Now you have " + getNumberOfTasks()
                + " tasks in the list." + Duke.LS;
        return ADDED + taskType + statusIcon + tasksLeft;
    }
}
