package Steps;
import Data.InfoData;
import Pages.SubmitPopUpPage;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;


public class SubmitPopUpSteps {
    SubmitPopUpPage submitPopUpPage = new SubmitPopUpPage();
    InfoData infoData = new InfoData();

    @Step
    public SubmitPopUpSteps validateGreetingTextIsVisible(){
        submitPopUpPage.thanksText.shouldBe(visible).shouldHave(text(infoData.greetingText));
        return this;
    }


    @Step
    public SubmitPopUpSteps validateFirstName() {
        validateHelper("Student Name", infoData.firstName + " " + infoData.lastName);
        return this;
    }

    @Step
    public SubmitPopUpSteps validateGender() {
        validateHelper("Gender", infoData.gender);
        return this;
    }

    @Step
    public SubmitPopUpSteps validateNumber() {
        validateHelper("Mobile", infoData.mobileNumber);
        return this;
    }
    //რადგან ყველგან ერთი და იგივე ფუნქციონალს ვიყენებთ ,გავაკეთე დამხმარე ფუნქცია რო დუბლირება არ მომხდარიყო
    //ისიც ვიფიქრე ცალკე დამხმარე კლასი ხოარ შევუქმნა და დავაექსთენდოთქო მაგრამ ვერ გავრისკე არასწორი მიდგომა არ ყოფილიყო
    private void validateHelper(String elementTextToFind, String expectedText) {
        for (SelenideElement element : submitPopUpPage.tableElements) {
            if (element.getText().contains(elementTextToFind)) {
                element.shouldHave(text(expectedText));
                break;
            }
        }
    }

}
