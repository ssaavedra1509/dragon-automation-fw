package pe.com.swtestingdragons.dragonautomationfw.base;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pe.com.swtestingdragons.dragonautomationfw.pages.RedmineLoginPage;
import pe.com.swtestingdragons.dragonautomationfw.util.Urls;

public class BaseTest {

    private static WebDriver driver;
    protected static RedmineLoginPage redmineLoginPage;

    @BeforeClass
    public static void setUpAndLaunchApp(){

       setChromeDriverProperty();

       driver = new ChromeDriver();
       //Implicit wait
       //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       driver.get(Urls.REDMINE_LOGIN);
       redmineLoginPage = new RedmineLoginPage(driver);
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }

    private static void setChromeDriverProperty(){
        if(System.getProperty("os.name").contains("Windows")) {
            System.setProperty("webdriver.chrome.driver", "resources/drivers/chromedriver.exe");
        }
        else{
            System.setProperty("webdriver.chrome.driver", "resources/drivers/chromedriver");
        }
    }

    public static WebDriver getDriver(){
        return driver;
    }
}