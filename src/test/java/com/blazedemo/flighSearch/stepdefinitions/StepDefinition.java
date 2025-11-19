package com.blazedemo.flighSearch.stepdefinitions;


import com.blazedemo.flighSearch.models.PassengerInfo;
import com.blazedemo.flighSearch.questions.*;
import com.blazedemo.flighSearch.tasks.*;
import com.blazedemo.flighSearch.userinterfaces.HomePage;
import com.blazedemo.flighSearch.utils.WaitTime;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.webdriver.SerenityWebdriverManager;


import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.*;


public class StepDefinition {

    /*@Managed(driver = "chrome")
    private WebDriver browser;*/

    private Actor elViajero;


    @Before
    public void setTheStage() {
        elViajero = Actor.named("El Viajero")
                .whoCan(BrowseTheWeb.with(SerenityWebdriverManager.inThisTestThread().getCurrentDriver()));
    }

    @Given("que accedo al sistema de reservas")
    public void accedeAlSistema() {
        elViajero.attemptsTo(NavigateToHome.to("https://blazedemo.com/"));
    }


    @When("indico la ciudad de origen {string} y destino {string}")
    public void indicaCiudades(String origen, String destino) {
        elViajero.attemptsTo(SearchFlights.fromOriginToDestination(origen, destino));
    }

    @And("solicito la busqueda del vuelo")
    public void solicitoBusqueda() {

        WaitTime.putWaitTimeOf(2000);

        elViajero.attemptsTo(
                WaitUntil.the(HomePage.FIND_FLIGHTS_BUTTON, WebElementStateMatchers.isVisible()),
                Click.on(HomePage.FIND_FLIGHTS_BUTTON)
        );
    }

    @Then("veo las alternativas de vuelos disponibles")
    public void presentaVuelos() {
        /*elViajero.should(
                GivenWhenThen.seeThat(WebElementQuestion.the(FlightsListPage.FLIGHT_DETAILS),
                        WebElementStateMatchers.isVisible())
        );*/

        elViajero.should(seeThat(FlightsAreAvailable.toTheUser(), is(true)));

    }

    @And("visualizo los detalles de los vuelos")
    public void visualizaDetalles() {

        /*elViajero.should(
                seeThat(
                        "La lista de vuelos está cargada",
                        actor -> FlightsListPage.FLIGHT_DETAILS.resolveAllFor(actor).size(),
                        Matchers.greaterThan(0)
                )
        );*/

        elViajero.should(seeThat(FlightDetailsAreVisible.successfully(), greaterThan(0)));

    }

    @Given("que observo las alternativas de vuelos disponibles")
    public void observaVuelos() {
        // Ya se cumple con el escenario anterior
    }

    @When("elijo una opcion de vuelo")
    public void eligeVuelo() {
        WaitTime.putWaitTimeOf(2000);
        elViajero.attemptsTo(SelectFlight.selectFlight());
    }

    @Then("veo que mi vuelo ha sido reservado")
    public void sistemaReservaVuelo() {
        // Validar que se muestra el mensaje de reserva
        /*elViajero.should(
                seeThat(
                        Text.of(PurchaseFormPage.RESERVATION_MESSAGE),
                        Matchers.containsString("has been reserved")
                )
        );*/

        elViajero.should(seeThat(FlightIsReserved.withMessage(), containsString("has been reserved")));
    }

    @And("visualizo el formulario de compra")
    public void visualizaFormulario() {
        /*elViajero.should(
                seeThat(WebElementQuestion.the(PurchaseFormPage.FIRST_NAME),
                        WebElementStateMatchers.isVisible())
        );*/

        elViajero.should(seeThat(PurchaseFormIsDisplayed.toTheUser(), is(true)));
    }

    @Given("que visualizo el formulario de compra")
    public void visualizaFormularioCompra() {
        // Ya se cumple con el paso anterior
    }

    @When("suministro la informacion requerida para la compra")
    public void suministraInfo(DataTable table) {

        Map<String, String> data = table.asMaps().get(0);

        PassengerInfo info = new PassengerInfo(
                data.get("fullName"),
                data.get("address"),
                data.get("city"),
                data.get("state"),
                data.get("zipCode"),
                data.get("cardType"),
                data.get("cardNumber"),
                data.get("cardExpiryMonth"),
                data.get("cardExpiryYear"),
                data.get("nameOnCard")
        );
        elViajero.attemptsTo(CompletePurchase.with(info));
    }

    @And("compro el vuelo")
    public void comproVuelo() {
        // Ya se ejecuta en el paso anterior
    }

    @Then("veo un resumen de los detalles del vuelo")
    public void muestraResumen() {
        //elViajero.attemptsTo(VerifyPurchase.wasSuccessful());
        WaitTime.putWaitTimeOf(2000);
        elViajero.should(seeThat(PurchaseIsSuccessful.withSummary(), is(true)));
    }
}
