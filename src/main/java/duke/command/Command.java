package duke.command;

import duke.exception.DukeException;
import duke.task.TaskList;

public interface Command {
    boolean doCommand(TaskList tasks, String userInput) throws DukeException;
}