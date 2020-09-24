package duke.parser;

import duke.command.ByeCommand;
import duke.command.DeadlineCommand;
import duke.command.DeleteCommand;
import duke.command.DoneCommand;
import duke.command.EventCommand;
import duke.command.FindCommand;
import duke.command.ListCommand;
import duke.command.TodoCommand;
import duke.exception.DukeException;
import duke.task.TaskList;
import duke.ui.Messages;
import duke.ui.Ui;

import java.util.Scanner;

public class Parser {
    private static TaskList tasks;
    private static final Scanner SCAN = new Scanner(System.in);

    /**
     * Sets the task list to the current one.
     *
     * @param tasks An arraylist of tasks
     */
    public Parser(TaskList tasks) {
        this.tasks = tasks;
    }

    /**
     * Prints the respective lines or statements based on the commands input by the user.
     * Returns the boolean value of the command.
     *
     * @return Boolean value.
     */
    public static boolean parseCommandInput () {
        String userInput = SCAN.nextLine();
        String[] commandInput = userInput.split(" ");
        try {
            switch (commandInput[0].toLowerCase()) {
            case "list":
                return new ListCommand().doCommand(tasks, userInput);
            case "todo":
                return new TodoCommand().doCommand(tasks, userInput);
            case "deadline":
                return new DeadlineCommand().doCommand(tasks, userInput);
            case "event":
                return new EventCommand().doCommand(tasks, userInput);
            case "done":
                return new DoneCommand().doCommand(tasks, userInput);
            case "delete":
                return new DeleteCommand().doCommand(tasks, userInput);
            case "find":
                return new FindCommand().doCommand(tasks, userInput);
            case "bye":
                return new ByeCommand().byeCommand();
            default:
                Ui.printLine(Ui.invalidInput());
            }
        } catch (DukeException e) {
            e.printExceptionMessage();
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
            Ui.printLine(Messages.INVALID_NUMBER);
        } catch (NumberFormatException e) {
            Ui.printLine(Messages.NO_STRING);
        }
        return true;
    }
}
