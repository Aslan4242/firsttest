package steps;

import pages.TravelerInsurancePage;
import ru.yandex.qatools.allure.annotations.Step;

public class TravelerInsuranceSteps extends BaseSteps {

    @Step("выполнено нажатие на кнопку - Оформить полис")
    public void stepProcessPolicyBtn(){
        new TravelerInsurancePage(driver).button.click();
    }
}
