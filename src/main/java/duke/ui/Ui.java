package duke.ui;

import duke.exception.DukeException;
import duke.task.Task;
import duke.task.TaskList;

import java.util.ArrayList;

public class Ui {
    /**
     * Returns greetings from the bot.
     *
     * @return Greetings.
     */
    public static String printGreetings() {
        return Messages.GREETINGS;
    }

    /**
     * Prints a line wrap around the text.
     *
     * @param text Content getting printed.
     */
    public static void printLine(String text) {
        System.out.print(Messages.LINE + text + Messages.LINE);
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
            return Messages.EMPTY_LIST;
        } else if (completedTasks == numberOfTasks) {
            return Messages.ALL_TASKS_COMPLETED;
        } else if (completedTasks == 0) {
            return Messages.NO_TASKS_COMPLETED;
        } else {
            return Messages.SOME_TASKS_COMPLETED;
        }
    }

    /**
     * Returns the tasks in the list along with the status of the task.
     *
     * @param tasks An arraylist of tasks.
     * @return List of tasks.
     */
    public static String printListItems(TaskList tasks) {
        ArrayList<Task> taskList = tasks.getTaskList();
        String listItems = "";
        int taskNumber = 1;
        for (Task t : taskList) {
            listItems += "    " + taskNumber + ". " + t + Messages.LS;
            taskNumber++;
        }
        return listItems;
    }

    /**
     * Returns the matching items in the task list.
     *
     * @param tasks An arraylist of tasks.
     * @param userInput User input.
     * @return Matching list of tasks.
     * @throws DukeException If the item is not found in the list.
     */
    public static String printFoundItems(TaskList tasks, String userInput) throws DukeException {
        ArrayList<Task> taskList = tasks.getTaskList();
        String item = userInput.substring(4).trim();
        int taskNumber = 1;
        String itemsFound = "";
        for (Task t : taskList)  {
            if (t.getDescription().contains(item)) {
                itemsFound  += "    " + taskNumber + ". " + t + Messages.LS;
                taskNumber++;
            }
        }
        if (itemsFound.isEmpty()) {
            throw new DukeException(Messages.ITEM_NOT_FOUND);
        }
        return Messages.ITEMS_FOUND + itemsFound;
    }

    /**
     * Returns goodbye greeting from the bot.
     *
     * @return Goodbye.
     */
    public static String sayGoodbye() {
        return Messages.BYE;
    }

    /**
     * Returns a prompt to re-enter the input when an invalid input is entered.
     *
     * @return Invalid input warning.
     */
    public static String invalidInput() {
        return Messages.INVALID_INPUT;
    }

    /**
     * Returns the newly added task in the list and the number of remaining tasks to complete.
     *
     * @param tasks A list used to store the tasks.
     * @param userInput User input.
     * @return Newly added task in the list and the number of remaining tasks to complete.
     * @throws DukeException If the no todo is given.
     */
    public static String printTodo(TaskList tasks, String userInput) throws DukeException {
        if (userInput.substring(4).isBlank()) {
            throw new DukeException(Messages.NO_TODO);
        }
        String todo = userInput.substring(4);
        String taskType = "    " + tasks.getTask(Task.getNumberOfTasks()).getTaskType();
        String statusIcon = "[" + tasks.getTask(Task.getNumberOfTasks()).getStatusIcon() + "]" + todo + Messages.LS;
        String tasksLeft = Messages.NOW_YOU_HAVE + Task.getNumberOfTasks()
                + Messages.TASKS_IN_LIST;
        return Messages.ADDED + taskType + statusIcon + tasksLeft;
    }

    /**
     * Returns the newly added task in the list and the number of remaining tasks to complete.
     *
     * @param tasks A list used to store the tasks.
     * @param userInput User input.
     * @return Newly added task in the list and the number of remaining tasks to complete.
     */
    public static String printDeadline(TaskList tasks, String userInput) {
        String[] deadline = userInput.substring(9).split("/by ");
        String taskType = "    " + tasks.getTask(Task.getNumberOfTasks()).getTaskType();
        String statusIcon = "[" + tasks.getTask(Task.getNumberOfTasks()).getStatusIcon() + "] "
                + deadline[0] + "(by: " + tasks.getTask(Task.getNumberOfTasks()).getDateAndTime() + ")" + Messages.LS;
        String tasksLeft = Messages.NOW_YOU_HAVE + Task.getNumberOfTasks() + Messages.TASKS_IN_LIST;
        return Messages.ADDED + taskType + statusIcon + tasksLeft;
    }

    /**
     * Returns the newly added task in the list and the number of remaining tasks to complete.
     *
     * @param tasks A list used to store the tasks.
     * @param userInput User input.
     * @return Newly added task in the list and the number of remaining tasks to complete.
     */
    public static String printEvent(TaskList tasks, String userInput) {
        String[] event = userInput.substring(5).split("/at ");
        String taskType = "    " + tasks.getTask(Task.getNumberOfTasks()).getTaskType();
        String statusIcon = "[" + tasks.getTask(Task.getNumberOfTasks()).getStatusIcon() + "]"
                + event[0] + "(at: " + tasks.getTask(Task.getNumberOfTasks()).getDateAndTime() + ")" + Messages.LS;
        String tasksLeft = Messages.NOW_YOU_HAVE + Task.getNumberOfTasks()
                + Messages.TASKS_IN_LIST;
        return Messages.ADDED + taskType + statusIcon + tasksLeft;
    }

    /**
     * Returns the confirmation of completing a task.
     *
     * @param tasks A list used to store the tasks.
     * @param userInput User input.
     * @return Completion of task.
     * @throws DukeException If the list is empty.
     */
    public static String printTaskCompletion(TaskList tasks, String userInput) throws DukeException {
        if (tasks.getSize() == 0) {
            throw new DukeException(Messages.NOTHING_TO_COMPLETE);
        }
        String[] words = userInput.split(" ");
        tasks.getTask(Integer.parseInt(words[1])).markAsDone();
        Task taskDescription = tasks.getTask(Integer.parseInt(words[1]));
        return Messages.CONGRATS + "    " + taskDescription + Messages.LS;
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
    public static String printTaskDeletion(TaskList tasks, String userInput)
            throws DukeException, NumberFormatException {
        if (tasks.getSize() == 0) {
            throw new DukeException(Messages.NOTHING_TO_DELETE);
        } else if (userInput.substring(6).isBlank()) {
            throw new NumberFormatException();
        }
        String[] words = userInput.split(" ");
        tasks.getTask(Integer.parseInt(words[1])).setTaskDeleted();
        String taskDescription = tasks.getTask(Integer.parseInt(words[1])) + Messages.LS;
        String tasksLeft = Messages.NOW_YOU_HAVE + Task.getNumberOfTasks()
                + Messages.TASKS_IN_LIST;
        return Messages.TASK_DELETED + "    " + taskDescription + tasksLeft;
    }
}
