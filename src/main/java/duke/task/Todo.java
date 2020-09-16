package duke.task;

import java.util.ArrayList;

import duke.Duke;
import duke.exception.DukeException;

public class Todo extends Task {
    /**
     * Sets the task description and it's task type to Todo.
     *
     * @param description description of the duke.task
     */
    public Todo(String description) {
        super(description);
        this.taskType = "T";
    }

    /**
     * Returns the newly added task in the list and the number of remaining tasks to complete.
     *
     * @param tasks a list used to store the tasks
     * @param userInput user input
     * @return newly added duke.task in the list and the number of remaining tasks to complete
     */
    public static String printTodo(ArrayList<Task> tasks, String userInput) throws DukeException {
        if (userInput.substring(4).isBlank()) {
            throw new DukeException("no todo");
        }
        String todo = userInput.substring(4);
        tasks.add(new Todo(todo));
        String taskType = "    " + tasks.get(getNumberOfTasks() - 1).getTaskType();
        String statusIcon = "[" + tasks.get(getNumberOfTasks() - 1).getStatusIcon() + "]" + todo + Duke.LS;
        String tasksLeft = "    Now you have " + (getRemainingTasks())
                + " more tasks to complete. Good luck!" + Duke.LS;
        return ADDED + taskType + statusIcon + tasksLeft;
    }
}
