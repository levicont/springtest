package com.lvg.springtest.models;

import java.io.Serializable;

/**
 *
 * @author Victor
 */
public class ContactSummary implements Serializable{
    
    private String firstName;
    private String lastName;
    private String telNumber;

    public ContactSummary(String firstName, String lastName, String telNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.telNumber = telNumber;
    }

    public String getFirstName() {
        return firstName;
    }
   

    public String getLastName() {
        return lastName;
    }
   

    public String getTelNumber() {
        return telNumber;
    }
    

    @Override
    public String toString() {
        return "firstName: " + firstName + ", lastName: " 
                + lastName + ", telNumber: " + telNumber;
    }
    
    
    
}
