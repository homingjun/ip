package duke.task;

public abstract class Task {
    private final String DESCRIPTION;
    protected String taskType;
    private boolean isDone;
    protected static int numberOfTasks = 0;
    protected static int completedTasks = 0;

    /**
     * Sets the task description and default it's completion to false.
     *
     * @param description Description of the task.
     */
    public Task(String description) {
        this.DESCRIPTION = description;
        this.isDone = false;

    }

    /**
     * Returns the completion status of the task.
     *
     * @return Completion status of the task.
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
        completedTasks++;
    }

    public void setTaskDeleted() {
        if (isDone) {
            completedTasks--;
        }
        numberOfTasks--;
    }

    /**
     * Returns the description of the task.
     *
     * @return Description of task.
     */
    public String getDescription() {
        return DESCRIPTION;
    }

    /**
     * Returns the type of task.
     *
     * @return Type of task.
     */
    public String getTaskType() {
        return "[" + this.taskType + "]";
    }

    /**
     * Returns the number of tasks in the list.
     *
     * @return Number of tasks in the list.
     */
    public static int getNumberOfTasks() {
        return numberOfTasks;
    }

    /**
     * Returns the number of completed tasks in the list.
     *
     * @return Number of completed tasks in the list.
     */
    public static int getCompletedTasks() {
        return completedTasks;
    }


    public abstract String getDateAndTime();

    @Override
    public String toString() {
        return "[" + this.taskType + "]" + "[" + getStatusIcon() + "] " + this.DESCRIPTION.trim();
    }
}