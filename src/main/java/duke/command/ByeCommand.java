package duke.command;

import duke.exception.DukeException;
import duke.task.TaskList;
import duke.ui.Ui;

public class ByeCommand extends Command {
    public boolean byeCommand() throws DukeException {
        Ui.printLine(Ui.sayGoodbye());
        return false;
    }

    @Override
    public boolean doCommand(TaskList tasks, String userInput) throws DukeException {
        return false;
    }
}
