import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;

import java.util.ArrayList;


import static org.junit.Assert.assertEquals;

public class SberTest extends BaseSteps {

    @Test
    @Ignore
    public void testInsurance(){
        driver.get(baseUrl);
        driver.findElement(By.xpath("//button[contains(@aria-label,'Страхование')]")).click();
        WebElement traveler = driver.findElement(By.xpath("//a[@class='lg-menu__sub-link'][contains(text(),'путешественников')]"));
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        wait.until(ExpectedConditions.visibilityOf(traveler)).click();

        driver.findElement(By.xpath("//a[@target]//img[contains(@src,'portal')]")).click();
        WebElement title = driver.findElement(By.xpath("//div[contains(@class,'sbrf-rich-outer')]/h1"));
        assertEquals("Страхование путешественников",title.getText());

        ArrayList tabs2 = new ArrayList (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1).toString());

        driver.findElement(By.xpath("//div[contains(text(),'35')]")).click();

        driver.findElement(By.xpath("//span[contains(@class,'b-button-block-center')]/span")).click();


        fillField(By.xpath("//div[contains(@ng-class,'_surname')]/input"),"Ivanov");
        fillField(By.xpath("//div[contains(@ng-class,'_name')]/input"),"Ivan");
        fillField(By.xpath("//div[contains(@ng-class,'_birth')]/input"),"10111991");

        fillField(By.xpath("//div[contains(@ng-class,'.surname')]/input"),"Иванов");
        fillField(By.xpath("//div[contains(@ng-class,'.name')]/input"),"Иван");
        fillField(By.xpath("//div[contains(@ng-class,'.middlename')]/input"),"Иванович");
        fillField(By.xpath("//div[contains(@ng-class,'.birthDate')]/input"),"10111991");

        fillField(By.xpath("//div[contains(@ng-class,'.passport_series')]/input"),"1111");
        fillField(By.xpath("//div[contains(@ng-class,'.passport_number')]/input"),"222222");
        fillField(By.xpath("//div[contains(@ng-class,'.issueDate')]/input"),"10112011");
        fillField(By.xpath("//div[contains(@ng-class,'.issuePlace')]/textarea"),"УВД г. Москва");

        driver.findElement(By.xpath("//div[contains(@class,'b-button-block-center')]/span[@class='b-continue-btn']")).click();

        WebElement error = driver.findElement(By.xpath("//div[contains(@class,'b-form-center-pos b-form-error-message')]/div[contains(@ng-show,'invalid')]"));
        assertEquals("Заполнены не все обязательные поля",error.getText());


    }
}
