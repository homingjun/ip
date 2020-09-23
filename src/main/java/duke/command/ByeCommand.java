package duke.command;

import duke.exception.DukeException;
import duke.task.TaskList;
import duke.ui.Ui;

public class ByeCommand extends Command {
    /**
     * Returns the boolean value of the command.
     *
     * @return Boolean value.
     */
    public boolean byeCommand() {
        Ui.printLine(Ui.sayGoodbye());
        return false;
    }

    @Override
    public boolean doCommand(TaskList tasks, String userInput) throws DukeException {
        return false;
    }
}
