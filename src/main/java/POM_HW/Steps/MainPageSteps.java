package POM_HW.Steps;

import POM_HW.Pages.MainPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class MainPageSteps {
    MainPage mainPage = new MainPage();
    @Step
    public MainPageSteps clickFormsElement(){
        executeJavaScript("arguments[0].click()",mainPage.formElement);
        return this;
    }
}
