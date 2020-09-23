package duke.command;

import duke.exception.DukeException;
import duke.storage.Storage;
import duke.task.TaskList;
import duke.task.Todo;
import duke.ui.Ui;


public class TodoCommand  extends Command {
    /**
     * Returns the boolean value of the command.
     *
     * @param tasks An arraylist of tasks.
     * @param userInput User input.
     * @return Boolean value.
     * @throws DukeException If todo command is invalid.
     */
    @Override
    public boolean doCommand(TaskList tasks, String userInput) throws DukeException {
        String todo = userInput.substring(4);
        tasks.add(new Todo(todo));
        Ui.printLine(Ui.printTodo(tasks, userInput));
        Storage.writeSaveFile(tasks);
        return true;
    }
}
