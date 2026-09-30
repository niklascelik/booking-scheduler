package org.bookingscheduler;

import java.util.UUID;

/**
 * Represents a booking with customer information and a unique booking ID.
 */
public class Booking {

    private String bookingId;
    private String customerName;
    private String customerEmail;

    /**
     * Creates a booking with customer name and email.
     *
     * @param customerName  the name of the customer
     * @param customerEmail the email address of the customer
     */
    public Booking(String customerName, String customerEmail) {

        this.bookingId = UUID.randomUUID().toString();
        if(isCustomerNameValid(customerName)){
            this.customerName = customerName;
        } else {
            throw new IllegalArgumentException("Please enter a valid name");
        }
        
        if (isEmailValid(customerEmail)) {
            this.customerEmail = customerEmail;
        } else {
                        throw new IllegalArgumentException("Please enter a valid Email");

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

    /**
     * Changes the customers name.
     *
     * @param customerName the new customer name.
     * @throws IllegalArgumentException if the name is empty.
     */
    public void setCustomerName(String customerName) {
        if (isCustomerNameValid(customerName)) {
            this.customerName = customerName;
        } else {
            throw new IllegalArgumentException("Please enter a valid name.");
        }
    }

    /**
     * Changes the customer's email address.
     *
     * @param customerEmail the new email address.
     * @throws IllegalArgumentException if the email is invalid.
     */
    public void setCustomerEmail(String customerEmail) {
        if (isEmailValid(customerEmail)) {
            this.customerEmail = customerEmail;
        } else {
            throw new IllegalArgumentException("Please enter a valid Email.");
        }
    }

    private boolean isEmailValid(String email) {
        if (email != null
                && email.length() > 0
                && email.contains("@")
                && email.contains(".")) {
            return true;
        }

        return false;

    }

    private boolean isCustomerNameValid(String customerName) {
        if (customerName != null && customerName.trim().length() > 0) {
            return true;
        }
        return false;
    }

}
