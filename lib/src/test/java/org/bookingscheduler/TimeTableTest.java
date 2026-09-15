package org.bookingscheduler;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TimeTableTest {

    @Test
    void fixedScheduleWithNullSlotDuration() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new TimeTable(null, true));
    }

    @Test
    void shouldShowCorrectErrorMessage() {

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new TimeTable(null, true));

        System.out.println(exception.getMessage());
    }

    @Test
    void fixedScheduleWithSlotDuration() {
        TimeTable timeTable = new TimeTable(30, true);

        assertEquals(30, timeTable.getSlotDuration());
        assertTrue(timeTable.getFixed());
        System.out.println(timeTable.getSlotDuration());
        System.out.println(timeTable.getFixed());
    }
}