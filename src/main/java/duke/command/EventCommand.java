package duke.command;

import duke.exception.DukeException;
import duke.storage.Storage;
import duke.task.Event;
import duke.task.TaskList;
import duke.ui.Ui;

public class EventCommand extends Command {
    @Override
    public boolean doCommand(TaskList tasks, String userInput) throws DukeException {
        String[] event = userInput.substring(5).split("/at ");
        tasks.add(new Event(event[0], event[1]));
        Ui.printLine(Ui.printEvent(tasks, userInput));
        Storage.writeSaveFile(tasks);
        return true;
    }
}
