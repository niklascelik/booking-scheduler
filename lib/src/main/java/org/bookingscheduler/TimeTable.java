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

        if(fixed){
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
     * Throws an expection if a slot duration is provided for a flexible schedule.
     * Throws an expection if a slot duration is null or less than 0 for a fixed
     * schedule.
     * 
     * @param slotDuration
     * @param fixed
     */
    public void validateSlotDuration(Integer slotDuration, boolean fixed) {
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
    public void generateSlots() {
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
                System.out.println(slot.getStartTime() + " - " + slot.getEndTime() +" - " + slot.getSlotId());

        }
    }
    public boolean isSlotAvailable(){

    }
}