package duke.command;

import java.util.ArrayList;
import java.util.Scanner;

import duke.Duke;
import duke.SaveFile;
import duke.exception.DukeException;
import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.Todo;

public class Commands {
    private static ArrayList<Task> tasks;
    private final SaveFile save;

    private static final Scanner SCAN = new Scanner(System.in);
    private static final String BYE = "    Thank you for using me! See u again soon ya :)" + Duke.LS;
    private static final String INVALID_INPUT = "    I can't understand what u saying eh, can say properly?"
            + Duke.LS;
    private static final String INVALID_NUMBER = "    Err I think u enter wrong task number sia, it's not in the list"
            + Duke.LS;
    private static final String NO_STRING = "    After ur \"done\" or \"delete\" pls use numbers only tolong" + Duke.LS;

    /**
     * Sets the task array and the save file to the current one.
     *
     * @param tasks an array list of tasks
     * @param save a save file used to store the list
     */
    public Commands(ArrayList<Task> tasks, SaveFile save) {
        this.tasks = tasks;
        this.save = save;
    }

    /**
     * Prints the respective lines or statements based on the commands input by the user.
     * Returns the boolean value of the command.
     *
     * @return Boolean value
     */
    public static boolean getCommandInput() {
        String userInput = SCAN.nextLine();
        String[] commandInput = userInput.split(" ");
        try {
            switch (commandInput[0].toLowerCase()) {
            case "list":
                if (!userInput.substring(4).isBlank()) {
                    Duke.printLine(invalidInput());
                    break;
                }
                Duke.printLine(Task.printListDescription(Task.getNumberOfTasks(), Task.getCompletedTasks())
                        + Task.printListItems(tasks, Task.getNumberOfTasks()));
                break;
            case "todo":
                Duke.printLine(Todo.printTodo(tasks, userInput));
                SaveFile.writeSaveFile(tasks);
                break;
            case "deadline":
                Duke.printLine(Deadline.printDeadline(tasks, userInput));
                SaveFile.writeSaveFile(tasks);
                break;
            case "event":
                Duke.printLine(Event.printEvent(tasks, userInput));
                SaveFile.writeSaveFile(tasks);
                break;
            case "done":
                Duke.printLine(Task.completeTask(tasks, userInput));
                SaveFile.writeSaveFile(tasks);
                break;
            case "delete":
                Duke.printLine(Task.deleteTask(tasks, userInput));
                SaveFile.writeSaveFile(tasks);
                break;
            case "bye":
                Duke.printLine(sayGoodbye());
                return false;
            default:
                Duke.printLine(invalidInput());
            }
        } catch (DukeException e) {
            e.printExceptionMessage();
        } catch (IndexOutOfBoundsException e) {
            Duke.printLine(INVALID_NUMBER);
        } catch (NumberFormatException e) {
            Duke.printLine(NO_STRING);
        }
        return true;
    }

    /**
     * Returns goodbye greeting from the bot.
     *
     * @return Goodbye.
     */
    public static String sayGoodbye() {
        return BYE;
    }

    /**
     * Returns a prompt to re-enter the input when an invalid input is entered.
     *
     * @return Invalid input warning.
     */
    public static String invalidInput() {
        return INVALID_INPUT;
    }
}
