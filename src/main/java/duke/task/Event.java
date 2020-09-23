package duke.task;

import duke.exception.DukeException;
import duke.parser.DateTimeParser;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Event extends Task {
    private final LocalDate date;
    private final LocalTime time;
    private final String dateString;
    private final String timeString;
    /**
     * Sets the task description and it's task type to Events.
     *
     * @param description Description of the task.
     */
    public Event(String description, String date, String time) throws DukeException {
        super(description);
        this.date = DateTimeParser.setDate(date);
        this.time = DateTimeParser.setTime(time);
        this.dateString = date;
        this.timeString = time;
        this.taskType = "E";
        numberOfTasks++;
    }

    public String getDate() {
        return dateString;
    }

    public String getTime() {
        return timeString;
    }

    @Override
    public String getDateAndTime() {
        return date.format(DateTimeFormatter.ofPattern("d MMM yyyy")) + " "
                + time.format(DateTimeFormatter.ofPattern("hh:mm a"));
    }

    @Override
    public String toString() {
        return super.toString().trim() + " (at: " + this.getDateAndTime() + ")";
    }
}
