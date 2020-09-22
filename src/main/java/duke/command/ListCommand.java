package duke.command;

import duke.exception.DukeException;
import duke.task.Task;
import duke.ui.Ui;

import java.util.ArrayList;

public class ListCommand extends Command {

    @Override
    public boolean doCommand(ArrayList<Task> tasks, String userInput) throws DukeException {
        if (!userInput.substring(4).isBlank()) {
            Ui.printLine(Ui.invalidInput());
            return true;
        }
        Ui.printLine(Ui.printListDescription(Task.getNumberOfTasks(), Task.getCompletedTasks())
                + Ui.printListItems(tasks));
        return true;
    }
}
