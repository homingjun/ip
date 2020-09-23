package duke.task;

import java.util.ArrayList;

public class TaskList {
    private final ArrayList<Task> TASKS;

    /**
     * Create new arraylist to store the tasks.
     */
    public TaskList() {
        this.TASKS = new ArrayList<>();
    }

    /**
     * Copies the arraylist given to the current one.
     *
     * @param tasks An arraylist of tasks.
     */
    public TaskList(ArrayList<Task> tasks) {
        this.TASKS = tasks;
    }

    /**
     * Adds the task to the list.
     *
     * @param task An arraylist of tasks.
     */
    public void add(Task task) {
        TASKS.add(task);
    }

    /**
     * Deletes the task from the list.
     *
     * @param taskNumber The task number in the list.
     */
    public void delete(int taskNumber) {
        TASKS.remove(taskNumber - 1);
    }

    /**
     * Returns the task item requested from the list.
     *
     * @param taskNumber The task number in the list.
     * @return Task item.
     */
    public Task getTask(int taskNumber) {
        return TASKS.get(taskNumber - 1);
    }

    /**
     * Returns the size of the task list.
     *
     * @return Size of task list.
     */
    public int getSize() {
        return TASKS.size();
    }

    /**
     * Add all the task items from the given arraylist to the current one.
     *
     * @param tasks An arraylist of tasks.
     */
    public void addAll(ArrayList<Task> tasks) {
        this.TASKS.addAll(tasks);
    }

    /**
     * Returns the task list.
     *
     * @return Task list.
     */
    public ArrayList<Task> getTaskList() {
        return TASKS;
    }
}
