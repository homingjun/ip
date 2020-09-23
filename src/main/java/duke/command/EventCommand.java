package duke.command;

import duke.exception.DukeException;
import duke.ui.Messages;
import duke.storage.Storage;
import duke.task.Event;
import duke.task.TaskList;
import duke.ui.Ui;

public class EventCommand extends Command {
    @Override
    public boolean doCommand(TaskList tasks, String userInput) throws DukeException {
        if (!userInput.contains("at")) {
            throw new DukeException(Messages.EVENT_NEEDS_AT);
        }
        String[] event = userInput.substring(5).split("/at ");
        String[] dateAndTime = event[1].split(" ", 2);
        tasks.add(new Event(event[0],  dateAndTime[0], dateAndTime[1]));
        Ui.printLine(Ui.printEvent(tasks, userInput));
        Storage.writeSaveFile(tasks);
        return true;
    }
}
