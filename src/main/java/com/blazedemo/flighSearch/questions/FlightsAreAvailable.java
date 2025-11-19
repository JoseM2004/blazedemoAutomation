package com.blazedemo.flighSearch.questions;

import com.blazedemo.flighSearch.userinterfaces.FlightsListPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.WebElementQuestion;

public class FlightsAreAvailable implements Question<Boolean> {

    @Override
    @Step("el sistema presenta las alternativas de vuelos disponibles")
    public Boolean answeredBy(Actor actor) {
        return WebElementQuestion.the(FlightsListPage.FLIGHT_DETAILS).answeredBy(actor)
                .isVisible();
    }

    public static FlightsAreAvailable toTheUser() {
        return new FlightsAreAvailable();
    }
}
