package com.blazedemo.flighSearch.tasks;

import com.blazedemo.flighSearch.userinterfaces.HomePage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

public class SearchFlights implements Task {
    private final String originCity;
    private final String destinationCity;


    public SearchFlights(String originCity, String destinationCity) {
        this.originCity = originCity;
        this.destinationCity = destinationCity;
    }

    @Override
    @Step("{0} selecciona ciudades de origen y destino")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(

                SelectFromOptions.byVisibleText(originCity).from(HomePage.ORIGIN_CITY),
                SelectFromOptions.byVisibleText(destinationCity).from(HomePage.DESTINATION_CITY)
                //Click.on(HomePage.FIND_FLIGHTS_BUTTON)
        );
    }

    public static SearchFlights fromOriginToDestination(String origin, String destination) {
        return Tasks.instrumented(SearchFlights.class, origin, destination);
    }
}
