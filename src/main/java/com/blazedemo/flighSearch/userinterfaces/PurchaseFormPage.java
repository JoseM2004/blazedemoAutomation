package com.blazedemo.flighSearch.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class PurchaseFormPage extends PageObject {

    public static final Target RESERVATION_MESSAGE = Target.the("Mensaje de reserva confirmada")
            .located(By.xpath("//h2[contains(text(), 'has been reserved')]"));

    public static final Target FLIGHT_DETAILS = Target.the("Detalles del vuelo reservado")
            .located(By.xpath("//h2/following-sibling::p"));

    public static final Target FIRST_NAME = Target.the("Nombre")
            .located(By.id("inputName"));

    public static final Target ADDRESS = Target.the("Dirección")
            .located(By.id("address"));

    public static final Target CITY = Target.the("Ciudad")
            .located(By.id("city"));

    public static final Target STATE = Target.the("Estado")
            .located(By.id("state"));

    public static final Target ZIP_CODE = Target.the("Código postal")
            .located(By.id("zipCode"));

    public static final Target CARD_TYPE = Target.the("Tipo de tarjeta")
            .located(By.name("cardType"));

    public static final Target CARD_NUMBER = Target.the("Número de tarjeta")
            .located(By.id("creditCardNumber"));

    public static final Target CARD_EXPIRY_MONTH = Target.the("Mes expiración")
            .located(By.id("creditCardMonth"));

    public static final Target CARD_EXPIRY_YEAR = Target.the("Año expiración")
            .located(By.id("creditCardYear"));

    public static final Target NAME_ON_CARD = Target.the("Nombre en tarjeta")
            .located(By.id("nameOnCard"));

    public static final Target REMEMBER_ME = Target.the("Recordarme")
            .located(By.id("rememberMe"));

    public static final Target PURCHASE_BUTTON = Target.the("Botón comprar")
            .located(By.xpath("//input[@value='Purchase Flight']"));
}