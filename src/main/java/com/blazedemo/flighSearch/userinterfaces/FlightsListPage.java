package com.blazedemo.flighSearch.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class FlightsListPage extends PageObject {
    public static final Target CHOOSE_FLIGHT_BUTTON = Target.the("Botón elegir vuelo {0}")
            .locatedBy("//form[contains(@name, '')]//input[@value='Choose This Flight' and following-sibling::input[@name='flight'][@value='{0}']]");

    public static final Target FLIGHT_DETAILS = Target.the("Detalles de vuelos")
            .located(By.xpath("//table[@class='table']/tbody/tr"));

    // Para obtener información específica de cada vuelo
    public static final Target FLIGHT_NUMBER = Target.the("Número de vuelo")
            .locatedBy("//tr[{0}]/td[2]"); // Columna 2 tiene el número

    public static final Target AIRLINE_NAME = Target.the("Nombre aerolínea")
            .locatedBy("//tr[{0}]/td[3]"); // Columna 3 tiene la aerolínea

    public static final Target FLIGHT_PRICE = Target.the("Precio del vuelo")
            .locatedBy("//tr[{0}]/td[6]"); // Columna 6 tiene el precio
}
