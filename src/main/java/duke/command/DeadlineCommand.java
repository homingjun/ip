package duke.command;

import duke.exception.DukeException;
import duke.storage.Storage;
import duke.task.Deadline;
import duke.task.TaskList;
import duke.ui.Ui;

public class DeadlineCommand extends Command{
    @Override
    public boolean doCommand(TaskList tasks, String userInput) throws DukeException {
        String[] deadline = userInput.substring(9).split("/by ");
        tasks.add(new Deadline(deadline[0], deadline[1]));
        Ui.printLine(Ui.printDeadline(tasks, userInput));
        Storage.writeSaveFile(tasks);
        return true;
    }
}
