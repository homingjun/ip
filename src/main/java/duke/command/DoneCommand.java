package duke.command;

import duke.exception.DukeException;
import duke.storage.Storage;
import duke.task.TaskList;
import duke.ui.Ui;

public class DoneCommand extends Command{
    @Override
    public boolean doCommand(TaskList tasks, String userInput) throws DukeException {
        Ui.printLine(Ui.printTaskCompletion(tasks, userInput));
        Storage.writeSaveFile(tasks);
        return true;
    }
}
