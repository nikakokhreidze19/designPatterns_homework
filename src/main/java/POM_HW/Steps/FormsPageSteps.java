package POM_HW.Steps;

import POM_HW.Pages.FormsPage;
import io.qameta.allure.Step;

public class FormsPageSteps {
    FormsPage formsPage = new FormsPage();

    @Step
    public FormsPageSteps clickPracticeElement(){
        formsPage.practiceFormElement.click();
        return this;
    }
}
