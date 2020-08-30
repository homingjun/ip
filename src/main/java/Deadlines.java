import java.util.ArrayList;

public class Deadlines extends Task {
    public Deadlines(String description) {
        super(" " + description + ")");
        this.taskType = "D";
    }

    public static String printDeadline(ArrayList<Task> tasks, String scannedInput, int numberOfTasks) {
        String deadline = scannedInput.substring(9).replace("/by","(by:");
        tasks.add(new Deadlines(deadline));

        return "    Ok I add this task to ur list liao:\n" + "    "
                + tasks.get(numberOfTasks).getTaskType() + "[" + tasks.get(numberOfTasks).getStatusIcon() + "] "
                + deadline + ")" + "\n" + "    Now you have " + (numberOfTasks + 1)
                + " more tasks to complete. Good luck!\n";
    }
}
