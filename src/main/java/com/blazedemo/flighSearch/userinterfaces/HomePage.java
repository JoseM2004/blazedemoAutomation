package com.blazedemo.flighSearch.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class HomePage extends PageObject {
    public static final Target ORIGIN_CITY = Target.the("Ciudad de origen")
            .located(By.name("fromPort"));
    public static final Target DESTINATION_CITY = Target.the("Ciudad de destino")
            .located(By.name("toPort"));
    public static final Target FIND_FLIGHTS_BUTTON = Target.the("Botón buscar vuelos")
            .located(By.xpath("//input[@type='submit' and @value='Find Flights']"));
}
