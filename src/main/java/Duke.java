public class Duke {
    public static void main(String[] args) {
        //Print greetings
        PrintLine.printLine(Greetings.greetings());
        //Execute a command after user input
        while (Commands.commandInputs());
    }
}