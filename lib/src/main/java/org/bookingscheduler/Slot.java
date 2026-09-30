package org.bookingscheduler;

import java.time.LocalTime;

/**
 * Represents a time slot with a start time, end time, and slot id.
 * 
 */
public class Slot {
    private LocalTime startTime;
    private LocalTime endTime;
    private final String slotId;
    private Booking booking;

    /**
     * Creates a slot with a start time, end time, and slot ID.
     *
     * @param startTime the start time of the slot
     * @param endTime   the end time of the slot
     * @param slotId    the ID of the slot
     */
    public Slot(LocalTime startTime, LocalTime endTime, String slotId) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.slotId = slotId;

    }


    public LocalTime getStartTime() {
        return startTime;
    }


    public LocalTime getEndTime() {
        return endTime;
    }

    public String getSlotId() {
        return slotId;

    }

    public Booking getBooking() {
        return booking;
    }

    /**
     * Adds a booking to the slot if it is not already booked.
     *
     * @param booking the booking to add to the slot.
     * @throws IllegalStateException if the slot is already booked.
     */
    public void book(Booking booking) {
        if (this.booking == null) {
            this.booking = booking;
        } else {
            throw new IllegalStateException("Slot is already booked.");
        }
    }

}
