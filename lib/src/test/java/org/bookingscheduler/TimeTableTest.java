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
                LocalTime.of(10, 0));

        assertEquals(30, timeTable.getSlotDuration());
        assertTrue(timeTable.isFixed());
        assertEquals(4, timeTable.getSlots().size());
    }

    @Test
    void shouldCreateFlexibleTimetable() {
        TimeTable timeTable = new TimeTable(
                null,
                false,
                LocalTime.of(8, 0),
                LocalTime.of(16, 0));
        assertFalse(timeTable.isFixed());
        assertNull(timeTable.getSlotDuration());
        assertEquals(0, timeTable.getSlots().size());

    }

    @Test
    void shouldCreateCorrectSlotTimes() {
        TimeTable timeTable = new TimeTable(
                30,
                true,
                LocalTime.of(8, 0),
                LocalTime.of(16, 0));

        Slot firstSlot = timeTable.getSlotById("1");
        Slot secondSlot = timeTable.getSlotById("2");

        assertEquals(LocalTime.of(8, 0), firstSlot.getStartTime());
        assertEquals(LocalTime.of(8, 30), firstSlot.getEndTime());

        assertEquals(LocalTime.of(8, 30), secondSlot.getStartTime());
        assertEquals(LocalTime.of(9, 0), secondSlot.getEndTime());

    }

    @Test
    void shouldCreateCorrectAmountOfSlots() {
        TimeTable timeTable = new TimeTable(
                30,
                true,
                LocalTime.of(8, 0),
                LocalTime.of(16, 0));

        assertEquals(16, timeTable.getSlots().size());

    }

    @Test
    void shouldFindSlotById() {
        TimeTable timeTable = new TimeTable(
                30,
                true,
                LocalTime.of(8, 0),
                LocalTime.of(10, 0));

        Slot slot = timeTable.getSlotById("2");

        assertNotNull(slot);
        assertEquals("2", slot.getSlotId());
    }

    @Test
    void shouldReturnNullWhenSlotIdDoesntExist() {
        TimeTable timeTable = new TimeTable(
                30,
                true,
                LocalTime.of(8, 0),
                LocalTime.of(10, 0));

        Slot slot = timeTable.getSlotById("150");

        assertNull(slot);
    }

    @Test
    void shouldAddSlotToFlexibleTimetable() {
        TimeTable timeTable = new TimeTable(
                null,
                false,
                LocalTime.of(8, 0),
                LocalTime.of(16, 0));

        timeTable.addSlot(
                LocalTime.of(9, 0),
                LocalTime.of(10, 33));

        assertEquals(1, timeTable.getSlots().size());
    }

    @Test
    void shouldRejectSlotDurationForFlexibleTimeTable() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new TimeTable(
                        30,
                        false,
                        LocalTime.of(8, 0),
                        LocalTime.of(16, 0)));

    }

    @Test
    void shouldRejectSlotOutsideSchedule() {
        TimeTable timeTable = new TimeTable(
                null,
                false,
                LocalTime.of(8, 0),
                LocalTime.of(16, 0));

        assertThrows(
                IllegalArgumentException.class,
                () -> timeTable.addSlot(
                        LocalTime.of(7, 0),
                        LocalTime.of(13, 0)));
    }

    @Test
    void shouldRejectOverlappingSlot() {
        TimeTable timeTable = new TimeTable(
                null,
                false,
                LocalTime.of(8, 0),
                LocalTime.of(16, 0));

        timeTable.addSlot(
                LocalTime.of(8, 0),
                LocalTime.of(13, 0));

        assertThrows(
                IllegalArgumentException.class,
                () -> timeTable.addSlot(
                        LocalTime.of(9, 0),
                        LocalTime.of(14, 0)));
    }

    @Test
    void shouldRejectSlotWhenStartTimeisAfterEndTime() {
        TimeTable timeTable = new TimeTable(
                null,
                false,
                LocalTime.of(8, 0),
                LocalTime.of(16, 0));

        assertThrows(
                IllegalArgumentException.class,
                () -> timeTable.addSlot(
                        LocalTime.of(12, 0),
                        LocalTime.of(10, 0)));
    }

    @Test
    void shouldRejectFixedTimetableWithoutSlotDuration() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new TimeTable(
                        null,
                        true,
                        LocalTime.of(8, 0),
                        LocalTime.of(16, 0)));
    }

    @Test
    void shouldRejectInvalidSlotDuration() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new TimeTable(
                        0,
                        true,
                        LocalTime.of(8, 0),
                        LocalTime.of(16, 0)));
    }

    @Test
    void shouldGiveAddedSlotAnId() {
        TimeTable timeTable = new TimeTable(
                null,
                false,
                LocalTime.of(8, 0),
                LocalTime.of(16, 0));

        timeTable.addSlot(
                LocalTime.of(9, 0),
                LocalTime.of(10, 0));

        Slot slot = timeTable.getSlotById("1");

        assertEquals("1", slot.getSlotId());
    }

}
