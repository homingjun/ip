package duke;

import duke.command.Commands;
import duke.task.Task;

import java.util.ArrayList;

public class Duke {
    public static final String LS = System.lineSeparator();
    private static final String GREETINGS = "          Yahallo! I'm Singlish bot! I'm here to make ur day nicer :)"
            + LS +"                          What u wan me help u do?" + LS;
    private static final String LINE = "    ―――――――――――――――――――――――――――――――――――――――――――"
            + LS;
    private static final ArrayList<Task> tasks = new ArrayList<>();
    private static final String FOLDER_PATH = "data";
    private static final String FILE_PATH = "data/savedtasks.txt";
    private static final SaveFile save = new SaveFile(FOLDER_PATH, FILE_PATH);
    private static final Commands command = new Commands(tasks, save);

    /**
     * Returns greetings from the bot.
     *
     * @return greetings
     */
    public static String printGreetings() {
        return GREETINGS;
    }

    /**
     * Prints a line wrap around the text.
     *
     * @param text content getting printed
     */
    public static void printLine(String text) {
        System.out.print(LINE + text + LINE);
    }

    public static void main(String[] args) {
        //Print greetings
        printLine(printGreetings());
        //Create a save file (if one doesn't exist) to store the list of tasks
        save.createSaveFile();
        //Loads the list of tasks from the save file
        tasks.addAll(save.loadSaveFile());
        //Execute a command after receiving user input
        while (command.getCommandInput())  ;
    }
}