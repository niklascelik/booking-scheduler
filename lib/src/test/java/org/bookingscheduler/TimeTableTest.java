package org.bookingscheduler;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;

class TimeTableTest {

    @Test
    void shouldCreateFlexibleTimeTable() {

        TimeTable timetable = new TimeTable(
                null,
                false,
                LocalTime.of(8, 0),
                LocalTime.of(16, 0)
        );

        assertFalse(timetable.getFixed());
        assertNull(timetable.getSlotDuration());
    }


    @Test
void shouldReturnFalseWhenSlotOverlaps() {

    TimeTable timetable = new TimeTable(
            30,
            true,
            LocalTime.of(8, 0),
            LocalTime.of(16, 0)
    );

    boolean available = timetable.isSlotAvailable(
            LocalTime.of(8, 15),
            LocalTime.of(9, 0)
    );

    assertFalse(available);
}


@Test
void shouldReturnTrueWhenSlotDoesNotOverlap() {

    TimeTable timetable = new TimeTable(
            30,
            true,
            LocalTime.of(8, 0),
            LocalTime.of(16, 0)
    );

    boolean available = timetable.isSlotAvailable(
            LocalTime.of(16, 0),
            LocalTime.of(16, 30)
    );

    assertTrue(available);
}
}