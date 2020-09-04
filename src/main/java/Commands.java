import java.util.ArrayList;
import java.util.Scanner;

public class Commands {
    public static ArrayList<Task> tasks = new ArrayList<>();
    public static int numberOfTasks = 0;
    public static int completedTasks = 0;
    public static int remainingTasks;
    public static final Scanner SCAN = new Scanner(System.in);

    /**
     * Prints the respective lines or statements based on the commands input by the user.
     * Returns the boolean value of the command.
     *
     * @return boolean value
     */
    public static boolean getCommandInput() {
        String userInput = SCAN.nextLine();
        String[] commandInput = userInput.split(" ");
        switch (commandInput[0]) {
        case "list":
            PrintLine.printLine(PrintList.printListDescription(numberOfTasks, completedTasks)
                    + PrintList.printListItems(tasks, numberOfTasks));
            break;
        case "todo":
            numberOfTasks++;
            remainingTasks = numberOfTasks - completedTasks;
            PrintLine.printLine(Todo.printTodo(tasks, userInput, numberOfTasks, remainingTasks));
            break;
        case "deadline":
            numberOfTasks++;
            remainingTasks = numberOfTasks - completedTasks;
            PrintLine.printLine(Deadline.printDeadline(tasks, userInput, numberOfTasks, remainingTasks));
            break;
        case "event":
            numberOfTasks++;
            remainingTasks = numberOfTasks - completedTasks;
            PrintLine.printLine(Event.printEvent(tasks, userInput, numberOfTasks, remainingTasks));
            break;
        case "done":
            completedTasks++;
            PrintLine.printLine(Task.completeTask(tasks, userInput));
            break;
        case "bye":
            PrintLine.printLine(Bye.sayGoodbye());
            return false;
        default:
            PrintLine.printLine(InvalidInput.printInvalidInput());
            break;
        }
        return true;
    }
}
