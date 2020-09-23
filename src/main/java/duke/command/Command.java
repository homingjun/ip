package duke.command;

import duke.exception.DukeException;
import duke.task.TaskList;

public abstract class Command {
    public abstract boolean doCommand(TaskList tasks, String userInput) throws DukeException;
}
