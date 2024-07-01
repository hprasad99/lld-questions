package FlipKar.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public  class DateTimeUtil {
    public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy hh:mm a");
    public static boolean overlaps(LocalDateTime start1, LocalDateTime end1, LocalDateTime start2, LocalDateTime end2) {
        return start1.isBefore(end2) && end1.isAfter(start2);
    }
}
