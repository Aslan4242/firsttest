package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static junit.framework.TestCase.assertEquals;

public class ScenarioSteps {

    MainSteps mainSteps = new MainSteps();

    TravelerInsuranceSteps travelerInsuranceSteps = new TravelerInsuranceSteps();

    InputTravelerDataSteps inputTravelerDataSteps = new InputTravelerDataSteps();

    @When("^выбран пункт меню \"(.*)\"$")
    public void stepSelectMainMenu(String menuItem){
        mainSteps.stepSelectMainMenu(menuItem);
    }

    @When("^выбран вид страхования - \"(.*)\"$")
    public void stepSelectTypeInsurance(String menuItem){
        mainSteps.stepSelectSubMenu(menuItem);
    }

    @Then("^выводится заголовок 'Страхование путешественников'")
    public void travelInsuranceTitleStep(){
        String titleText = travelerInsuranceSteps.stepTitleTravelInsurance();
        assertEquals("Страхование путешественников",titleText);
    }

    @When("^выполнено нажатие на кнопку - Отправить заявку")
    public void stepProcessBtn(){
        travelerInsuranceSteps.stepProcessPolicyBtn();
    }

    @When("^выполнен переход на другую страницу")
    public void changePage(){
        BaseSteps.ChangePage();
    }

    @When("^выбрано минимальное значение и нажата кнопка оформить")
    public void chooseOptions(){
        inputTravelerDataSteps.stepMinSumBtn();
        inputTravelerDataSteps.stepProcessingBtn();

    }
    @Then("^заполняются поля:")
    public void stepFillField(DataTable fields){

        fields.asMap(String.class, String.class).forEach(
                (key, value) -> {
                    inputTravelerDataSteps.stepFillField(key, value);
                });
    }

    @When("^нажимается кнопка 'Продолжить'")
    public void continueBtn(){
        inputTravelerDataSteps.stepContinueBtn();
    }


    @Then("^выводится сообщение об ошибке 'Заполнены не все обязательные поля'")
    public void error(){
        String errorText = inputTravelerDataSteps.stepError();
        assertEquals("Заполнены не все обязательные поля",errorText);
    }

}
