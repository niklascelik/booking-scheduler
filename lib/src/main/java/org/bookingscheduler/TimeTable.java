package org.bookingscheduler;

public class TimeTable {

    private Integer slotDuration;
    private boolean fixed;

    public TimeTable(Integer slotDuration, boolean fixed) {
            if (slotDuration == null && fixed) {
                throw new IllegalArgumentException(
                        "You have to decalare a valid slotDuration if you want to use a fixed schedule.");

            }
            if (slotDuration != null&& !fixed) {
                throw new IllegalArgumentException(
                        "You have chosen a flexible schedule dont enter a slotDuration");
            }
            if(slotDuration != null && slotDuration <= 0 && fixed) {
                throw new IllegalArgumentException(
                    "Please enter a valid slot duration.");
            }

            this.slotDuration = slotDuration;
            this.fixed = fixed;

        }

    public void setSlotDuration(int slotDuration) {
        this.slotDuration = slotDuration;
    }

    public void setFixed(boolean fixed) {
        this.fixed = fixed;
    }

    public Integer getSlotDuration() {
        return slotDuration;
    }

    public boolean getFixed() {
        return fixed;
    }
}