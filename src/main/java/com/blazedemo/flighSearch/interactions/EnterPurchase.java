package com.blazedemo.flighSearch.interactions;

import com.blazedemo.flighSearch.models.PassengerInfo;
import com.blazedemo.flighSearch.userinterfaces.PurchaseFormPage;
import com.blazedemo.flighSearch.utils.WaitTime;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

public class EnterPurchase implements Interaction {

    private final PassengerInfo info;

    public EnterPurchase(PassengerInfo info) {
        this.info = info;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(net.serenitybdd.screenplay.actions.Enter.theValue(info.getFullName()).into(PurchaseFormPage.FIRST_NAME));
        WaitTime.putWaitTimeOf(500);
        actor.attemptsTo(net.serenitybdd.screenplay.actions.Enter.theValue(info.getAddress()).into(PurchaseFormPage.ADDRESS));
        WaitTime.putWaitTimeOf(500);
        actor.attemptsTo(net.serenitybdd.screenplay.actions.Enter.theValue(info.getCity()).into(PurchaseFormPage.CITY));
        WaitTime.putWaitTimeOf(500);
        actor.attemptsTo(net.serenitybdd.screenplay.actions.Enter.theValue(info.getState()).into(PurchaseFormPage.STATE));
        WaitTime.putWaitTimeOf(500);
        actor.attemptsTo(net.serenitybdd.screenplay.actions.Enter.theValue(info.getZipCode()).into(PurchaseFormPage.ZIP_CODE));
        WaitTime.putWaitTimeOf(500);
        actor.attemptsTo(SelectFromOptions.byVisibleText(info.getCardType()).from(PurchaseFormPage.CARD_TYPE));
        WaitTime.putWaitTimeOf(500);
        actor.attemptsTo(net.serenitybdd.screenplay.actions.Enter.theValue(info.getCardNumber()).into(PurchaseFormPage.CARD_NUMBER));
        WaitTime.putWaitTimeOf(500);
        actor.attemptsTo(net.serenitybdd.screenplay.actions.Enter.theValue(info.getCardExpiryMonth()).into(PurchaseFormPage.CARD_EXPIRY_MONTH));
        WaitTime.putWaitTimeOf(500);
        actor.attemptsTo(net.serenitybdd.screenplay.actions.Enter.theValue(info.getCardExpiryYear()).into(PurchaseFormPage.CARD_EXPIRY_YEAR));
        WaitTime.putWaitTimeOf(500);
        actor.attemptsTo(net.serenitybdd.screenplay.actions.Enter.theValue(info.getNameOnCard()).into(PurchaseFormPage.NAME_ON_CARD));
        WaitTime.putWaitTimeOf(500);
        actor.attemptsTo( Click.on(PurchaseFormPage.REMEMBER_ME));
        WaitTime.putWaitTimeOf(500);
        actor.attemptsTo(Click.on(PurchaseFormPage.PURCHASE_BUTTON));
    }
}
