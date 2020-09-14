package duke;

import duke.command.Commands;

public class Duke {
    public static final String LS = System.lineSeparator();
    private static final String GREETINGS = "          Yahallo! I'm Singlish bot! I'm here to make ur day nicer :)"
            + LS +"                          What u wan me help u do?" + LS;
    private static final String LINE = "    ―――――――――――――――――――――――――――――――――――――――――――"
            + LS;

    /**
     * Returns greetings from the bot.
     *
     * @return Greetings.
     */
    public static String printGreetings() {
        return GREETINGS;
    }

    /**
     * Prints a line wrap around the text.
     *
     * @param text Content getting printed.
     */
    public static void printLine(String text) {
        System.out.print(LINE + text + LINE);
    }

    public static void main(String[] args) {
        //Print greetings
        printLine(printGreetings());
        //Execute a duke.command after receiving user input
        while (Commands.getCommandInput()) ;
    }
}