package org.bookingscheduler;

import org.junit.jupiter.api.Test;

class TimeTableTest {

    @Test
    void flexibleScheduleWithNullSlotDuration() {
        TimeTable timeTable = new TimeTable(null, false);
    }
}