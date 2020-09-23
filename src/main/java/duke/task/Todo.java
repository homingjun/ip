package duke.task;

public class Todo extends Task {
    /**
     * Sets the task description and it's task type to Todo.
     *
     * @param description Description of the task.
     */
    public Todo(String description) {
        super(description);
        this.taskType = "T";
        numberOfTasks++;
    }

    @Override
    public String getDateAndTime() {
        return null;
    }
}
