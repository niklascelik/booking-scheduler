package org.bookingscheduler;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.time.Duration;

/**
 * Represents a timetable with either a fixed or flexible schedule.
 * 
 * A fixed schedule reuires a slot duration while a flexible must not have a
 * slot duration.
 */
public class TimeTable {

    // Timetable options.
    private Integer slotDuration;
    private boolean fixed;

    // Opening Hours.
    private LocalTime openingTime;
    private LocalTime closingTime;

    // Timetable includes slots.
    private List<Slot> slots = new ArrayList<>();

    public TimeTable(Integer slotDuration, boolean fixed, LocalTime openingTime, LocalTime closingTime) {
        validateSlotDuration(slotDuration, fixed);
        this.slotDuration = slotDuration;
        this.fixed = fixed;
        this.openingTime = openingTime;
        this.closingTime = closingTime;

        if (fixed) {
            generateSlots();
        }

    }

    public void setOpeningTime(LocalTime openingTime) {
        this.openingTime = openingTime;
    }

    public void setClosingTime(LocalTime closingTime) {
        this.closingTime = closingTime;
    }

    public LocalTime getOpeningTime() {
        return openingTime;
    }

    public LocalTime getClosingTime() {
        return closingTime;
    }

    public void setSlotDuration(Integer slotDuration) {
        validateSlotDuration(slotDuration, fixed);
        this.slotDuration = slotDuration;
    }

    public void setFixed(boolean fixed) {
        validateSlotDuration(slotDuration, fixed);
        this.fixed = fixed;
    }

    public Integer getSlotDuration() {
        return slotDuration;
    }

    public boolean getFixed() {
        return fixed;
    }

    /**
     * Validates the slot duration according to the timetable type.
     *
     * @param slotDuration the duration of each slot.
     * @param fixed whether the timetable uses a fixed schedule.
     * @throws IllegalArgumentException if the slot duration is invalid for the sleceted schedule type.
     */
    private void validateSlotDuration(Integer slotDuration, boolean fixed) {
        if (slotDuration == null && fixed) {
            throw new IllegalArgumentException(
                    "You have to decalare a valid slotDuration if you want to use a fixed schedule.");

        }
        if (slotDuration != null && !fixed) {
            throw new IllegalArgumentException(
                    "You have chosen a flexible schedule dont enter a slotDuration");
        }
        if (slotDuration != null && slotDuration <= 0 && fixed) {
            throw new IllegalArgumentException(
                    "Please enter a valid slot duration.");
        }

    }

    /**
     * Generates time slots for the timetable.
     * Calculates the total time between opening and closing time
     * and determines how many slots fits within that duration.
     */
    private void generateSlots() {
        LocalTime currentTime = openingTime;

        Duration duration = Duration.between(openingTime, closingTime);
        long totalMinutes = duration.toMinutes();
        long slotsPerDay = totalMinutes / slotDuration;

        int i = 0;

        while (i < slotsPerDay) {
            LocalTime endTime = currentTime.plusMinutes(slotDuration);

            Slot slot = new Slot(currentTime, endTime, String.valueOf(i + 1));
            slots.add(slot);

            currentTime = currentTime.plusMinutes(slotDuration);
            i++;

        }
    }

    /**
     * Checks if slot time is available.
     * 
     * @param startTime start time of the slot.
     * @param endTime   end time of the slot.
     * @return true if the time interval does not overlap with an existing slot,
     *         otherwise false.
     */
    private boolean isSlotAvailable(LocalTime startTime, LocalTime endTime) {

        for (Slot existingSlot : slots) {
            LocalTime existingStartTime = existingSlot.getStartTime();
            LocalTime existingEndTime = existingSlot.getEndTime();

            if (startTime.isBefore(existingEndTime) &&
                    endTime.isAfter(existingStartTime)) {
                return false;
            }
        }
        return true;

    }

    /**
     * Finds a slot by its ID.
     *
     * @param slotId the ID of the slot
     * @return the matching slot or null if no slot is found
     */
    public Slot getSlotById(String slotId) {
        for (Slot slot : slots) {
            if (slot.getSlotId().equals(slotId)) {
                return slot;
            }
        }
        return null;
    }

    private void validateSlotTime(LocalTime startTime, LocalTime endTime) {
        if (!startTime.isBefore(endTime)) {
            throw new IllegalArgumentException("start time must be before end time.");
        }
    }

    private void validateSlotWithinSchedule(LocalTime startTime, LocalTime endTime) {
        if (startTime.isBefore(openingTime) ||
                endTime.isAfter(closingTime)) {
            throw new IllegalArgumentException("slot time must be within the schedules opening and closing hours.");
        }
    }

    /**
     * Adds a manually defined slot to a flexible timetable.
     *
     * @param startTime the start time of the slot.
     * @param endTime   the end time of the slot.
     * @throws IllegalStateException    if the timetable is fixed.
     * @throws IllegalArgumentException if the time is invalid or overlaps.
     */
    public void addSlot(LocalTime startTime, LocalTime endTime) {
        if (fixed) {
            throw new IllegalStateException("You cant manually add slots to a fixed schedule.");
        }

        validateSlotTime(startTime, endTime);
        validateSlotWithinSchedule(startTime, endTime);

        if (!isSlotAvailable(startTime, endTime)) {
            throw new IllegalArgumentException("Slot is not available.");
        }
        String slotId = String.valueOf(slots.size() + 1);

        Slot slot = new Slot(startTime, endTime, slotId);

        slots.add(slot);

    }

    /**
     * Returns all slots in the timetable.
     *
     * @return a copy of the list containing the timetables slots
     */
    public List<Slot> getSlots() {
        return new ArrayList<>(slots);
    }

}
