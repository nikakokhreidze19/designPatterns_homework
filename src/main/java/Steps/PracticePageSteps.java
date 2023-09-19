package Steps;

import Data.InfoData;
import Pages.PracticePage;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class PracticePageSteps {
    PracticePage practiceFormPage = new PracticePage();
    InfoData infoData = new InfoData();


    @Step
    public PracticePageSteps setFirstNameText(){
        practiceFormPage.firstNameInput.setValue(infoData.firstName);
        return this;
    }

    @Step
    public PracticePageSteps setLastNameText(){
        practiceFormPage.lastNameInput.setValue(infoData.lastName);
        return this;
    }

    @Step
    public PracticePageSteps GenderClick(){
        executeJavaScript("arguments[0].click()",practiceFormPage.gender);
        return this;

    }
    @Step
    public PracticePageSteps setMobileNum(){
        practiceFormPage.mobileInput.setValue(infoData.mobileNumber);
        return this;
    }

    @Step
    public PracticePageSteps clickSubmitButton(){
        executeJavaScript("arguments[0].click()",practiceFormPage.submitButton);
        return this;
    }

}
