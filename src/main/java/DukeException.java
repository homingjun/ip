public class DukeException extends Exception {
    private static final String EMPTY_TODO = "    Pls gimme something to do leh ._." + Print.LS;
    private static final String EMPTY_EVENT = "    Why u nvr give any event sia :<" + Print.LS;
    private static final String INVALID_EVENT = "    Ur event seems wrong sia" + Print.LS;
    private static final String EMPTY_DEADLINE = "    Wah u so free ah no deadlines to meet one :>" + Print.LS;
    private static final String INVALID_DEADLINE = "    Ur deadline looks wrong leh pls check it" + Print.LS;
    private static final String NO_TASKS = "    Ps u need to add tasks first before u can set them as complete leh"
            + Print.LS;

    /**
     * Constructs a {@code DukeException} with the specified detail
     * message.
     *
     * @param userInput the detail message
     */
    public DukeException (String userInput) {
        switch (userInput) {
        case "no todo":
            Print.printLine(EMPTY_TODO);
            break;
        case "no event":
            Print.printLine(EMPTY_EVENT);
            break;
        case "invalid event":
            Print.printLine(INVALID_EVENT);
            break;
        case "no deadline":
            Print.printLine(EMPTY_DEADLINE);
            break;
        case "invalid deadline":
            Print.printLine(INVALID_DEADLINE);
            break;
        case "no tasks in list":
            Print.printLine(NO_TASKS);
        }
    }
}
