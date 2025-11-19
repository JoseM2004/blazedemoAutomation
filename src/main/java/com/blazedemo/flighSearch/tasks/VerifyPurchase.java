package com.blazedemo.flighSearch.tasks;

import com.blazedemo.flighSearch.userinterfaces.PurchaseConfirmationPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import org.hamcrest.Matchers;


public class VerifyPurchase implements Task {

    @Override
    @Step("{0} verifica que la compra fue exitosa")
    public <T extends Actor> void performAs(T actor) {
        actor.should(
                GivenWhenThen.seeThat(WebElementQuestion.the(PurchaseConfirmationPage.PURCHASE_SUMMARY),
                        WebElementStateMatchers.isVisible()),

                GivenWhenThen.seeThat(Text.of(PurchaseConfirmationPage.CONFIRMATION_ID),
                        Matchers.not(Matchers.isEmptyString())),

                GivenWhenThen.seeThat(Text.of(PurchaseConfirmationPage.PURCHASE_STATUS),
                        Matchers.equalToIgnoringCase("PendingCapture"))
        );
    }

    public static VerifyPurchase wasSuccessful() {
        return Tasks.instrumented(VerifyPurchase.class);
    }
}
