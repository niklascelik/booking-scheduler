package org.bookingscheduler;

import java.util.UUID;

public class Booking {

    private String bookingId;
    private String customerName;
    private String customerEmail;

    public Booking(String customerName, String customerEmail) {

        this.bookingId = UUID.randomUUID().toString();
        this.customerName = customerName;
        if(isEmailValid(customerEmail)){
        this.customerEmail = customerEmail;
        }

    }

    public String getBookingId() {
        return bookingId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerName(String customerName) {
        if (customerName.length() > 0) {
            this.customerName = customerName;
        } else {
        throw new IllegalArgumentException("Please enter a valid name.");
        }
    }

    public void setCustomerEmail(String customerEmail) {
        if (isEmailValid(customerEmail)) {
            this.customerEmail = customerEmail;
        } else {
        throw new IllegalArgumentException("Please enter a valid Email.");
        }
    }

    public boolean isEmailValid(String email) {

        if (email != null
                && email.length() > 0
                && email.contains("@")
                && email.contains(".")) {
            return true;
        }

        return false;

    }

}
