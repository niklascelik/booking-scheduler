package org.bookingscheduler;
/**
 * Represents a timetable with either a fixed or flexible schedule.
 * 
 * A fixed schedule reuires a slot duration while a flexible must not have a slot duration.
 */
public class TimeTable {

    private Integer slotDuration;
    private boolean fixed;

    public TimeTable(Integer slotDuration, boolean fixed) {
        validateSlotDuration(slotDuration, fixed);
        this.slotDuration = slotDuration;
        this.fixed = fixed;

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
     *  Throws an expection if a slot duration is provided for a flexible schedule.
     * Throws an expection if a slot duration is null or less than 0 for a fixed schedule.
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
    
}