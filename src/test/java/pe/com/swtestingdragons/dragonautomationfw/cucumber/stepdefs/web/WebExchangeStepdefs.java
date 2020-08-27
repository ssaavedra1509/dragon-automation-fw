package pe.com.swtestingdragons.dragonautomationfw.cucumber.stepdefs.web;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pe.com.swtestingdragons.dragonautomationfw.cucumber.stepdefs.CommonStepDefs;
import pe.com.swtestingdragons.dragonautomationfw.models.Exchange;

import java.util.Map;

public class WebExchangeStepdefs {

    CommonStepDefs commonStepDefs;

    public WebExchangeStepdefs(CommonStepDefs commonStepDefs) {
        this.commonStepDefs = commonStepDefs;
    }

    @Given("I go to the Exchange page on URL")
    public void iGoToTheExchangePageOnURL() {

        System.out.println("I go to the Exchange page on URL");
    }

    @When("I want to perform the following exchange:")
    public void iWantToPerformTheFollowingExchange(Map<String, String> exchangeData) {

        Exchange exchange  = new Exchange();
        exchange.setAmount(Double.parseDouble(exchangeData.get("amount")));
        exchange.setCurrencyIsoSource(exchangeData.get("currency_source"));
        exchange.setCurrencyIsoTarget(exchangeData.get("currency_target"));

        commonStepDefs.currentPage.exchange(exchange);
    }


    @Then("the following should be displayed on the screen:")
    public void theFollowingShouldBeDisplayedOnTheScreen(Map<String, String> expectedData) {

        Assert.assertEquals(expectedData.get("convertedAmount"), commonStepDefs.currentPage.getTextConvertedAmount());
        Assert.assertEquals(expectedData.get("exchangeRate"), commonStepDefs.currentPage.getTextExchangeRate());
    }
}
