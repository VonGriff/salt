package se.salt.precourse.firstjavaapp;

import org.apache.commons.lang3.StringUtils;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class StartDateHandler {

    public long daysToCourseStart(String startDateInput) {
        LocalDate startDate = LocalDate.parse(startDateInput);
        LocalDate today = LocalDate.now();
        return ChronoUnit.DAYS.between(today, startDate);
    }

    public boolean dateHasOnlyNumbers(String startDateInput) {
        String[] dateParts = startDateInput.split("-");
        for (String datePart : dateParts) {
            if (!StringUtils.isNumeric((datePart))) {
                return false;
            }
        }
        return true;
    }
}
