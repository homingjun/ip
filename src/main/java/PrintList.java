import java.util.ArrayList;

public class PrintList {
    public static String printListDescription(int numberOfTasks, int completedTasks) {
        if (numberOfTasks == 0) {
            return "    Your list still empty eh please add sth leh\n";
        } else if (completedTasks == numberOfTasks) {
            return "    Wah u finished all ur tasks! Nice la! \n";
        } else if (completedTasks == 0) {
            return "    U haven't done any tasks yet... U shud start soon!\n";
        } else {
            return "    U still got some tasks left to do. Jia you!\n";
            }
    }

    public static String printListItems(ArrayList<Task> tasks, int numberOfTasks) {
        String listItems = "";
        for (int i = 0; i < numberOfTasks; i++) {
            listItems += "    " + (i + 1) + "." + tasks.get(i).getTaskType() + "["
                    + tasks.get(i).getStatusIcon() + "]" + tasks.get(i).description + "\n";
        }
        return listItems;
    }
    public static String completeTask(ArrayList<Task> tasks, String scannedInput) {
        String[] split = scannedInput.split(" ");
        tasks.get(Integer.parseInt(split[1]) - 1).markAsDone();
        return "    Congrats on completing this task! U damn ups :D\n"
                + "    [" + tasks.get(Integer.parseInt(split[1]) - 1).getStatusIcon() + "] "
                + tasks.get(Integer.parseInt(split[1]) - 1).description + "\n";
    }
}
