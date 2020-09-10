package duke.task;

import java.util.ArrayList;

import duke.Duke;
import duke.exception.DukeException;

public class Task {
    private final String description;
    protected String taskType;
    private boolean isDone;
    private static int numberOfTasks = 0;
    private static int completedTasks = 0;
    private static int remainingTasks;
    private static final String CONGRATS = "    Congrats on completing this task! U damn ups :D" + Duke.LS;
    private static final String EMPTY_LIST = "    Your list still empty eh please add sth leh" + Duke.LS;
    private static final String ALL_TASKS_COMPLETED = "    Wah u finished all ur tasks! Nice la!" + Duke.LS;
    private static final String NO_TASKS_COMPLETED = "    U haven't done any tasks yet... U shud start soon!"
            + Duke.LS;
    private static final String SOME_TASKS_COMPLETED = "    U still got some tasks left to do. Jia you!"
            + Duke.LS;
    protected static final String ADDED = "    Ok I add this task to ur list liao:" + Duke.LS;


    /**
     * Sets the duke.task description and default it's completion to false.
     *
     * @param description description of the duke.task
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
        numberOfTasks++;
        remainingTasks = numberOfTasks - completedTasks;
    }

    /**
     * Returns the completion status of the duke.task
     *
     * @return completion status of the duke.task
     */
    public String getStatusIcon() {
        //return ✓ or ✘ symbols
        return (isDone ? "✓" : "✘");
    }

    /**
     * Sets the completion status of the duke.task as completed.
     */
    public void markAsDone() {
        isDone = true;
        completedTasks++;
    }

    /**
     * Returns the description of the duke.task.
     *
     * @return description of duke.task
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the type of duke.task.
     *
     * @return type of duke.task
     */
    public String getTaskType() {
        return "[" + this.taskType + "]";
    }

    /**
     * Returns the number of tasks in the list
     *
     * @return number of tasks in the list
     */
    public static int getNumberOfTasks() {
        return numberOfTasks;
    }

    /**
     * Returns the number of completed tasks in the list
     *
     * @return number of completed tasks in the list
     */
    public static int getCompletedTasks() {
        return completedTasks;
    }

    /**
     * Returns the remaining tasks in the list
     *
     * @return remaining tasks in the list
     */
    public static int getRemainingTasks() {
        return remainingTasks;
    }

    /**
     * Returns the confirmation of completing a duke.task.
     *
     * @param tasks a list used to store the tasks
     * @param userInput user input
     * @return completion of duke.task
     */
    public static String completeTask(ArrayList<Task> tasks, String userInput)
            throws IndexOutOfBoundsException, DukeException {
        String[] words = userInput.split(" ");
        if (tasks.size() == 0) {
            throw new DukeException("no tasks in list");
        } else if (userInput.substring(4).isBlank()) {
            throw new NumberFormatException();
        } else if (Integer.parseInt(userInput.substring(5)) > tasks.size()) {
            throw new IndexOutOfBoundsException();
        }
        tasks.get(Integer.parseInt(words[1]) - 1).markAsDone();
        String statusIcon = "    [" + tasks.get(Integer.parseInt(words[1]) - 1).getStatusIcon() + "] ";
        String taskDescription = tasks.get(Integer.parseInt(words[1]) - 1).getDescription();
        return CONGRATS + statusIcon + taskDescription + Duke.LS;
    }

    /**
     * Returns the respective list description based on the number of tasks and completed tasks
     *
     * @param numberOfTasks number of tasks in the list
     * @param completedTasks number of completed tasks in the list
     * @return list description
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
     * Returns the tasks in the list along with the status of the .
     *
     * @param tasks a list used to store the tasks
     * @param numberOfTasks number of tasks in the list
     * @return list of tasks
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