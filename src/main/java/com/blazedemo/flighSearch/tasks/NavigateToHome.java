package com.blazedemo.flighSearch.tasks;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateToHome implements Task {
    private final String url;

    public NavigateToHome(String url) {
        this.url = url;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.url(url));
    }

    public static NavigateToHome start(String url) {
        return Tasks.instrumented(NavigateToHome.class, url);
    }
}