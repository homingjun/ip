import java.util.Scanner;

public class Duke {
    public static void printLine(String text) {
        String line = "―――――――――――――――――――――――――――――――――\n";
        System.out.println(line + text + line);
    }

    public static String greetings() {
        return " Hi I'm Savage bot! I'm here to make ur day worse :)\n"
                + "             What u wan me do for u sia?\n";
    }

    public static String printListDescription(Task[] tasks, int numberOfTasks, int completedTasks) {
        if (numberOfTasks == 0) {
            return "Eh your list still empty la can wake up and use ur brains abit anot?\n";
        } else {
            for (int taskNumber = 0; taskNumber < numberOfTasks; taskNumber++) {
                if (tasks[taskNumber].isDone && completedTasks == numberOfTasks) {
                    return "Wow, u actually finished ur tasks! I guess miracles do happen after all.\n";
                } else if (completedTasks == 0) {
                    return "Although I dun think u can finish any of them, here is ur dumb list:\n";
                } else {
                    return "As expected, here is ur incomplete task list :>\n";
                }
            }
        }
        return "";
    }

    public static String printListItems(Task[] tasks, int numberOfTasks) {
        String listItems = "";
        for (int i = 0; i < numberOfTasks; i++) {
            listItems += (i + 1) + ".[" + tasks[i].getStatusIcon() + "] " + tasks[i].description + "\n";
        }
        return listItems;
    }

    public static String printTasks(Task[] tasks, String scannedInput, int numberOfTasks) {
        tasks[numberOfTasks] = new Task(scannedInput);
        return "added:" + scannedInput + "\n";
    }

    public static String completeTask(Task[] tasks, String scannedInput) {
        String[] split = scannedInput.split(" ");
        tasks[Integer.parseInt(split[1]) - 1].markAsDone();
        return "Wow... I guess u're not retarded after all! Congrats on completing this task :>\n"
                + "[" + tasks[Integer.parseInt(split[1]) - 1].getStatusIcon() + "] "
                + tasks[Integer.parseInt(split[1]) - 1].description + "\n";
    }

    public static void main(String[] args) {
        Task[] tasks = new Task[100];
        Scanner scan = new Scanner(System.in);
        String scannedInput;
        int numberOfTasks = 0;
        int completedTasks = 0;

        printLine(greetings());
        while (!(scannedInput = scan.nextLine()).contains("bye")) {
            if (scannedInput.equals("list")) {
                printLine(printListDescription(tasks, numberOfTasks, completedTasks) + printListItems(tasks, numberOfTasks));
            } else if (!scannedInput.contains("done")) {
                printLine(printTasks(tasks, scannedInput, numberOfTasks));
                numberOfTasks++;
            }
            if (scannedInput.contains("done")) {
                printLine(completeTask(tasks, scannedInput));
                completedTasks++;
            }
        }
        printLine("Until next time, dun die pls. Ciao.\n");
    }
}