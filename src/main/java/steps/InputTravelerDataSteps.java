package steps;

import pages.InputTravelerDataPage;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.HashMap;

public class InputTravelerDataSteps {
    @Step("выбрана минимальная сумма {0}")
    public  void stepMinSumBtn(){
        new InputTravelerDataPage().minSumButton.click();
    }

    @Step("нажата кнопка 'Оформить' {0}")
    public  void stepProcessingBtn(){
        new InputTravelerDataPage().processingButton.click();
    }

    @Step("поле {0} заполнять значением {1}")
    public void stepFillField(String field, String value){
        new InputTravelerDataPage().fillField(field, value);
    }


    @Step("заполняются поля:")
    public void stepFillFields(HashMap<String,String> fields){
        fields.forEach(this::stepFillField);
    }

    @Step("нажата кнопка 'Продолжить' {0}")
    public  void stepContinueBtn(){
        new InputTravelerDataPage().continueBtn.click();
    }
    @Step("вывелась надпись об ошибке {0}")
    public  String stepError(){
       String error =  new InputTravelerDataPage().error.getText();
       return  error;
    }
}
