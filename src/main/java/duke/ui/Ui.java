package duke.ui;

import duke.exception.DukeException;
import duke.messages.Messages;
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
     * @param tasks A list used to store the tasks.
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
            throw new DukeException("    Pls gimme something to do leh ._." + Messages.LS);
        }
        String todo = userInput.substring(4);
        String taskType = "    " + tasks.getTask(Task.getNumberOfTasks()).getTaskType();
        String statusIcon = "[" + tasks.getTask(Task.getNumberOfTasks()).getStatusIcon() + "]" + todo + Messages.LS;
        String tasksLeft = "    Now you have " + Task.getNumberOfTasks()
                + " tasks in the list." + Messages.LS;
        return Messages.ADDED + taskType + statusIcon + tasksLeft;
    }

    /**
     * Returns the newly added task in the list and the number of remaining tasks to complete.
     *
     * @param tasks A list used to store the tasks.
     * @param userInput User input.
     * @return Newly added task in the list and the number of remaining tasks to complete.
     * @throws DukeException If no deadline is given or deadline is invalid.
     */
    public static String printDeadline(TaskList tasks, String userInput) throws DukeException {
        int byIndex = userInput.indexOf("/by");
        if (userInput.substring(8).isBlank()) {
            throw new DukeException("    Wah u so free ah no deadlines to meet one :>" + Messages.LS);
        } else if (!userInput.contains("/by") || userInput.substring(8, byIndex).isBlank()
                || userInput.substring(byIndex + 3).isBlank()) {
            throw new DukeException("    Ur deadline looks wrong leh pls check it" + Messages.LS);
        }
        String[] deadline = userInput.substring(9).split("/by ");
        String taskType = "    " + tasks.getTask(Task.getNumberOfTasks()).getTaskType();
        String statusIcon = "[" + tasks.getTask(Task.getNumberOfTasks()).getStatusIcon() + "] "
                + deadline[0] + "(by: " + deadline[1] + ")" + Messages.LS;
        String tasksLeft = "    Now you have " + Task.getNumberOfTasks() + " tasks in the list." + Messages.LS;
        return Messages.ADDED + taskType + statusIcon + tasksLeft;
    }

    /**
     * Returns the newly added task in the list and the number of remaining tasks to complete.
     *
     * @param tasks A list used to store the tasks.
     * @param userInput User input.
     * @return Newly added task in the list and the number of remaining tasks to complete.
     * @throws DukeException If no event is given or event is invalid.
     */
    public static String printEvent(TaskList tasks, String userInput) throws DukeException {
        int atIndex = userInput.indexOf("/at");
        if (userInput.substring(5).isBlank()) {
            throw new DukeException("    Why u nvr give any event sia :<" + Messages.LS);
        } else if (!userInput.contains("/at") || userInput.substring(5, atIndex).isBlank()
                || userInput.substring(atIndex + 3).isBlank()) {
            throw new DukeException("    Ur event seems wrong sia" + Messages.LS);
        }
        String[] event = userInput.substring(5).split("/at ");
        String taskType = "    " + tasks.getTask(Task.getNumberOfTasks()).getTaskType();
        String statusIcon = "[" + tasks.getTask(Task.getNumberOfTasks()).getStatusIcon() + "]"
                + event[0] + "(at: " + event[1] + ")" + Messages.LS;
        String tasksLeft = "    Now you have " + Task.getNumberOfTasks()
                + " tasks in the list."+ Messages.LS;
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
        String tasksLeft = "    Now you have " + Task.getNumberOfTasks()
                + " tasks in the list." + Messages.LS;
        return Messages.TASK_DELETED + "    " + taskDescription + tasksLeft;
    }
}
