package duke;

import duke.parser.Parser;
import duke.storage.Storage;
import duke.task.Task;
import duke.ui.Ui;

import java.util.ArrayList;

public class Duke {
    private static final ArrayList<Task> tasks = new ArrayList<>();
    private static Parser parser;
    private static Storage storage;
    private final Ui ui;

    public Duke(String folderpath, String filepath) {
        ui = new Ui();
        storage = new Storage(folderpath, filepath);
        parser = new Parser(tasks, storage);
    }

    public void run()  {
        ui.printLine(Ui.printGreetings()); //Print greetings
        storage.createSaveFile(); //Create a save file (if one doesn't exist) to store the list of tasks
        tasks.addAll(storage.loadSaveFile()); //Loads the list of tasks from the save file
        while (parser.parseCommandInput()) ; //Execute a command after receiving user input
    }
    public static void main(String[] args) {
        new Duke("data", "data/tasks.txt").run();
    }
}