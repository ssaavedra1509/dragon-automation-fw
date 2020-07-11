package pe.com.swtestingdragons.dragonautomationfw.cucumber.stepdefs.rest;


import io.cucumber.java.en.When;
import pe.com.swtestingdragons.dragonautomationfw.cucumber.stepdefs.CommonStepDefs;
import pe.com.swtestingdragons.dragonautomationfw.models.Entity;
import pe.com.swtestingdragons.dragonautomationfw.models.RedmineProject;
import pe.com.swtestingdragons.dragonautomationfw.util.AppUtil;
import pe.com.swtestingdragons.dragonautomationfw.util.RedmineEndpoints;

import java.util.Map;

public class RestCreateProjectStepdefs {

    private CommonStepDefs commonStepDefs;

    public RestCreateProjectStepdefs(CommonStepDefs commonStepDefs){
        this.commonStepDefs = commonStepDefs;
    }

    @When("System sends a request to create project service from redmine")
    public void systemSendsARequestToCreateProjectServiceFromRedmine(Map<String, String> projectData) {

        String randomNumber = AppUtil.generateRandomNumber();;

        RedmineProject redmineProject = new RedmineProject();
        redmineProject.setName(projectData.get("name") + randomNumber);
        redmineProject.setIdentifier(projectData.get("identifier") + randomNumber);
        redmineProject.setDescription(projectData.get("description"));
        redmineProject.setIs_public(Boolean.parseBoolean(projectData.get("is_public")));

        Entity entity = new Entity(redmineProject);

        commonStepDefs.response = commonStepDefs.request
                .body(entity)
                .when()
                    .post(RedmineEndpoints.ALL_REDMINE_PROJECTS_JSON);
    }
}