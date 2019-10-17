package steps;

import pages.TravelerInsurancePage;
import ru.yandex.qatools.allure.annotations.Step;

public class TravelerInsuranceSteps {

    @Step("выполнено нажатие на кнопку - Оформить полис")
    public void stepProcessPolicyBtn(){
        new TravelerInsurancePage().button.click();
    }
    @Step("^получен текст заголовка")
    public String stepTitleTravelInsurance(){
       return  new TravelerInsurancePage().title.getText();
    }
}
