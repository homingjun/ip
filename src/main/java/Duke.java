public class Duke {
    public static void main(String[] args) {
        //Print greetings
        PrintLine.printLine(Greetings.printGreetings());
        //Execute a command after receiving user input
        while (Commands.getCommandInput());
    }
}