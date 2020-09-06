import java.util.ArrayList;
import java.util.EnumMap;

public class Task {
    protected String description;
    protected String taskType;
    protected boolean isDone;
    private static int numberOfTasks = 0;
    private static int completedTasks = 0;
    private static int remainingTasks;
    protected static final String ADDED = "    Ok I add this task to ur list liao:" + Print.LS;
    private static final String CONGRATS = "    Congrats on completing this task! U damn ups :D" + Print.LS;


    /**
     * Sets the task description and default it's completion to false.
     *
     * @param description description of the task
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
        numberOfTasks++;
        remainingTasks = numberOfTasks - completedTasks;
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
        completedTasks++;
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
     * Returns the number of tasks in the list
     *
     * @return number of tasks in the list
     */
    public static int getNumberOfTasks() {
        return numberOfTasks;
    }

    /**
     * Returns the number of completed tasks in the list
     *
     * @return number of completed tasks in the list
     */
    public static int getCompletedTasks() {
        return completedTasks;
    }

    /**
     * Returns the remaining tasks in the list
     *
     * @return remaining tasks in the list
     */
    public static int getRemainingTasks() {
        return remainingTasks;
    }

    /**
     * Returns the confirmation of completing a task.
     *
     * @param tasks a list used to store the tasks
     * @param scannedInput user input
     * @return completion of task
     */
    public static String completeTask(ArrayList<Task> tasks, String scannedInput) {
        String[] words = scannedInput.split(" ");
        tasks.get(Integer.parseInt(words[1]) - 1).markAsDone();
        String statusIcon = "    [" + tasks.get(Integer.parseInt(words[1]) - 1).getStatusIcon() + "] ";
        String taskDescription = tasks.get(Integer.parseInt(words[1]) - 1).description;
        return CONGRATS + statusIcon + taskDescription + Print.LS;
    }
}