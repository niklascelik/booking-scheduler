package org.bookingscheduler;

import java.time.LocalTime;

public class Slot {
    private LocalTime startTime;
    private LocalTime endTime;
    private final String slotId;

    public Slot(LocalTime startTime, LocalTime endTime, String slotId) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.slotId = slotId;

    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;

    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public String slotId(){
        return slotId;

    }
}
