package duke.command;

import duke.exception.DukeException;
import duke.ui.Messages;
import duke.storage.Storage;
import duke.task.Deadline;
import duke.task.TaskList;
import duke.ui.Ui;

public class DeadlineCommand extends Command{
    @Override
    public boolean doCommand(TaskList tasks, String userInput) throws DukeException {
        if (!userInput.contains("by")) {
            throw new DukeException(Messages.DEADLINE_NEEDS_BY);
        }
        String[] deadline = userInput.substring(9).split("/by ");
        String[] dateAndTime = deadline[1].split(" ",2);
        tasks.add(new Deadline(deadline[0], dateAndTime[0], dateAndTime[1]));
        Ui.printLine(Ui.printDeadline(tasks, userInput));
        Storage.writeSaveFile(tasks);
        return true;
    }
}
