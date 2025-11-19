package com.blazedemo.flighSearch.questions;

import com.blazedemo.flighSearch.userinterfaces.PurchaseConfirmationPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class PurchaseIsSuccessful implements Question<Boolean> {

    @Override
    @Step("el sistema muestra un resumen de los detalles del vuelo confirmando la compra")
    public Boolean answeredBy(Actor actor) {
        String summaryText = Text.of(PurchaseConfirmationPage.PURCHASE_SUMMARY).answeredBy(actor);
        return summaryText.contains("Thank you for your purchase today!") || summaryText.contains("purchase was successful");
    }

    public static PurchaseIsSuccessful withSummary() {
        return new PurchaseIsSuccessful();
    }
}
