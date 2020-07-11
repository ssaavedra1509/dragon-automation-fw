package pe.com.swtestingdragons.dragonautomationfw.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pe.com.swtestingdragons.dragonautomationfw.models.RedmineProject;

public class RedmineProjectsPage extends RedmineLoginPage {

    private By btnNewProject = By.xpath("//a[text()='New project']");
    private By txtProjectName = By.id("project_name");
    private By txtProjectDescription = By.id("project_description");
    private By txtHomePage = By.id("project_homepage");
    private By chkPublicProject = By.id("project_is_public");
    private By btnCreate = By.name("commit");
    private By lblMessage = By.id("flash_notice");

    public RedmineProjectsPage(WebDriver driver) {
        super(driver);
    }

    public void createProject(RedmineProject redmineProject) {

        driver.findElement(btnNewProject).click();
        driver.findElement(txtProjectName).sendKeys(redmineProject.getName());
        driver.findElement(txtProjectDescription).sendKeys(redmineProject.getDescription());
        driver.findElement(txtHomePage).sendKeys(redmineProject.getHomePage());

        WebElement checkBoxProject = driver.findElement(chkPublicProject);
        if(redmineProject.getIs_public()){
            if(!checkBoxProject.isSelected())
                checkBoxProject.click();
        }else {
            if(checkBoxProject.isSelected())
               checkBoxProject.click();
        }

        driver.findElement(btnCreate).click();
    }

    public String getUIMessage(){
        //Explicit wait
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(lblMessage)));
        return driver.findElement(lblMessage).getText();
    }
}