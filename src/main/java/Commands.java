import java.util.ArrayList;
import java.util.Scanner;

public class Commands {
    public static ArrayList<Task> tasks = new ArrayList<>();
    public static int numberOfTasks = 0;
    public static int completedTasks = 0;
    public static int remainingTasks;
    public static final Scanner SCAN = new Scanner(System.in);
    public static final String INVALID_INPUT = "    Invalid input. Please enter again\n";
    public static final String BYE = "    Thank you for using me! See u again soon ya :)\n";

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
            Print.printLine(Print.printListDescription(numberOfTasks, completedTasks)
                    + Print.printListItems(tasks, numberOfTasks));
            break;
        case "todo":
            numberOfTasks++;
            remainingTasks = numberOfTasks - completedTasks;
            Print.printLine(Todo.printTodo(tasks, userInput, numberOfTasks, remainingTasks));
            break;
        case "deadline":
            numberOfTasks++;
            remainingTasks = numberOfTasks - completedTasks;
            Print.printLine(Deadline.printDeadline(tasks, userInput, numberOfTasks, remainingTasks));
            break;
        case "event":
            numberOfTasks++;
            remainingTasks = numberOfTasks - completedTasks;
            Print.printLine(Event.printEvent(tasks, userInput, numberOfTasks, remainingTasks));
            break;
        case "done":
            completedTasks++;
            Print.printLine(Task.completeTask(tasks, userInput));
            break;
        case "bye":
            Print.printLine(sayGoodbye());
            return false;
        default:
            Print.printLine(invalidInput());
            break;
        }
        return true;
    }

    /**
     * returns goodbye greeting from the bot.
     *
     * @return goodbye
     */
    public static String sayGoodbye() {
        return BYE;
    }

    /**
     * returns a prompt to re-enter the input when an invalid input is entered.
     *
     * @return invalid input warning
     */
    public static String invalidInput() {
        return INVALID_INPUT;
    }
}
