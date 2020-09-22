package duke.parser;

import duke.command.*;
import duke.exception.DukeException;
import duke.messages.Messages;
import duke.storage.Storage;
import duke.task.Task;
import duke.ui.Ui;

import java.util.ArrayList;
import java.util.Scanner;

public class Parser {
    private static ArrayList<Task> tasks;
    private final Storage storage;
    private static final Scanner SCAN = new Scanner(System.in);

    /**
     * Sets the task array and the save file to the current one.
     *
     * @param tasks an array list of tasks
     * @param storage a save file used to store the list
     */
    public Parser(ArrayList<Task> tasks, Storage storage) {
        this.tasks = tasks;
        this.storage = storage;
    }

    /**
     * Prints the respective lines or statements based on the commands input by the user.
     * Returns the boolean value of the command.
     *
     * @return Boolean value
     */
    public static boolean parseCommandInput () {
        String userInput = SCAN.nextLine();
        String[] commandInput = userInput.split(" ");
        try {
            switch (commandInput[0].toLowerCase()) {
            case "list":
                new ListCommand().doCommand(tasks, userInput);
                break;
            case "todo":
                new TodoCommand().doCommand(tasks, userInput);
                break;
            case "deadline":
                new DeadlineCommand().doCommand(tasks, userInput);
                break;
            case "event":
                new EventCommand().doCommand(tasks, userInput);
                break;
            case "done":
                new DoneCommand().doCommand(tasks, userInput);
                break;
            case "delete":
                new DeleteCommand().doCommand(tasks, userInput);
                break;
            case "bye":
                new ByeCommand().doCommand();
                return false;
            default:
                Ui.printLine(Ui.invalidInput());
            }
        } catch (DukeException e) {
            e.printExceptionMessage();
        } catch (IndexOutOfBoundsException e) {
            Ui.printLine(Messages.INVALID_NUMBER);
        } catch (NumberFormatException e) {
            Ui.printLine(Messages.NO_STRING);
        }
        return true;
    }
}
