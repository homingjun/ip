package duke;

import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.Todo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class SaveFile {
    private final String FOLDER_PATH;
    private final String FILE_PATH;
    private static File dukeSaveFile;

    /**
     * Sets the folder path and file path to the new specified path.
     *
     * @param folderpath save folder path
     * @param filepath save file path
     */
    public SaveFile(String folderpath, String filepath) {
        this.FOLDER_PATH = folderpath;
        this.FILE_PATH = filepath;
    }

    /**
     * Creates a save file as a .txt file to store the tasks.
     */
    public void createSaveFile() {
        File saveFolder = new File(FOLDER_PATH);
        if (!saveFolder.exists() && !saveFolder.isDirectory()) {
            Duke.printLine("    It looks like u dun have a save folder yet, lemme make one now" + Duke.LS);
            saveFolder.mkdir();
            Duke.printLine("    I made a folder for u here: " + saveFolder.getAbsolutePath() + Duke.LS);
        }
        dukeSaveFile = new File(FILE_PATH);
        try {
            if (!dukeSaveFile.exists()) {
                Duke.printLine("    I can't find any save file here, lemme make one now" + Duke.LS);
                dukeSaveFile.createNewFile();
            } else {
                Duke.printLine("    I found ur file le! :D" + Duke.LS);
            }
        } catch (IOException e) {
            Duke.printLine("    I think got problem sia I can't save ur file" + Duke.LS);
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
                    tasks.add(new Deadline(taskInfo[2], taskInfo[3]));
                    break;
                case "[E]":
                    tasks.add(new Event(taskInfo[2], taskInfo[3]));
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
            Duke.printLine("    I can't find ur file sia" + Duke.LS);
            return null;
        }
    }

    /**
     * Writes the contents of the task list to the save file's .txt file
     *
     * @param tasks an array list of tasks
     */
    public static void writeSaveFile(ArrayList<Task> tasks) {
        try {
            FileWriter saveWriter = new FileWriter(dukeSaveFile);
            for (Task t : tasks) {
                saveWriter.append(t.getTaskType() + "|" + t.getStatusIcon() + "|" + t.getDescription().trim());
                switch (t.getTaskType()) {
                case "[D]":
                    saveWriter.append("|" + ((Deadline) t).getBy());
                    break;
                case "[E]":
                    saveWriter.append("|" + ((Event) t).getAt());
                    break;
                }
                saveWriter.append(Duke.LS);
            }
            saveWriter.close();
        } catch (IOException e) {
            Duke.printLine("    I cant write to ur save file :/" + Duke.LS);
        }
    }
}
