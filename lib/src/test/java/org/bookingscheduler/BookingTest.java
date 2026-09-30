package org.bookingscheduler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;


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

    @Test
    void shouldReturnCustomerNameAndEmail() {
        Booking booking = new Booking(
                "Niklas Celik",
                "Niklascelik@gmail.com");

        assertEquals("Niklas Celik", booking.getCustomerName());
        assertEquals("Niklascelik@gmail.com", booking.getCustomerEmail());

    }

    @Test
    void shouldChangeCustomerNameAndEmail() {
        Booking booking = new Booking(
                "Niklas Celik",
                "Niklascelik@gmail.com");

        booking.setCustomerName("Pelle Celik");
        booking.setCustomerEmail("Pelle@gmail.com");

        assertEquals("Pelle Celik", booking.getCustomerName());
        assertEquals("Pelle@gmail.com", booking.getCustomerEmail());
    }

    @Test
    void shouldRejectEmptyName() {
        assertThrows(IllegalArgumentException.class,
                () -> new Booking(
                        "",
                        "Niklascelik@gmail.com"));
    }

    @Test
    void shouldRejectEmptyEmail() {
        assertThrows(IllegalArgumentException.class,
                () -> new Booking(
                        "Niklas",
                        ""));
    }

    @Test
    void shouldRejectEmailWithoutAtSymbol() {
        assertThrows(IllegalArgumentException.class,
                () -> new Booking(
                        "Niklas",
                        "NiklascelikGmail.com"));
    }

    @Test
    void shouldRejectEmailWithoutPeriod() {
        assertThrows(IllegalArgumentException.class,
                () -> new Booking(
                        "Niklas",
                        "Niklascelik@gmailcom"));
    }

    @Test
    void shouldRejectNameMadeoutofSpaces() {
        assertThrows(IllegalArgumentException.class,
                () -> new Booking(
                        "          ",
                        "Niklascelik@gmail.com"));
    }

    @Test
    void shouldRejectInvalidCustomerNameWhenChanging() {
        Booking booking = new Booking(
                "Niklas Celik",
                "Niklascelik@gmail.com");

        assertThrows(
                IllegalArgumentException.class,
                () -> booking.setCustomerName("           "));
    }

    @Test
    void shouldRejectInvalidEmailWhenChanging() {
        Booking booking = new Booking(
                "Niklas Celik",
                "Niklascelik@gmail.com");

        assertThrows(
                IllegalArgumentException.class,
                () -> booking.setCustomerEmail("NiklascelikGmail.com"));
    }
}
