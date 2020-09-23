package duke.task;

import duke.exception.DukeException;
import duke.parser.DateTimeParser;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Event extends Task {
    private final LocalDate DATE;
    private final LocalTime TIME;
    private final String DATE_STRING;
    private final String TIME_STRING;
    /**
     * Sets the task description and it's task type to Events.
     *
     * @param description Description of the task.
     */
    public Event(String description, String date, String time) throws DukeException {
        super(description);
        this.DATE = DateTimeParser.setDate(date);
        this.TIME = DateTimeParser.setTime(time);
        this.DATE_STRING = date;
        this.TIME_STRING = time;
        this.taskType = "E";
        numberOfTasks++;
    }

    public String getDate() {
        return DATE_STRING;
    }

    public String getTime() {
        return TIME_STRING;
    }

    @Override
    public String getDateAndTime() {
        return DATE.format(DateTimeFormatter.ofPattern("d MMM yyyy")) + " "
                + TIME.format(DateTimeFormatter.ofPattern("hh:mm a"));
    }

    @Override
    public String toString() {
        return super.toString().trim() + " (at: " + this.getDateAndTime() + ")";
    }
}
