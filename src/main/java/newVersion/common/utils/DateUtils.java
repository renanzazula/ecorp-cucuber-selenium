package newVersion.common.utils;

import com.crealogix.common.core.Loggable;

import java.math.BigDecimal;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("WeakerAccess") // Methods are public to be used by the project.
public final class DateUtils extends Loggable {

    private static final Map<String, DateTimeFormatter> dateFormats = Collections.unmodifiableMap(
            new HashMap<String, DateTimeFormatter>() {{
                put("yyyy-MM-dd", DateTimeFormatter.ISO_LOCAL_DATE);
                put("yyyy-MM-dd HH:mm:ss.SSS000", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS000"));
                put("yyyy-MM-dd HH:mm:ss.SSS000+HH:mm", DateTimeFormatter.ISO_OFFSET_DATE_TIME);
            }}
    );

    private DateUtils() {
    }

    //For dates that can't be null, but can't be compared because are different every time
    public static boolean isValidMandatoryDate(Object o1) {
        return transformToLocalDateTime(o1) != null;
    }

    //TODO: Improve when the dates definition has been done
    private static LocalDateTime transformToLocalDateTime(Object o) throws DateTimeParseException {
        LocalDateTime ldt = null;
        if (o instanceof Long) {
            //FIXME: This is a workaround to make the test work in Jenkins
            return LocalDateTime.of(
                    Instant.ofEpochMilli((Long) o).atZone(ZoneId.of("Europe/Berlin")).toLocalDate(),
                    LocalTime.MIN);
        } else if (o instanceof BigDecimal) {
            //FIXME: This is a workaround to make the test work in Jenkins
            return LocalDateTime.of(
                    Instant.ofEpochMilli(((BigDecimal) o).longValue()).atZone(ZoneId.of("Europe/Berlin")).toLocalDate(),
                    LocalTime.MIN);
        } else if (o instanceof String) {

            if ("null".equalsIgnoreCase(o.toString()))
                return null;

            for (Map.Entry<String, DateTimeFormatter> entry : dateFormats.entrySet()) {
                log.debug("Try to parse " + o.toString() + " with the format " + entry.getKey());
                ldt = parseDate(o.toString(), entry);
                if (null == ldt)
                    ldt = parseDateTime(o.toString(), entry);

                if (null != ldt)
                    break;
            }

            if (null == ldt) {
                throw new DateTimeParseException("No parser for " + o.toString(), o.toString(), 0);
            }

        }
        return ldt;
    }

    private static LocalDateTime parseDate(String o, Map.Entry<String, DateTimeFormatter> entry) {
        try {
            return LocalDateTime.of(LocalDate.parse(o, entry.getValue()), LocalTime.MIN);
        } catch (DateTimeParseException e) {
            log.debug("Failed to parse as date " + o + " with the format " + entry.getKey());
            return null;
        }
    }

    private static LocalDateTime parseDateTime(String o, Map.Entry<String, DateTimeFormatter> entry) {
        try {
            return LocalDateTime.parse(o, entry.getValue());
        } catch (DateTimeParseException e) {
            log.debug("Failed to parse as dateTime " + o + " with the format " + entry.getKey());
            return null;
        }
    }
}
