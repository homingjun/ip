public class PrintLine {
    /**
     * Prints a line wrap around the text.
     *
     * @param text content getting printed
     */
    public static void printLine(String text) {
        String line = "    ―――――――――――――――――――――――――――――――――――――――――――――\n";
        System.out.print(line + text + line);
    }
}

