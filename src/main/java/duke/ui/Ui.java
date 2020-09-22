package duke.ui;

import duke.exception.DukeException;
import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.messages.Messages;
import duke.task.Todo;

import java.util.ArrayList;

import static duke.task.Task.getNumberOfTasks;

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
    public static String printListItems(ArrayList<Task> tasks) {
        String listItems = "";
        int taskNumber = 1;
        for (Task t : tasks) {
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
    public static String printTodo(ArrayList<Task> tasks, String userInput) throws DukeException {
        if (userInput.substring(4).isBlank()) {
            throw new DukeException("    Pls gimme something to do leh ._." + Messages.LS);
        }
        String todo = userInput.substring(4);
        tasks.add(new Todo(todo));
        String taskType = "    " + tasks.get(getNumberOfTasks() - 1).getTaskType();
        String statusIcon = "[" + tasks.get(getNumberOfTasks() - 1).getStatusIcon() + "]" + todo + Messages.LS;
        String tasksLeft = "    Now you have " + getNumberOfTasks()
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
    public static String printDeadline(ArrayList<Task> tasks, String userInput) throws DukeException {
        int byIndex = userInput.indexOf("/by");
        if (userInput.substring(8).isBlank()) {
            throw new DukeException("    Wah u so free ah no deadlines to meet one :>" + Messages.LS);
        } else if (!userInput.contains("/by") || userInput.substring(8, byIndex).isBlank()
                || userInput.substring(byIndex + 3).isBlank()) {
            throw new DukeException("    Ur deadline looks wrong leh pls check it" + Messages.LS);
        }
        String[] deadline = userInput.substring(9).split("/by ");
        tasks.add(new Deadline(deadline[0], deadline[1]));
        String taskType = "    " + tasks.get(getNumberOfTasks() - 1).getTaskType();
        String statusIcon = "[" + tasks.get(getNumberOfTasks() - 1).getStatusIcon() + "] "
                + deadline[0] + "(by: " + deadline[1] + ")" + Messages.LS;
        String tasksLeft = "    Now you have " + getNumberOfTasks() + " tasks in the list." + Messages.LS;
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
    public static String printEvent(ArrayList<Task> tasks, String userInput) throws DukeException {
        int atIndex = userInput.indexOf("/at");
        if (userInput.substring(5).isBlank()) {
            throw new DukeException("    Why u nvr give any event sia :<" + Messages.LS);
        } else if (!userInput.contains("/at") || userInput.substring(5, atIndex).isBlank()
                || userInput.substring(atIndex + 3).isBlank()) {
            throw new DukeException("    Ur event seems wrong sia" + Messages.LS);
        }
        String[] event = userInput.substring(5).split("/at ");
        tasks.add(new Event(event[0], event[1]));
        String taskType = "    " + tasks.get(getNumberOfTasks() - 1).getTaskType();
        String statusIcon = "[" + tasks.get(getNumberOfTasks() - 1).getStatusIcon() + "]"
                + event[0] + "(at: " + event[1] + ")" + Messages.LS;
        String tasksLeft = "    Now you have " + getNumberOfTasks()
                + " tasks in the list."+ Messages.LS;
        return Messages.ADDED + taskType + statusIcon + tasksLeft;
    }

}
