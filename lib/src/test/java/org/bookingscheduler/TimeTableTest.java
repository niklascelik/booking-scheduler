package org.bookingscheduler;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalTime;

class TimeTableTest {


 @Test
void shouldGenerateSlots() {
    TimeTable timetable = new TimeTable(
            30,
            true,
            LocalTime.of(8, 0),
            LocalTime.of(16, 0)
    );
}


}