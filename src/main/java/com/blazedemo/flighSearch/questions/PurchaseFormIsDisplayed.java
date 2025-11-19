package com.blazedemo.flighSearch.questions;

import com.blazedemo.flighSearch.userinterfaces.PurchaseFormPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.WebElementQuestion;

public class PurchaseFormIsDisplayed implements Question<Boolean> {

    @Override
    @Step("se visualiza el formulario de compra")
    public Boolean answeredBy(Actor actor) {
        return WebElementQuestion.the(PurchaseFormPage.FIRST_NAME).answeredBy(actor)
                .isVisible();
    }

    public static PurchaseFormIsDisplayed toTheUser() {
        return new PurchaseFormIsDisplayed();
    }
}