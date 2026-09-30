package org.bookingscheduler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class BookingTest {

    @Test
    void shouldHaveUniqueBookingIds() {
        Booking booking1 = new Booking(
                "Niklas Celik",
                "Niklascelik@gmail.com");

        Booking booking2 = new Booking(
                "Kalle Kallesson",
                "Kallekallesson@gmail.com");

        assertNotNull(booking1.getBookingId());
        assertNotNull(booking2.getBookingId());

        assertNotEquals(booking1.getBookingId(), booking2.getBookingId());

    }

}
