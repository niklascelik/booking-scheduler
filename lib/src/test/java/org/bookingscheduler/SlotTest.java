package org.bookingscheduler;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalTime;

import org.junit.jupiter.api.Test;

public class  SlotTest {

    @Test
    void shouldCreateSlotWithCorrectValues() {
        LocalTime startTime = LocalTime.of(10, 0);
        LocalTime endTime = LocalTime.of(10, 30);

        Slot slot = new Slot(startTime, endTime, "slot-123");

        assertEquals(startTime, slot.getStartTime());
        assertEquals(endTime, slot.getEndTime());
        assertEquals("slot-123", slot.getSlotId());
    }

    @Test
    void shouldChangeStartTime() {
        Slot slot = new Slot(
                LocalTime.of(10, 0),
                LocalTime.of(10, 30),
                "slot-123");

        LocalTime newStartTime = LocalTime.of(11, 0);

        slot.setStartTime(newStartTime);

        assertEquals(newStartTime, slot.getStartTime());
    }

    @Test
    void shouldChangeEndTime() {
        Slot slot = new Slot(
                LocalTime.of(10, 0),
                LocalTime.of(10, 30),
                "slot-123");

        LocalTime newEndTime = LocalTime.of(11, 30);

        slot.setEndTime(newEndTime);

        assertEquals(newEndTime, slot.getEndTime());
    }
}