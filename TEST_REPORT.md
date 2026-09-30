# Test Report

## Test Summary

The module was tested using automated unit tests with JUnit 5. The tests cover the main functionality  and error handling of the `TimeTable`, `Slot` and `Booking`classes.

| What was tested | How it was tested | Test result |
|---|---|---|
|`TimeTable` Constructor| `shouldCreateFixedTimetable()`- Created a fixed timetable with 30 mins slots and checked its configurations and generated slots.|Passed|
|`TimeTable` Constructor| `shouldCreateFlexibleTimetable()` - Created a flexible timetable and checked its configurations.|Passed| 
|`generateSlots()` | `shouldCreateCorrectSlotTimes()` – checked first two slot times.|Passed| 
|`generateSlots()` | `shouldCreateCorrectAmountOfSlots()` - Checked that it created the right amount of slots.|Passed| 
|`getSlotById()` | `shouldFindSlotById()` - Checked that it found the correct id.|Passed|
|`getSlotById()` | `shouldReturnNullWhenSlotIdDoesntExist()` - searched for a slot id that didnt exist.|Passed|
|`addSlot()` | `shouldAddSlotToFlexibleTimetable()` - added a valid slot to a flexible timetable.|Passed|
|`TimeTable` Constructor|`shouldRejectSlotDurationForFlexibleTimeTable()`- created a flexible timetable with a slot duration|Passed| 
|`addSlot()` | `shouldRejectSlotOutsideSchedule()` - tried to add a slot outside the timetable schedule.|Passed|
|`addSlot()` | `shouldRejectOverlappingSlot()` - tried to add an overlapping slot.|Passed|
|`addSlot()`|`shouldRejectSlotWhenStartTimeisAfterEndTime()`-tried to add a slot where the start time was after the end time.|Passed|
|`TimeTable` Constructor|`shouldRejectFixedTimetableWithoutSlotDuration()`-tried to create a fixed timetable without a slot duration.|Passed|
|`TimeTable` Constructor|`shouldRejectInvalidSlotDuration()`-tried to create a fixed timetable with a slot duration of 0.|Passed|
|`addSlot()`|`shouldGiveAddedSlotAnId()`-added a slot and checked that it received id "1"|Passed|
|`getOpeningTime()` & `getClosingTime`|`shouldReturnOpeningTimeAndClosingTime()`-checked the timetables opening and closing times|Passed|
|`getStartTime()` & `getEndTime()`|`shouldReturnStartTimeAndEndTime()`-checked the slots start and end times|Passed|
|`getSlotId()`|`shouldReturnId()`-checked the slot ID|Passed|
|`getBooking()`|`shouldReturnBooking()`-booked a slot and checked the booking|Passed|
|`getBooking()`|`shouldNotHaveBookingWhenCreated()`-created a slot and checked that it had no booking. |Passed|
|`book()`|`shouldRejectDoubleBooking()`-tried to book an already booked slot. |Passed|
|`Booking` constructor|`shouldHaveUniqueBookingIds()`-created two bookings and checked that their idss were different. |Passed|
|`getCustomerName()` & `getCustomerEmail()`|`shouldReturnCustomerNameAndEmail()`-created a booking and checked the customer name and email. |Passed|
|`setCustomerName()` & `setCustomerEmail()`|`shouldChangeCustomerNameAndEmail()`-changed the customer name and email and checked the new values. |Passed|
|`Booking` Constructor|`shouldRejectEmptyName()`-tried to create a booking with an empty customer name. |Passed|
|`Booking` Constructor|`shouldRejectEmptyEmail()` – tried to create a booking with an empty email. |Passed|
|`Booking` Constructor|`shouldRejectEmailWithoutAtSymbol()` – tried to create a booking with an email without "@". |Passed|
|`Booking` Constructor|`shouldRejectEmailWithoutPeriod()` – tried to create a booking with an email without ".". |Passed|
|`Booking` Constructor|`shouldRejectNameMadeoutofSpaces()` – tried to create a booking with a name made out of spaces. |Passed|
|`setCustomerName()` |`shouldRejectInvalidCustomerNameWhenChanging()`–tried to change the customer name to spaces|Passed|
|`setCustomerEmail()`|`shouldRejectInvalidEmailWhenChanging()`–tried to change the customer email to a email with out "@" |Passed|