package duke.command;

import duke.exception.DukeException;
import duke.task.Task;
import duke.ui.Ui;

import java.util.ArrayList;

public class ByeCommand {
    public boolean doCommand() throws DukeException {
        Ui.printLine(Ui.sayGoodbye());
        return false;
    }
}
