package duke.parser;

import duke.exception.DukeException;
import duke.ui.Messages;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateTimeParser {
    private static final String[] DATE_FORMAT = {"d/M/yyyy", "dd/MM/yyyy", "d/M/yy", "dd/MM/yy", "d-M-yyyy", "dd-MM-yyyy", "d-M-yy", "dd-MM-yy"};
    private static final String[] TIME_FORMAT = {"h:m a", "hhmm a", "H:m", "HHmm"};

    /**
     * Returns a LocalDate date.
     *
     * @param date The date input by the user.
     * @return Date.
     * @throws DukeException If the date is invalid.
     */
    public static LocalDate setDate(String date) throws DukeException {
        for (String dateFormat : DATE_FORMAT) {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(dateFormat);
            try {
                return LocalDate.parse(date, dateFormatter);
            } catch (DateTimeException ignored) {
            }
        }
        throw new DukeException(Messages.INVALID_DATE);
    }

    /**
     * Returns a LocalTime time.
     *
     * @param time The time input by the user.
     * @return Time.
     * @throws DukeException If the time is invalid.
     */
    public static LocalTime setTime(String time) throws DukeException {
        for (String timeFormat : TIME_FORMAT) {
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern(timeFormat);
            try {
                return LocalTime.parse(time, timeFormatter);
            } catch (DateTimeException ignored) {
            }
        }
        throw new DukeException(Messages.INVALID_TIME);
    }
}