import org.junit.Ignore;
import org.junit.Test;
import pages.InputTravelerDataPage;
import pages.MainPage;
import pages.TravelerInsurancePage;
import steps.BaseSteps;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MyRefactoringTest extends BaseSteps {
    @Test
    @Ignore
    public void newInsuranceTest() {
        driver.get(baseUrl + "/");
        MainPage mainPage = new MainPage(driver);
        mainPage.selectMenuItem("Страхование");
        mainPage.selectInsuranceItem(("путешественников"));

        TravelerInsurancePage travelerInsurancePage = new TravelerInsurancePage(driver);
        travelerInsurancePage.waitButtonClickable();
        String actualTitle = travelerInsurancePage.title.getText();
        String expectedTitle = "Страхование путешественников";
        assertTrue(String.format("Заголовок равен [%s]. Ожидалось - [%s]",
                actualTitle, expectedTitle), actualTitle.contains(expectedTitle));

        ArrayList tabs2 = new ArrayList (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1).toString());

        InputTravelerDataPage inputTravelerDataPage = new InputTravelerDataPage(driver);

        inputTravelerDataPage.minSumButton.click();
        inputTravelerDataPage.processingButton.click();

        inputTravelerDataPage.fillField(inputTravelerDataPage.surnameField, "Ivanov");
        inputTravelerDataPage.fillField(inputTravelerDataPage.nameField, "Ivan");

        inputTravelerDataPage.fillField(inputTravelerDataPage.birthDayField, "10111991");
        inputTravelerDataPage.fillField(inputTravelerDataPage.surnameRusField, "Иванов");
        inputTravelerDataPage.fillField(inputTravelerDataPage.nameRusField, "Иван");
        inputTravelerDataPage.fillField(inputTravelerDataPage.middlenameRusField, "Иванович");
        inputTravelerDataPage.fillField(inputTravelerDataPage.birthField, "10111991");

        inputTravelerDataPage.fillField(inputTravelerDataPage.passportSeriesField, "1111");
        inputTravelerDataPage.fillField(inputTravelerDataPage.passportNumberField, "222222");
        inputTravelerDataPage.fillField(inputTravelerDataPage.issueDateField, "10112011");
        inputTravelerDataPage.fillField(inputTravelerDataPage.issuePlaceField, "УВД г. Москва");

        inputTravelerDataPage.continueBtn.click();

        String errorText = inputTravelerDataPage.error.getText();
        assertEquals("Заполнены не все обязательные поля",errorText);


    }
}
