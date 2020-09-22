package duke.task;

public class Deadline extends Task {
    private String by;

    /**
     * Sets the task description and it's task type to Deadlines.
     *
     * @param description Description of the task.
     */
    public Deadline(String description, String by) {
        super(description);
        this.by = by;
        this.taskType = "D";
    }

    public String getBy() {
        return by;
    }

    @Override
    public String toString() {
        return super.toString().trim() + " (by: " + this.getBy() + ")";
    }
}
