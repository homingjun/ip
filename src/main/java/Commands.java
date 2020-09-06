import java.util.ArrayList;
import java.util.Scanner;

public class Commands {
    private static final ArrayList<Task> tasks = new ArrayList<>();
    private static final Scanner SCAN = new Scanner(System.in);
    private static final String BYE = "    Thank you for using me! See u again soon ya :)" + Print.LS;
    private static final String INVALID_INPUT = "    Invalid input. Please enter again" + Print.LS;

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
            Print.printLine(Print.printListDescription(Task.getNumberOfTasks(), Task.getCompletedTasks())
                    + Print.printListItems(tasks, Task.getNumberOfTasks()));
            break;
        case "todo":
            Print.printLine(Todo.printTodo(tasks, userInput));
            break;
        case "deadline":
            Print.printLine(Deadline.printDeadline(tasks, userInput));
            break;
        case "event":
            Print.printLine(Event.printEvent(tasks, userInput));
            break;
        case "done":
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
