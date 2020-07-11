package pe.com.swtestingdragons.dragonautomationfw.cucumber.stepdefs.web;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pe.com.swtestingdragons.dragonautomationfw.cucumber.stepdefs.CommonStepDefs;
import pe.com.swtestingdragons.dragonautomationfw.pages.RedmineHomePage;

public class WebRedmineLoginStepDefs {

    CommonStepDefs commonStepDefs;
    RedmineHomePage redmineHomePage;

    public WebRedmineLoginStepDefs(CommonStepDefs commonStepDefs) {
        this.commonStepDefs = commonStepDefs;
    }

    @Given("I go to the Redmine login page on URL")
    public void iGoToTheRedmineLoginPageOnURL() {

        System.out.println("I go to the Redmine login page on URL");
    }

    @When("I login with my credentials user {string} and {string}")
    public void iLoginWithMyCredentialsUserAnd(String user, String password) {

        redmineHomePage = commonStepDefs.currentPage.login(user, password);
        commonStepDefs.currentPage = redmineHomePage;
    }

    @Then("I should see the homepage with the username {string}")
    public void iShouldSeeTheHomepageWithTheUsername(String username) {

        String userExpected = "Logged in as " + username;
        String userActual = redmineHomePage.getUserLogged();

        Assert.assertEquals(userExpected, userActual);
    }
}