package com.blazedemo.flighSearch.questions;

import com.blazedemo.flighSearch.userinterfaces.FlightsListPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.List;

public class FlightDetailsAreVisible implements Question<Integer> {

    @Override
    @Step("se visualizan los detalles de los vuelos")
    public Integer answeredBy(Actor actor) {
        List<?> flightElements = FlightsListPage.FLIGHT_DETAILS.resolveAllFor(actor);
        return flightElements.size();
    }

    public static FlightDetailsAreVisible successfully() {
        return new FlightDetailsAreVisible();
    }
}
