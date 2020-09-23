package duke.parser;

import duke.exception.DukeException;
import duke.ui.Messages;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateTimeParser {
    private static final String[] dateFormat = {"d/M/yyyy", "dd/MM/yyyy", "d/M/yy", "dd/MM/yy", "d-M-yyyy", "dd-MM-yyyy", "d-M-yy", "dd-MM-yy"};
    private static final String[] timeFormat = {"h:m a", "hhmm a", "H:m", "HHmm"};

    public static LocalDate setDate(String date) throws DukeException {
        for (String dateFormat : dateFormat) {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(dateFormat);
            try {
                return LocalDate.parse(date, dateFormatter);
            } catch (DateTimeException ignored) {
            }
        }
        throw new DukeException(Messages.INVALID_DATE);
    }

    public static LocalTime setTime(String time) throws DukeException {
        for (String timeFormat : timeFormat) {
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern(timeFormat);
            try {
                return LocalTime.parse(time, timeFormatter);
            } catch (DateTimeException ignored) {
            }
        }
        throw new DukeException(Messages.INVALID_TIME);
    }
}