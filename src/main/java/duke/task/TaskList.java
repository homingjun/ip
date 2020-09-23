package duke.task;

import java.util.ArrayList;

public class TaskList {
    private final ArrayList<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public void add(Task task) {
        tasks.add(task);
    }

    public void delete(int taskNumber) {
        tasks.remove(taskNumber - 1);
    }

    public Task getTask(int taskNumber) {
        return tasks.get(taskNumber - 1);
    }

    public int getSize() {
        return tasks.size();
    }

    public void addAll(ArrayList<Task> tasks) {
        this.tasks.addAll(tasks);
    }

    public ArrayList<Task> getTaskList() {
        return tasks;
    }
}
