package duke;

import duke.parser.Parser;
import duke.storage.Storage;
import duke.task.TaskList;
import duke.ui.Ui;

public class Duke {
    private static TaskList tasks;
    private static Parser parser;
    private static Storage storage;
    private final Ui UI;

    /**
     * Creates a new storage file and sets the folder path and file path to the new specified path.
     * Create a tasklist and parse the tasks.
     *
     * @param folderpath Save folder path.
     * @param filepath Save file path.
     */
    public Duke(String folderpath, String filepath) {
        UI = new Ui();
        storage = new Storage(folderpath, filepath);
        tasks = new TaskList();
        parser = new Parser(tasks);
    }

    /**
     * Runs the duke bot
     */
    public void run()  {
        UI.printLine(Ui.printGreetings()); //Print greetings
        storage.createSaveFile(); //Create a save file (if one doesn't exist) to store the list of tasks
        tasks.addAll(storage.loadSaveFile()); //Loads the list of tasks from the save file
        while (parser.parseCommandInput()) ; //Execute a command after receiving user input
    }

    public static void main(String[] args) {
        new Duke("data", "data/tasks.txt").run();
    }
}