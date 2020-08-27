package pe.com.swtestingdragons.dragonautomationfw.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pe.com.swtestingdragons.dragonautomationfw.models.Exchange;

public class ExchangeRatePage {

    protected WebDriver driver;

    private By lblTitle = By.xpath("/html/body/app-root/app-exchange-rate/div/div[1]");
    private By txtCurrencySource = By.id("staticEmail");
    private By txtCurrencyTarget = By.xpath("/html/body/app-root/app-exchange-rate/div/div[2]/form/div[2]/div[1]/input");
    private By cbxCurrencySource = By.xpath("/html/body/app-root/app-exchange-rate/div/div[2]/form/div[1]/div[2]/div/select");
    private By cbxCurrencyTarget = By.xpath("/html/body/app-root/app-exchange-rate/div/div[2]/form/div[2]/div[2]/div/select");
    private By btnConverter = By.xpath("/html/body/app-root/app-exchange-rate/div/div[2]/form/div[1]/div[3]/button");
    private By txtExchangeRate = By.xpath("/html/body/app-root/app-exchange-rate/div/div[2]/form/div[3]/div/input");

    public ExchangeRatePage(WebDriver driver) {
        this.driver = driver;
    }


    public void exchange(Exchange exchange){

        driver.findElement(txtCurrencySource).sendKeys(String.valueOf(exchange.getAmount()));
        selectCurrency(driver.findElement(cbxCurrencySource),exchange.getCurrencyIsoSource());
        selectCurrency(driver.findElement(cbxCurrencyTarget),exchange.getCurrencyIsoTarget());
        clickBtnConverter();

    }

    public void selectCurrency(WebElement cbxCurrency, String option){
        Select select = new Select(cbxCurrency);
        select.selectByVisibleText(option);
    }

    public void clickBtnConverter(){
        driver.findElement(btnConverter).click();
    }

    public String getTextConvertedAmount(){
        return driver.findElement(txtCurrencyTarget).getAttribute("ng-reflect-model");
    }

    public String getTextExchangeRate(){
        return driver.findElement(txtExchangeRate).getAttribute("ng-reflect-model");
    }
}
