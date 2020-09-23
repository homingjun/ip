package duke.storage;

import duke.exception.DukeException;
import duke.ui.Messages;
import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.TaskList;
import duke.task.Todo;
import duke.ui.Ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    private final String FOLDER_PATH;
    private final String FILE_PATH;
    private static File dukeSaveFile;

    /**
     * Sets the folder path and file path to the new specified path.
     *
     * @param folderpath save folder path
     * @param filepath save file path
     */
    public Storage(String folderpath, String filepath) {
        this.FOLDER_PATH = folderpath;
        this.FILE_PATH = filepath;
    }

    /**
     * Creates a save file as a .txt file to store the tasks.
     */
    public void createSaveFile() {
        File saveFolder = new File(FOLDER_PATH);
        if (!saveFolder.exists() && !saveFolder.isDirectory()) {
            Ui.printLine(Messages.CREATE_SAVE_FOLDER);
            saveFolder.mkdir();
            Ui.printLine( Messages.SAVE_FOLDER_LOCATION + saveFolder.getAbsolutePath() + Messages.LS);
        }
        dukeSaveFile = new File(FILE_PATH);
        try {
            if (!dukeSaveFile.exists()) {
                Ui.printLine(Messages.CREATE_SAVE_FILE);
                dukeSaveFile.createNewFile();
            } else {
                Ui.printLine(Messages.SAVE_FILE_FOUND);
            }
        } catch (IOException e) {
            Ui.printLine(Messages.CANNOT_CREATE_SAVE_FILE);
        }
    }

    /**
     * Returns an array list of the tasks loaded from the save file.
     *
     * @return array list of tasks
     */
    public ArrayList<Task> loadSaveFile() {
        try {
            ArrayList<Task> tasks = new ArrayList<>();
            Scanner read = new Scanner(dukeSaveFile);
            while (read.hasNext()) {
                String[] taskInfo = read.nextLine().split("\\|");
                switch (taskInfo[0]) {
                case "[T]":
                    tasks.add(new Todo(taskInfo[2]));
                    break;
                case "[D]":
                    tasks.add(new Deadline(taskInfo[2], taskInfo[3], taskInfo[4]));
                    break;
                case "[E]":
                    tasks.add(new Event(taskInfo[2], taskInfo[3],  taskInfo[4]));
                    break;
                default:
                    break;
                    //fallthrough
                }
                if (taskInfo[1].equals("✓")) {
                    tasks.get(tasks.size() - 1).markAsDone();
                }
            }
            return tasks;
        } catch (FileNotFoundException e) {
            Ui.printLine(Messages.CANNOT_FIND_SAVE_FILE);
            return null;
        } catch (DukeException e) {
            e.printExceptionMessage();
            return null;
        }
    }

    /**
     * Writes the contents of the task list to the save file's .txt file
     *
     * @param tasks an array list of tasks
     */
    public static void writeSaveFile(TaskList tasks) {
        ArrayList<Task> taskList = tasks.getTaskList();
        try {
            FileWriter saveWriter = new FileWriter(dukeSaveFile);
            for (Task t : taskList) {
                saveWriter.append(t.getTaskType() + "|" + t.getStatusIcon() + "|" + t.getDescription().trim());
                switch (t.getTaskType()) {
                case "[D]":
                    saveWriter.append("|" + ((Deadline) t).getDate() + "|" + ((Deadline) t).getTime());
                    break;
                case "[E]":
                    saveWriter.append("|" + ((Event) t).getDate() + "|" + ((Event) t).getTime());
                    break;
                }
                saveWriter.append(Messages.LS);
            }
            saveWriter.close();
        } catch (IOException e) {
            Ui.printLine(Messages.CANNOT_WRITE_TO_SAVE_FILE);
        }
    }
}
