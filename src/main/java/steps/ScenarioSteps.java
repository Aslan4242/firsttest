package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.When;

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

    @When("заполняются поля:")
    public void stepFillFields(DataTable fields){
        fields.asMap(String.class, String.class).forEach(
                (key, value) -> inputTravelerDataSteps.stepFillField(key, value));
    }
}
