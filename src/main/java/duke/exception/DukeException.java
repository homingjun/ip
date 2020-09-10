package duke.exception;

import duke.Duke;

public class DukeException extends Exception {
    private static final String EMPTY_TODO = "    Pls gimme something to do leh ._." + Duke.LS;
    private static final String EMPTY_EVENT = "    Why u nvr give any event sia :<" + Duke.LS;
    private static final String INVALID_EVENT = "    Ur event seems wrong sia" + Duke.LS;
    private static final String EMPTY_DEADLINE = "    Wah u so free ah no deadlines to meet one :>" + Duke.LS;
    private static final String INVALID_DEADLINE = "    Ur deadline looks wrong leh pls check it" + Duke.LS;
    private static final String NO_TASKS = "    Ps u need to add tasks first before u can set them as complete leh"
            + Duke.LS;

    /**
     * Constructs a {@code duke.exception.DukeException} with the specified detail
     * message.
     *
     * @param errorMessage the detail message
     */
    public DukeException (String errorMessage) {
        switch (errorMessage) {
        case "no todo":
            Duke.printLine(EMPTY_TODO);
            break;
        case "no event":
            Duke.printLine(EMPTY_EVENT);
            break;
        case "invalid event":
            Duke.printLine(INVALID_EVENT);
            break;
        case "no deadline":
            Duke.printLine(EMPTY_DEADLINE);
            break;
        case "invalid deadline":
            Duke.printLine(INVALID_DEADLINE);
            break;
        case "no tasks in list":
            Duke.printLine(NO_TASKS);
        }
    }
}
