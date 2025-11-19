package com.blazedemo.flighSearch.questions;

import com.blazedemo.flighSearch.userinterfaces.PurchaseFormPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class FlightIsReserved implements Question<String> {

    @Override
    @Step("el sistema reserva el vuelo mostrando el mensaje de confirmación")
    public String answeredBy(Actor actor) {
        return Text.of(PurchaseFormPage.RESERVATION_MESSAGE).answeredBy(actor);
    }

    public static FlightIsReserved withMessage() {
        return new FlightIsReserved();
    }
}
