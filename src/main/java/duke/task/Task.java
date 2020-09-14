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
    private static final String EMPTY_LIST = "    Your list still empty eh please add sth leh" + Duke.LS;
    private static final String ALL_TASKS_COMPLETED = "    Wah u finished all ur tasks! Nice la!" + Duke.LS;
    private static final String NO_TASKS_COMPLETED = "    U haven't done any tasks yet... U shud start soon!"
            + Duke.LS;
    private static final String SOME_TASKS_COMPLETED = "    U still got some tasks left to do. Jia you!"
            + Duke.LS;
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
        String statusIcon = "    [" + tasks.get(Integer.parseInt(words[1]) - 1).getStatusIcon() + "] ";
        String taskDescription = tasks.get(Integer.parseInt(words[1]) - 1).getDescription();
        return CONGRATS + statusIcon + taskDescription + Duke.LS;
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
        String taskType = "    " + tasks.get(Integer.parseInt(words[1]) - 1).getTaskType();
        String statusIcon = "[" + tasks.get(Integer.parseInt(words[1]) - 1).getStatusIcon() + "] ";
        String taskDescription = tasks.get(Integer.parseInt(words[1]) - 1).getDescription() + Duke.LS;
        tasks.remove(Integer.parseInt(words[1]) - 1);
        String tasksLeft = "    Now you have " + getNumberOfTasks()
                + " tasks in the list." + Duke.LS;
        return TASK_DELETED + taskType + statusIcon + taskDescription + tasksLeft;
    }

    /**
     * Returns the respective list description based on the number of tasks and completed tasks.
     *
     * @param numberOfTasks Number of tasks in the list.
     * @param completedTasks Number of completed tasks in the list.
     * @return List description.
     */
    public static String printListDescription(int numberOfTasks, int completedTasks) {
        if (numberOfTasks == 0) {
            return EMPTY_LIST;
        } else if (completedTasks == numberOfTasks) {
            return ALL_TASKS_COMPLETED;
        } else if (completedTasks == 0) {
            return NO_TASKS_COMPLETED;
        } else {
            return SOME_TASKS_COMPLETED;
        }
    }

    /**
     * Returns the tasks in the list along with the status of the task.
     *
     * @param tasks A list used to store the tasks.
     * @param numberOfTasks Number of tasks in the list.
     * @return List of tasks.
     */
    public static String printListItems(ArrayList<Task> tasks, int numberOfTasks) {
        String listItems = "";
        for (int i = 0; i < numberOfTasks; i++) {
            listItems += "    " + (i + 1) + "." + tasks.get(i).getTaskType() + "["
                    + tasks.get(i).getStatusIcon() + "]" + tasks.get(i).getDescription() + Duke.LS;
        }
        return listItems;
    }
}