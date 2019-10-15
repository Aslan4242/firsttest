package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

public class MainPage {
    @FindBy(xpath = "//div[contains(@class,'kit-col kit-col_xs_10 lg-menu__row')]")
    WebElement mainMenu;

    @FindBy(xpath = "//div[@id='submenu-5']//ul[@aria-label='Подменю']")
    WebElement subMenu;


         public MainPage(){
            PageFactory.initElements(BaseSteps.getDriver(), this);
        }


    public void selectMenuItem(String itemName){
        mainMenu.findElement(By.xpath("//li//span[contains(text(),'"+itemName+"')]")).click();
    }

    public void selectInsuranceItem(String itemName){
        subMenu.findElement(By.xpath("//a[@class='lg-menu__sub-link'][contains(text(),'"+itemName+"')]")).click();
    }
}
