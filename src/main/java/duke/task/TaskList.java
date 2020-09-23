package duke.task;

import java.util.ArrayList;

public class TaskList {
    private final ArrayList<Task> TASKS;

    public TaskList() {
        this.TASKS = new ArrayList<>();
    }

    public TaskList(ArrayList<Task> tasks) {
        this.TASKS = tasks;
    }

    public void add(Task task) {
        TASKS.add(task);
    }

    public void delete(int taskNumber) {
        TASKS.remove(taskNumber - 1);
    }

    public Task getTask(int taskNumber) {
        return TASKS.get(taskNumber - 1);
    }

    public int getSize() {
        return TASKS.size();
    }

    public void addAll(ArrayList<Task> tasks) {
        this.TASKS.addAll(tasks);
    }

    public ArrayList<Task> getTaskList() {
        return TASKS;
    }
}
