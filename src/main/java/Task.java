import java.util.ArrayList;

public class Task {
    protected String description;
    protected String taskType;
    protected boolean isDone;
    public static final String CONGRATS = "    Congrats on completing this task! U damn ups :D\n";

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

    /**
     * Returns the confirmation of completing a task.
     *
     * @param tasks a list used to store the tasks
     * @param scannedInput user input
     * @return completion of task
     */
    public static String completeTask(ArrayList<Task> tasks, String scannedInput) {
        String[] split = scannedInput.split(" ");
        tasks.get(Integer.parseInt(split[1]) - 1).markAsDone();
        String statusIcon = "    [" + tasks.get(Integer.parseInt(split[1]) - 1).getStatusIcon() + "] ";
        String taskDescription = tasks.get(Integer.parseInt(split[1]) - 1).description;
        return CONGRATS + statusIcon + taskDescription + "\n";
    }
}