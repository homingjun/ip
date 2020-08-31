import java.util.ArrayList;
import java.util.Scanner;

public class Commands {
    public static ArrayList<Task> tasks = new ArrayList<>();
    public static int numberOfTasks = 0;
    public static int completedTasks = 0;
    public static int remainingTasks;
    public static final Scanner scan = new Scanner(System.in);

    /**
     * Prints the respective lines or statements based on the commands input by the user.
     * Returns the boolean value of the command.
     *
     * @return boolean value
     */
    public static boolean commandInputs() {
        String userInput = scan.nextLine();
        String[] commandInput = userInput.split(" ");
        switch (commandInput[0]) {
        case "list":
            PrintLine.printLine(PrintList.printListDescription(numberOfTasks, completedTasks)
                    + PrintList.printListItems(tasks, numberOfTasks));
            return true;
        case "todo":
            numberOfTasks++;
            remainingTasks = numberOfTasks - completedTasks;
            PrintLine.printLine(ToDo.printToDo(tasks, userInput, numberOfTasks, remainingTasks));
            return true;
        case "deadline":
            numberOfTasks++;
            remainingTasks = numberOfTasks - completedTasks;
            PrintLine.printLine(Deadlines.printDeadline(tasks, userInput, numberOfTasks, remainingTasks));
            return true;
        case "event":
            numberOfTasks++;
            remainingTasks = numberOfTasks - completedTasks;
            PrintLine.printLine(Events.printEvent(tasks, userInput, numberOfTasks, remainingTasks));
            return true;
        case "done":
            completedTasks++;
            PrintLine.printLine(PrintList.completeTask(tasks, userInput));
            return true;
        case "bye":
            PrintLine.printLine("    Thank you for using me! See u again soon ya :)\n");
            break;
        default:
            PrintLine.printLine("    Invalid input. Please enter again\n");
            return true;
        }
        return false;
    }
}
