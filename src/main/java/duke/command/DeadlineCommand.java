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
        int byIndex = userInput.indexOf("/by");
        if (userInput.substring(8).isBlank()) {
            throw new DukeException(Messages.NO_DEADLINE);
        } else if (!userInput.contains("by")) {
            throw new DukeException(Messages.DEADLINE_NEEDS_BY);
        } else if (userInput.substring(8, byIndex).isBlank() || userInput.substring(byIndex + 3).isBlank()) {
            throw new DukeException(Messages.INVALID_DEADLINE);
        }
        String[] deadline = userInput.substring(9).split("/by ");
        String[] dateAndTime = deadline[1].split(" ",2);
        tasks.add(new Deadline(deadline[0], dateAndTime[0], dateAndTime[1]));
        Ui.printLine(Ui.printDeadline(tasks, userInput));
        Storage.writeSaveFile(tasks);
        return true;
    }
}
