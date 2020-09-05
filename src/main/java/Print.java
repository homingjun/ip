import java.util.ArrayList;

public class Print {
    public static final String EMPTY_LIST = "    Your list still empty eh please add sth leh\n";
    public static final String ALL_TASKS_COMPLETED = "    Wah u finished all ur tasks! Nice la!\n";
    public static final String NO_TASKS_COMPLETED = "    U haven't done any tasks yet... U shud start soon!\n";
    public static final String SOME_TASKS_COMPLETED = "    U still got some tasks left to do. Jia you!\n";
    public static final String line = "    ―――――――――――――――――――――――――――――――――――――――――――――\n";

    /**
     * Prints a line wrap around the text.
     *
     * @param text content getting printed
     */
    public static void printLine(String text) {
        System.out.print(line + text + line);
    }

    /**
     * Returns the respective list description based on the number of tasks and completed tasks
     *
     * @param numberOfTasks number of tasks in the list
     * @param completedTasks number of completed tasks in the list
     * @return list description
     */
    public static String printListDescription(int numberOfTasks, int completedTasks) {
        if (numberOfTasks == 0) {
            return EMPTY_LIST;
        } else if (completedTasks == numberOfTasks) {
            return ALL_TASKS_COMPLETED;
        } else if (completedTasks == 0) {
            return NO_TASKS_COMPLETED;
        } else {
            return SOME_TASKS_COMPLETED;
        }
    }

    /**
     * Returns the tasks in the list along with the status of the .
     *
     * @param tasks a list used to store the tasks
     * @param numberOfTasks number of tasks in the list
     * @return list of tasks
     */
    public static String printListItems(ArrayList<Task> tasks, int numberOfTasks) {
        String listItems = "";
        for (int i = 0; i < numberOfTasks; i++) {
            listItems += "    " + (i + 1) + "." + tasks.get(i).getTaskType() + "["
                    + tasks.get(i).getStatusIcon() + "]" + tasks.get(i).description + "\n";
        }
        return listItems;
    }
}
