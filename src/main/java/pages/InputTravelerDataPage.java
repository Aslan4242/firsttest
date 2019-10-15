package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InputTravelerDataPage extends BasePage{

    @FindBy(xpath = "//div[contains(text(),'35')]")
    public WebElement minSumButton;

    @FindBy(xpath = "//span[contains(@class,'b-button-block-center')]/span")
    public WebElement processingButton;


    public InputTravelerDataPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//div[contains(@ng-class,'_surname')]/input")
    public WebElement surnameField;
    @FindBy(xpath = "//div[contains(@ng-class,'_name')]/input")
    public WebElement nameField;
    @FindBy(xpath = "//div[contains(@ng-class,'_birth')]/input")
    public WebElement birthDayField;
    @FindBy(xpath = "//div[contains(@ng-class,'.surname')]/input")
    public WebElement surnameRusField;
    @FindBy(xpath = "//div[contains(@ng-class,'.name')]/input")
    public WebElement nameRusField;
    @FindBy(xpath = "//div[contains(@ng-class,'.middlename')]/input")
    public WebElement middlenameRusField;
    @FindBy(xpath = "//div[contains(@ng-class,'.birthDate')]/input")
    public WebElement birthField;
    @FindBy(xpath = "//div[contains(@ng-class,'.passport_series')]/input")
    public WebElement passportSeriesField;
    @FindBy(xpath = "//div[contains(@ng-class,'.passport_number')]/input")
    public WebElement passportNumberField;
    @FindBy(xpath = "//div[contains(@ng-class,'.issueDate')]/input")
    public WebElement issueDateField;
    @FindBy(xpath = "//div[contains(@ng-class,'.issuePlace')]/textarea")
    public WebElement issuePlaceField;

    @FindBy(xpath = "//div[contains(@class,'b-button-block-center')]/span[@class='b-continue-btn']")
    public WebElement continueBtn;

    @FindBy(xpath = "//div[contains(@class,'b-form-center-pos b-form-error-message')]/div[contains(@ng-show,'invalid')]")
    public WebElement error;


    public void fillField(String fieldName, String value){
        switch (fieldName){
            case  "Фамилия":
                fillField(surnameField, value);
                break;
            case  "Имя":
                fillField(nameField, value);
                break;
            case  "День рождения":
                fillField(birthDayField, value);
                break;
            case  "Фамилия рус":
                fillField(surnameRusField, value);
                break;
            case  "Имя рус":
                fillField(nameRusField, value);
                break;
            case  "Отчество рус":
                fillField(middlenameRusField, value);
                break;
            case  "Дата рождения":
                fillField(birthField, value);
                break;
            case  "Серия паспорта":
                fillField(passportSeriesField, value);
                break;
            case  "Номер паспорта":
                fillField(passportNumberField, value);
                break;
            case  "Дата выдачи":
                fillField(issueDateField, value);
                break;
            case  "Место выдачи":
                fillField(passportNumberField, value);
                break;
            case  "Продолжить":
                fillField(continueBtn, value);
                break;
            case  "Ошибка":
                fillField(error, value);
                break;
            default:  throw new AssertionError("Поле '"+fieldName+"' не объявлено на странице");
        }
    }


}
