public class Duke {
    public static void main(String[] args) {
        //Print greetings
        Print.printLine(Print.printGreetings());
        //Execute a command after receiving user input
        while (Commands.getCommandInput()) ;
    }
}