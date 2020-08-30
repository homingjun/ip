import java.util.ArrayList;

public class Events extends Task {
    public Events(String description) {
        super(description + ")");
        this.taskType = "E";
    }

    public static String printEvent(ArrayList<Task> tasks, String scannedInput, int numberOfTasks) {
        String event = scannedInput.substring(5).replace("/at","(at:");
        //event = event.replace("/","(");
        tasks.add(new Events(event));

        return "    Ok I add this task to ur list liao:\n" + "    "
                + tasks.get(numberOfTasks).getTaskType() + "[" + tasks.get(numberOfTasks).getStatusIcon() + "]"
                + event + ")" + "\n" + "    Now you have " + (numberOfTasks + 1)
                + " more tasks to complete. Good luck!\n";
    }
}
