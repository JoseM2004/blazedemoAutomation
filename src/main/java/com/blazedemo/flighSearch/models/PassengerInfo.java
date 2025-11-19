package com.blazedemo.flighSearch.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PassengerInfo {
    private String fullName;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String cardType;
    private String cardNumber;
    private String cardExpiryMonth;
    private String cardExpiryYear;
    private String nameOnCard;
}
