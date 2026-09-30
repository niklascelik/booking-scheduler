package org.bookingscheduler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

public class SlotTest {

    @Test
    void shouldReturnOpeningTimeAndClosingTime() {
        Slot slot = new Slot(
                LocalTime.of(8, 0),
                LocalTime.of(8, 30),
                "1");

        assertEquals(LocalTime.of(8, 0), slot.getStartTime());
        assertEquals(LocalTime.of(8, 30), slot.getEndTime());

    }

    @Test
    void shouldReturnId() {
        Slot slot = new Slot(
                LocalTime.of(8, 0),
                LocalTime.of(8, 30),
                "1");

        assertEquals("1", slot.getSlotId());
    }

    @Test
    void shouldReturnBooking() {
        Slot slot = new Slot(
                LocalTime.of(8, 0),
                LocalTime.of(8, 30),
                "1");
        Booking booking = new Booking(
                "Niklas Celik",
                "Niklascelik@gmail.com");

        slot.book(booking);
        assertEquals(booking, slot.getBooking());

    }

    @Test
    void shouldNotHaveBookingWhenCreated() {
        Slot slot = new Slot(
                LocalTime.of(8, 0),
                LocalTime.of(8, 30),
                "1");

        assertNull(slot.getBooking());
    }

    @Test
    void shouldRejectDoubleBooking() {
        Slot slot = new Slot(
                LocalTime.of(8, 0),
                LocalTime.of(8, 30),
                "1");

        Booking booking1 = new Booking(
                "Niklas Celik",
                "niklas@gmail.com");

        Booking booking2 = new Booking(
                "Chefen Löfven",
                "ChefenLöfven@gmail.com");

        slot.book(booking1);

        assertThrows(
                IllegalStateException.class,
                () -> slot.book(booking2));
    }

}