package duke.command;

import duke.exception.DukeException;
import duke.storage.Storage;
import duke.task.Task;
import duke.ui.Ui;

import java.util.ArrayList;

public class DoneCommand extends Command{
    @Override
    public boolean doCommand(ArrayList<Task> tasks, String userInput) throws DukeException {
        Ui.printLine(Task.completeTask(tasks, userInput));
        Storage.writeSaveFile(tasks);
        return true;
    }
}
