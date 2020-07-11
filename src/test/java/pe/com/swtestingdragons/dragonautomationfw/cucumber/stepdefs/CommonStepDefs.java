package pe.com.swtestingdragons.dragonautomationfw.cucumber.stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pe.com.swtestingdragons.dragonautomationfw.base.BaseTest;
import pe.com.swtestingdragons.dragonautomationfw.pages.RedmineLoginPage;

import static io.restassured.RestAssured.given;

public class CommonStepDefs {

    public RequestSpecification request;
    public Response response;

    public RedmineLoginPage currentPage;

    public CommonStepDefs(){
        currentPage = new RedmineLoginPage(BaseTest.getDriver());
    }

    @Given("System is ready to sent request")
    public void systemIsReadyToSendRequest(){
        request = given();
    }

    @Then("The response status should be {int}")
    public void theResponseStatusShouldBe(int code) {

        response.then()
                .statusCode(code);
    }
}