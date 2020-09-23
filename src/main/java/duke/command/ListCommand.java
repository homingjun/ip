package duke.command;

import duke.exception.DukeException;
import duke.task.Task;
import duke.task.TaskList;
import duke.ui.Ui;

public class ListCommand extends Command {
    /**
     * Returns the boolean value of the command.
     *
     * @param tasks An arraylist of tasks.
     * @param userInput User input.
     * @return Boolean value
     * @throws DukeException If list command is invalid.
     */
    @Override
    public boolean doCommand(TaskList tasks, String userInput) throws DukeException {
        if (!userInput.substring(4).isBlank()) {
            Ui.printLine(Ui.invalidInput());
            return true;
        }
        Ui.printLine(Ui.printListDescription(Task.getNumberOfTasks(), Task.getCompletedTasks())
                + Ui.printListItems(tasks));
        return true;
    }
}
