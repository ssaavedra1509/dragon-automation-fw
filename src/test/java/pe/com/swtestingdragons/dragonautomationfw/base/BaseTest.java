package pe.com.swtestingdragons.dragonautomationfw.base;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pe.com.swtestingdragons.dragonautomationfw.pages.ExchangeRatePage;
import pe.com.swtestingdragons.dragonautomationfw.pages.RedmineLoginPage;
import pe.com.swtestingdragons.dragonautomationfw.util.Urls;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    private static WebDriver driver;
    protected static ExchangeRatePage exchangeRatePage;

    @BeforeClass
    public static void setUpAndLaunchApp() {

        setChromeDriverProperty();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get(Urls.EXCHANGE_RATE_FRONTEND_URL);

        exchangeRatePage = new ExchangeRatePage(driver);
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    private static void setChromeDriverProperty() {
        if (System.getProperty("os.name").contains("Windows")) {
            System.setProperty("webdriver.chrome.driver", "resources/drivers/windows/chromedriver83.exe");
        } else if (System.getProperty("os.name").contains("Linux")) {
            System.setProperty("webdriver.chrome.driver", "resources/drivers/linux/chromedriver83");
        } else if (System.getProperty("os.name").contains("Mac")) {
            System.setProperty("webdriver.chrome.driver", "resources/drivers/mac/chromedriver83");
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }
}