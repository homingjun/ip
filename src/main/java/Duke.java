import java.util.*;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        String line = "―――――――――――――――――――――――――――――――――";
        System.out.println(line);
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
        System.out.println(line);
        System.out.println();
        Scanner sc = new Scanner(System.in);
        String ls = sc.nextLine();
        //System.out.println(ls.equals("list"));
        String[] list = new String[100];
        for (int i = 0; i < 100; i++) {
            if (ls.equals("list") == false) {
                list[i] = ls;
                System.out.println(line);
                System.out.println("added: " + list[i]);
                System.out.println(line);
                System.out.println();
            } else {
                break;
            }
            ls = sc.nextLine();
        }
        System.out.println(line);
        for (int i = 0; i < 100; i++) {
            if (list[i] != null) {
                System.out.println((i + 1) + "." + list[i]);
            }
        }
        System.out.println(line);
        System.out.println();
        String bye = sc.nextLine();
        System.out.println(line);
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println(line);
    }
}
