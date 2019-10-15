package steps;

import org.openqa.selenium.WebElement;
import pages.InputTravelerDataPage;
import pages.MainPage;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.HashMap;

public class InputTravelerDataSteps extends BaseSteps{
    @Step("выбрана минимальная сумма {0}")
    public  void stepMinSumBtn(){
        new InputTravelerDataPage(driver).minSumButton.click();
    }

    @Step("нажата кнопка 'Оформить' {0}")
    public  void stepContinueBtn(){
        new InputTravelerDataPage(driver).processingButton.click();
    }

    @Step("поле {0} заполнять значением {1}")
    public void stepFillField(String field, String value){
        new InputTravelerDataPage(driver).fillField(field, value);
    }


    @Step("заполняются поля:")
    public void stepFillFields(HashMap<String,String> fields){
        fields.forEach(this::stepFillField);
    }

}
