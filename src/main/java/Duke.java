import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String line = "―――――――――――――――――――――――――――――――――";
        Task[] tasks = new Task[100];
        Scanner scan = new Scanner(System.in);
        String scannedInput;
        int numberOfTasks = 0;

        System.out.println(line);
        System.out.println(" Hi I'm Savage bot! I'm here to make ur day worse :)");
        System.out.println("             What u wan me do for u sia?");
        System.out.println(line);
        System.out.println();

        while (!(scannedInput = scan.nextLine()).contains("bye")) {
            System.out.println(line);
            if (scannedInput.equals("list")) {
                if (numberOfTasks == 0) {
                    System.out.println("Eh your list still empty la can wake up and use ur brains abit anot?");
                    System.out.println(line);
                } else {
                    System.out.println("Although I dun think u can finish any of them, here is ur dumb list:");
                }
                for (int i = 0; i < numberOfTasks; i++) {
                    System.out.println((i + 1) + ".[" + tasks[i].getStatusIcon() + "] " + tasks[i].description);
                }
            } else if (!scannedInput.contains("done")) {
                tasks[numberOfTasks] = new Task(scannedInput);
                numberOfTasks++;
                System.out.println("added:" + scannedInput);
                }
            if (scannedInput.contains("done")) {
                String[] split = scannedInput.split(" ");
                tasks[Integer.parseInt(split[1]) - 1].markAsDone();
                System.out.println("Wow u actually managed to complete " + tasks[Integer.parseInt(split[1]) - 1].description + ". I'm surprised u can even complete a task, I guess I'll give props to u.");
                System.out.println("[" + tasks[Integer.parseInt(split[1]) - 1].getStatusIcon() + "] " + tasks[Integer.parseInt(split[1]) - 1].description);
            }
            System.out.println();
            }
        System.out.println(line);
        System.out.println("Until next time, dun die pls. Ciao.");
    }
}

