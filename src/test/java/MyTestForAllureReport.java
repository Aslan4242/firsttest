import org.junit.Ignore;
import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Title;
import steps.BaseSteps;
import steps.InputTravelerDataSteps;
import steps.MainSteps;
import steps.TravelerInsuranceSteps;

import java.util.ArrayList;
import java.util.HashMap;

public class MyTestForAllureReport extends BaseSteps {

    @Title("Страхование")
    @Test
    public void testInsurance(){
        driver.get(baseUrl + "/");
        MainSteps mainSteps = new MainSteps();
        TravelerInsuranceSteps travelerInsuranceSteps = new TravelerInsuranceSteps();
        InputTravelerDataSteps inputTravelerDataSteps = new InputTravelerDataSteps();

        HashMap<String, String> testData = new HashMap<>();
        testData.put("Фамилия", "Ivanov");
        testData.put("Имя", "Ivan");
        testData.put("Имя", "Ivan");
        testData.put("Имя", "Ivan");

        mainSteps.stepSelectMainMenu("Страхование");
        mainSteps.stepSelectSubMenu("путешественников");

        travelerInsuranceSteps.stepProcessPolicyBtn();

        ArrayList tabs2 = new ArrayList (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1).toString());

        inputTravelerDataSteps.stepMinSumBtn();
        inputTravelerDataSteps.stepContinueBtn();
        inputTravelerDataSteps.stepFillFields(testData);
    }
}
