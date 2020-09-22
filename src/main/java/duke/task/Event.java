package duke.task;

public class Event extends Task {
    private String at;

    /**
     * Sets the task description and it's task type to Events.
     *
     * @param description Description of the task.
     */
    public Event(String description, String at) {
        super(description);
        this.at = at;
        this.taskType = "E";
    }

    public String getAt() {
        return at;
    }

    @Override
    public String toString() {
        return super.toString().trim() + " (at: " + this.getAt() + ")";
    }
}
