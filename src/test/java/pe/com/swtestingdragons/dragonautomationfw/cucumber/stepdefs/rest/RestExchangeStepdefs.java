package pe.com.swtestingdragons.dragonautomationfw.cucumber.stepdefs.rest;

import io.cucumber.java.en.When;
import pe.com.swtestingdragons.dragonautomationfw.cucumber.stepdefs.CommonStepDefs;
import pe.com.swtestingdragons.dragonautomationfw.models.Exchange;
import pe.com.swtestingdragons.dragonautomationfw.util.Endpoints;
import pe.com.swtestingdragons.dragonautomationfw.util.RedmineEndpoints;

import java.util.Map;

public class RestExchangeStepdefs {


    private CommonStepDefs commonStepDefs;

    public RestExchangeStepdefs(CommonStepDefs commonStepDefs){
        this.commonStepDefs = commonStepDefs;
    }

    @When("System sends a request to exchange service:")
    public void systemSendsARequestToExchangeService(Map<String, String> exchangeData) {


        Exchange exchange  = new Exchange();
        exchange.setAmount(Double.parseDouble(exchangeData.get("amount")));
        exchange.setCurrencyIsoSource(exchangeData.get("currencyIsoSource"));
        exchange.setCurrencyIsoTarget(exchangeData.get("currencyIsoTarget"));

        commonStepDefs.response = commonStepDefs.request
                .body(exchange)
                .when()
                .post(Endpoints.API_EXCHANGE_CONVERTER);

    }
}
