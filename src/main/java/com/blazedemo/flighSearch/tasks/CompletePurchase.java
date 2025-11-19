package com.blazedemo.flighSearch.tasks;

import com.blazedemo.flighSearch.interactions.EnterPurchase;
import com.blazedemo.flighSearch.models.PassengerInfo;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
//import net.serenitybdd.screenplay.actions.Enter;


public class CompletePurchase implements Task {
    private final PassengerInfo info;

    public CompletePurchase(PassengerInfo info) {
        this.info = info;
    }

    @Override
    @Step("{0} completa la información de compra")
    public <T extends Actor> void performAs(T actor) {

        EnterPurchase enter = new EnterPurchase(info);
        enter.performAs(actor);

    }

    public static CompletePurchase with(PassengerInfo info) {
        return Tasks.instrumented(CompletePurchase.class, info);
    }
}

