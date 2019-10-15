package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TravelerInsurancePage extends BasePage {

    @FindBy(xpath = "//div[contains(@class,'sbrf-rich-outer')]/h1")
    public WebElement title;

    @FindBy(xpath = "//a[@target]//img[contains(@src,'portal')]")
    public WebElement button;

    public TravelerInsurancePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void waitButtonClickable(){
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        wait.until(ExpectedConditions.visibilityOf(
                driver.findElement(By.xpath("//a[@target]//img[contains(@src,'portal')]")))).click();
    }
}
