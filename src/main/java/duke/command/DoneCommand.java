package duke.command;

import duke.exception.DukeException;
import duke.storage.Storage;
import duke.task.TaskList;
import duke.ui.Ui;

public class DoneCommand extends Command{
    /**
     * Returns the boolean value of the command.
     *
     * @param tasks An arraylist of tasks.
     * @param userInput User input.
     * @return Boolean value.
     * @throws DukeException If done command is invalid.
     */
    @Override
    public boolean doCommand(TaskList tasks, String userInput) throws DukeException {
        Ui.printLine(Ui.printTaskCompletion(tasks, userInput));
        Storage.writeSaveFile(tasks);
        return true;
    }
}
