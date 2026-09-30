package org.bookingscheduler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;

public class TimeTableTest {

@Test
void shouldCreateFixedTimetable() {
    TimeTable timeTable = new TimeTable(
            30,
            true,
            LocalTime.of(8, 0),
            LocalTime.of(10, 0)
    );

    assertEquals(30, timeTable.getSlotDuration());
    assertTrue(timeTable.getFixed());
    assertEquals(4, timeTable.getSlots().size());
}
}