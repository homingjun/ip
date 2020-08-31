public class Task {
    protected String description;
    protected String taskType;
    protected boolean isDone;

    /**
     * Sets the task description and default it's completion to false.
     *
     * @param description description of the task
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Returns the completion status of the task
     *
     * @return completion status of the task
     */
    public String getStatusIcon() {
        //return ✓ or ✘ symbols
        return (isDone ? "✓" : "✘");
    }

    /**
     * Sets the completion status of the task as completed.
     */
    public void markAsDone() {
        isDone = true;
    }

    /**
     * Returns the type of task.
     *
     * @return type of task
     */
    public String getTaskType() {
        return "[" + this.taskType + "]";
    }
}