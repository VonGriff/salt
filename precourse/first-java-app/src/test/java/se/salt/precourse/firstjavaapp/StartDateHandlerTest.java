package se.salt.precourse.firstjavaapp;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class StartDateHandlerTest {
    @Test
    void returns2ForDateTwoDaysInTheFuture() {
        LocalDate twoDaysInFuture = LocalDate.now().plusDays(2);
        long two = new StartDateHandler().daysToCourseStart(twoDaysInFuture.toString());

        assertEquals(2, two);
    }

    @Test
    void returnsTrueForDateWithNumbers() {
        String date = "2023-12-19";
        assertTrue(new StartDateHandler().dateHasOnlyNumbers(date));
    }

    @Test
    void returnsFalseForDateWithLetters() {
        String date = "2023-twelve-1nine";
        assertFalse(new StartDateHandler().dateHasOnlyNumbers(date));
    }
}