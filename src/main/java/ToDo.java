import java.util.ArrayList;

public class Todo extends Task {
    public Todo(String description) {
        super(description);
        this.taskType = "T";
    }

    public static String printTodo(ArrayList<Task> tasks, String scannedInput, int numberOfTasks) {
        String split = scannedInput.substring(4);
        tasks.add(new Todo(split));
        return "    Ok I add this task to ur list liao:\n" + "    "
                + tasks.get(numberOfTasks).getTaskType() + "[" + tasks.get(numberOfTasks).getStatusIcon() + "]"
                + split + "\n" + "    Now you have " + (numberOfTasks + 1) + " more tasks to complete. Good luck!\n";
    }
}
