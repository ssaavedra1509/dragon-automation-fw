package pe.com.swtestingdragons.dragonautomationfw.cucumber.stepdefs.web;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pe.com.swtestingdragons.dragonautomationfw.cucumber.stepdefs.CommonStepDefs;
import pe.com.swtestingdragons.dragonautomationfw.models.RedmineProject;
import pe.com.swtestingdragons.dragonautomationfw.pages.RedmineHomePage;
import pe.com.swtestingdragons.dragonautomationfw.pages.RedmineProjectsPage;
import pe.com.swtestingdragons.dragonautomationfw.util.AppUtil;

import java.util.Map;

public class WebRedmineProjectsStepDefs {

    CommonStepDefs commonStepDefs;
    RedmineProjectsPage redmineProjectsPage;

    public WebRedmineProjectsStepDefs(CommonStepDefs commonStepDefs){
        this.commonStepDefs = commonStepDefs;
    }

    @And("I create a project")
    public void iCreateAProject(Map<String, String> projectData) {

        RedmineHomePage redmineHomePage = (RedmineHomePage)commonStepDefs.currentPage;
        redmineProjectsPage = redmineHomePage.clickOnLink("Projects");

        String number = AppUtil.generateRandomNumber();

        RedmineProject redmineProject = new RedmineProject();
        redmineProject.setName(projectData.get("name") + number);
        redmineProject.setDescription(projectData.get("description") + number);
        redmineProject.setHomePage(projectData.get("homepage") + number);
        redmineProject.setIs_public(Boolean.parseBoolean(projectData.get("public")));

        redmineProjectsPage.createProject(redmineProject);
    }

    @Then("The Project was successfully created")
    public void theProjectWasSuccessfullyCreated() {

        String expectedMessage = "Successful creation.";

        Assert.assertEquals("The message is not correct", expectedMessage,redmineProjectsPage.getUIMessage() );
    }
}