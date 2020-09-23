package duke.command;

import duke.exception.DukeException;
import duke.storage.Storage;
import duke.task.TaskList;
import duke.ui.Ui;

public class DeleteCommand extends Command {
    @Override
    public boolean doCommand(TaskList tasks, String userInput) throws DukeException {
        Ui.printLine(Ui.printTaskDeletion(tasks, userInput));
        String[] words = userInput.split(" ");
        tasks.delete(Integer.parseInt(words[1]));
        Storage.writeSaveFile(tasks);
        return true;
    }
}
