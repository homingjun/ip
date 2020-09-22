package duke.command;

import duke.exception.DukeException;
import duke.task.Task;

import java.util.ArrayList;

public abstract class Command {
    public abstract boolean doCommand(ArrayList<Task> tasks, String userInput) throws DukeException;
}
