# booking-scheduler
A Java module that lets you create either a fixed schedule with equal time slots (for example a laundry room with 2-hour slots) or a flexible schedule with freely defined booking lengths (for example a barber, where one customer needs 3 hours and the next only 30 minutes).


## What it does
- Creates and lists time slots
- Books a slot with a name and email
- Throws an exception if a slot is already booked

## What it does not do
- No database or file storage, everything is in memory
- No user interface

## Installation
Requires Java 21 or later. Clone the repo and copy `lib/src/main/java/org/bookingscheduler` into your project.

## Usage

### Fixed timetable (example: a laundry room with 2-hour slots)

```java
import org.bookingscheduler.*;
import java.time.LocalTime;

// Slot duration in minutes, fixed = true, opening time, closing time
TimeTable laundry = new TimeTable(120, true, LocalTime.of(8, 0), LocalTime.of(20, 0));

// Slots are created automatically: 08-10, 10-12, ... 18-20
Slot slot = laundry.getSlots().get(0);
slot.book(new Booking("Anna", "anna@example.com"));

System.out.println(slot.getBooking().getCustomerName()); // Anna

slot.book(new Booking("Erik", "erik@example.com")); // throws an exception, slot is already booked
```

### Flexible timetable (e.g. a barber)

```java
// No slot duration for a flexible timetable, fixed = false
TimeTable barber = new TimeTable(null, false, LocalTime.of(9, 0), LocalTime.of(17, 0));

barber.addSlot(LocalTime.of(10, 0), LocalTime.of(10, 30)); // a 30 minute haircut
barber.addSlot(LocalTime.of(12, 0), LocalTime.of(15, 0));  // a 3 hour treatment

Slot slot = barber.getSlotById("<id>");

## License
MIT, see LICENSE.