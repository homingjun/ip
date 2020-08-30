import java.util.Scanner;
import java.util.ArrayList;

public class Commands {
    public static ArrayList<Task> tasks = new ArrayList<>();
    public static int numberOfTasks = 0;
    public static int completedTasks = 0;
    public static final Scanner scan = new Scanner(System.in);
    public static boolean commandInputs() {

        String scannedInput = scan.nextLine();
        String[] commandInput = scannedInput.split(" ");
        switch (commandInput[0]) {
        case "list":
            PrintLine.printLine(PrintList.printListDescription(numberOfTasks, completedTasks)
                    + PrintList.printListItems(tasks, numberOfTasks));
            return true;
        case "todo":
            PrintLine.printLine(Todo.printTodo(tasks, scannedInput, numberOfTasks));
            numberOfTasks++;
            return true;
        case "deadline":
            PrintLine.printLine(Deadlines.printDeadline(tasks, scannedInput, numberOfTasks));
            numberOfTasks++;
            return true;
        case "event":
            PrintLine.printLine(Events.printEvent(tasks, scannedInput, numberOfTasks));
            numberOfTasks++;
            return true;
        case "done":
            PrintLine.printLine(PrintList.completeTask(tasks, scannedInput));
            completedTasks++;
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
