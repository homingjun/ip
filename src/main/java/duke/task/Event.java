package duke.task;

import java.util.ArrayList;

import duke.Duke;
import duke.exception.DukeException;

public class Event extends Task {
    private String at;

    /**
     * Sets the task description and it's task type to Events.
     *
     * @param description Description of the task.
     */
    public Event(String description, String at) {
        super(description);
        this.at = at;
        this.taskType = "E";
    }

    public String getAt() {
        return at;
    }

    /**
     * Returns the newly added task in the list and the number of remaining tasks to complete.
     *
     * @param tasks A list used to store the tasks.
     * @param userInput User input.
     * @return Newly added task in the list and the number of remaining tasks to complete.
     * @throws DukeException If no event is given or event is invalid.
     */
    public static String printEvent(ArrayList<Task> tasks, String userInput) throws DukeException {
        int atIndex = userInput.indexOf("/at");
        if (userInput.substring(5).isBlank()) {
            throw new DukeException("    Why u nvr give any event sia :<" + Duke.LS);
        } else if (!userInput.contains("/at") || userInput.substring(5, atIndex).isBlank()
                || userInput.substring(atIndex + 3).isBlank()) {
            throw new DukeException("    Ur event seems wrong sia" + Duke.LS);
        }
        String[] event = userInput.substring(5).split("/at ");
        tasks.add(new Event(event[0], event[1]));
        String taskType = "    " + tasks.get(getNumberOfTasks() - 1).getTaskType();
        String statusIcon = "[" + tasks.get(getNumberOfTasks() - 1).getStatusIcon() + "]"
                + event[0] + "(at: " + event[1] + ")" + Duke.LS;
        String tasksLeft = "    Now you have " + getNumberOfTasks()
                + " tasks in the list."+ Duke.LS;
        return ADDED + taskType + statusIcon + tasksLeft;
    }

    @Override
    public String toString() {
        return super.toString().trim() + " (at: " + this.getAt() + ")";
    }
}
