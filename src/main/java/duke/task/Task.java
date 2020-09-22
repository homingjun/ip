package duke.task;

import java.util.ArrayList;

import duke.Duke;
import duke.exception.DukeException;

public abstract class Task {
    private final String description;
    protected String taskType;
    private boolean isDone;
    private static int numberOfTasks = 0;
    private static int completedTasks = 0;
    private static final String CONGRATS = "    Congrats on completing this task! U damn ups :D" + Duke.LS;
    protected static final String ADDED = "    Ok I add this task to ur list liao:" + Duke.LS;
    private static final String TASK_DELETED = "    Ok I deleted it liao" + Duke.LS;

    /**
     * Sets the task description and default it's completion to false.
     *
     * @param description Description of the task.
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
        numberOfTasks++;
    }

    /**
     * Returns the completion status of the task.
     *
     * @return Completion status of the task.
     */
    public String getStatusIcon() {
        //return ✓ or ✘ symbols
        return (isDone ? "✓" : "✘");
    }

    /**
     * Sets the completion status of the task as completed.
     */
    public void markAsDone() {
        isDone = true;
        completedTasks++;
    }

    public void setTaskDeleted() {
        if (isDone) {
            completedTasks--;
        }
        numberOfTasks--;
    }

    /**
     * Returns the description of the task.
     *
     * @return Description of task.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the type of task.
     *
     * @return Type of task.
     */
    public String getTaskType() {
        return "[" + this.taskType + "]";
    }

    /**
     * Returns the number of tasks in the list.
     *
     * @return Number of tasks in the list.
     */
    public static int getNumberOfTasks() {
        return numberOfTasks;
    }

    /**
     * Returns the number of completed tasks in the list.
     *
     * @return Number of completed tasks in the list.
     */
    public static int getCompletedTasks() {
        return completedTasks;
    }

    /**
     * Returns the confirmation of completing a task.
     *
     * @param tasks A list used to store the tasks.
     * @param userInput User input.
     * @return Completion of task.
     * @throws DukeException If the list is empty.
     */
    public static String completeTask(ArrayList<Task> tasks, String userInput) throws DukeException {
        if (tasks.size() == 0) {
            throw new DukeException("no tasks in list");
        }
        String[] words = userInput.split(" ");
        tasks.get(Integer.parseInt(words[1]) - 1).markAsDone();
        Task taskDescription = tasks.get(Integer.parseInt(words[1]) - 1);
        return CONGRATS + "    " + taskDescription + Duke.LS;
    }

    /**
     * Returns the confirmation of task deletion from the list.
     *
     * @param tasks A list used to store the tasks.
     * @param userInput User input.
     * @return Deletion of task.
     * @throws DukeException If the list is empty.
     * @throws NumberFormatException If no number is given.
     */
    public static String deleteTask(ArrayList<Task> tasks, String userInput)
            throws DukeException, NumberFormatException {
        if (tasks.size() == 0) {
            throw new DukeException("    Ps u need to add tasks first before u can set them as complete leh" + Duke.LS);
        } else if (userInput.substring(6).isBlank()) {
            throw new NumberFormatException();
        }
        String[] words = userInput.split(" ");
        tasks.get(Integer.parseInt(words[1]) - 1).setTaskDeleted();
        String taskDescription = tasks.get(Integer.parseInt(words[1]) - 1) + Duke.LS;
        tasks.remove(Integer.parseInt(words[1]) - 1);
        String tasksLeft = "    Now you have " + getNumberOfTasks()
                + " tasks in the list." + Duke.LS;
        return TASK_DELETED + "    " + taskDescription + tasksLeft;
    }



    @Override
    public String toString() {
        return "[" + this.taskType + "]" + "[" + getStatusIcon() + "] " + this.description.trim();
    }
}