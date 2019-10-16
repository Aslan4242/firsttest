package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.ArrayList;

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

    @When("^выполнено нажатие на кнопку - Отправить заявку")
    public void stepProcessBtn(){
        travelerInsuranceSteps.stepProcessPolicyBtn();
    }

    @When("^выполнен переход на другую страницу")
    public void changePage(){
        ArrayList<String> tabs2 = new ArrayList<>(BaseSteps.getDriver().getWindowHandles());
        BaseSteps.getDriver().switchTo().window(tabs2.get(1));
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
}
