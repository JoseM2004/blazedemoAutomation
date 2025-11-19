package com.blazedemo.flighSearch.tasks;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class SelectFlight implements Task {
    @Override
    @Step("{0} selecciona el primer vuelo disponible")
    public <T extends Actor> void performAs(T actor) {

        Target FlightButton = Target.the("Primer botón elegir vuelo")
                .located(By.xpath("(//input[@value='Choose This Flight'])[2]"));

        actor.attemptsTo(
                WaitUntil.the(FlightButton, WebElementStateMatchers.isClickable()),
                Click.on(FlightButton)
        );
    }

    public static SelectFlight selectFlight() {
        return Tasks.instrumented(SelectFlight.class);
    }
}
