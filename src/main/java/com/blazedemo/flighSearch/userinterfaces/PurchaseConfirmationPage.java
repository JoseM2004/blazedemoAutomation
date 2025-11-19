package com.blazedemo.flighSearch.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class PurchaseConfirmationPage extends PageObject {
    public static final Target PURCHASE_SUMMARY = Target.the("Resumen de compra")
            .located(By.xpath("//h1[contains(text(),'Thank you for your purchase today!')]"));

    // Elementos adicionales para verificar detalles de la confirmación
    public static final Target CONFIRMATION_ID = Target.the("ID de confirmación")
            .located(By.xpath("//td[contains(text(),'Id')]/following-sibling::td"));

    public static final Target PURCHASE_STATUS = Target.the("Estado de la compra")
            .located(By.xpath("//td[contains(text(),'Status')]/following-sibling::td"));

    public static final Target PURCHASE_AMOUNT = Target.the("Monto de la compra")
            .located(By.xpath("//td[contains(text(),'Amount')]/following-sibling::td"));

    public static final Target CARD_NUMBER = Target.the("Número de tarjeta")
            .located(By.xpath("//td[contains(text(),'Card Number')]/following-sibling::td"));

    public static final Target EXPIRATION_DATE = Target.the("Fecha de expiración")
            .located(By.xpath("//td[contains(text(),'Expiration')]/following-sibling::td"));
}
