package duke.command;

import duke.exception.DukeException;
import duke.ui.Messages;
import duke.storage.Storage;
import duke.task.Event;
import duke.task.TaskList;
import duke.ui.Ui;

public class EventCommand implements Command {
    /**
     * Returns the boolean value of the command.
     *
     * @param tasks An arraylist of tasks.
     * @param userInput User input.
     * @return Boolean value.
     * @throws DukeException If event command is invalid.
     */
    public boolean doCommand(TaskList tasks, String userInput) throws DukeException {
        int atIndex = userInput.indexOf("/at");
        if (userInput.substring(5).isBlank()) {
            throw new DukeException(Messages.NO_EVENT);
        } else if (!userInput.contains("at")) {
            throw new DukeException(Messages.EVENT_NEEDS_AT);
        } else if (userInput.substring(5, atIndex).isBlank() || userInput.substring(atIndex + 3).isBlank()) {
            throw new DukeException(Messages.INVALID_EVENT);
        }
        String[] event = userInput.substring(5).split("/at ");
        String[] dateAndTime = event[1].split(" ", 2);
        tasks.add(new Event(event[0],  dateAndTime[0], dateAndTime[1]));
        Ui.printLine(Ui.printEvent(tasks, userInput));
        Storage.writeSaveFile(tasks);
        return true;
    }
}
