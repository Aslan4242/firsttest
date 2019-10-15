import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;

import static org.junit.Assert.assertEquals;

public class InsuranceTest extends BaseSteps {
    @Test
    @Ignore
    public void testInsurance() {
        driver.get(baseUrl);
        driver.findElement(By.xpath("(//div[@id='main-navbar']//ol//a[contains(@data-toggle,'dropdown')])[1]")).click();
        driver.findElement(By.xpath("//li[contains(@class,'adv-analytics-navigation-line3')]//a[contains(text(),'ДМС')]")).click();
        WebElement sendBtn = driver.findElement(By.xpath("//a[contains(text(),'Отправить заявку')]"));
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        wait.until(ExpectedConditions.visibilityOf(sendBtn)).click();

        WebElement title = driver.findElement(By.xpath("//h4[@class='modal-title']/b"));
        wait.until(ExpectedConditions.visibilityOf(title));

        assertEquals("Заявка на добровольное медицинское страхование", title.getText());

        fillField(By.name("LastName"), "Иванов");
        fillField(By.name("FirstName"), "Иван");
        fillField(By.name("MiddleName"), "Иванович");

        new Select(driver.findElement(By.name("Region"))).selectByVisibleText("Москва");

        fillField(By.name("Comment"), "Autotest");
        fillField(By.name("Email"), "123342");

        driver.findElement(By.xpath("//input[contains(@class,'checkbox')]")).click();
        driver.findElement(By.xpath("//button[@id='button-m']")).click();

        WebElement emailError = driver.findElement(By.xpath("//i[@class='validation-error-mark']/..//span[contains(text(),'адрес')]"));
        String s = emailError.getText();
        wait.until(ExpectedConditions.visibilityOf(emailError));

        assertEquals("Введите адрес электронной почты", emailError.getText());

        assertEquals("Иванов",
                driver.findElement(By.name("LastName")).getAttribute("value"));
        assertEquals("Иван",
                driver.findElement(By.name("FirstName")).getAttribute("value"));
        assertEquals("Иванович",
                driver.findElement(By.name("MiddleName")).getAttribute("value"));


    }

}
