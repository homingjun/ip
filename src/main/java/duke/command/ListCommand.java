package duke.command;

import duke.exception.DukeException;
import duke.task.Task;
import duke.task.TaskList;
import duke.ui.Ui;

public class ListCommand extends Command {
    @Override
    public boolean doCommand(TaskList tasks, String userInput) throws DukeException {
        if (!userInput.substring(4).isBlank()) {
            Ui.printLine(Ui.invalidInput());
            return true;
        }
        Ui.printLine(Ui.printListDescription(Task.getNumberOfTasks(), Task.getCompletedTasks())
                + Ui.printListItems(tasks));
        return true;
    }
}
