import POM_HW.Steps.FormsPageSteps;
import POM_HW.Steps.MainPageSteps;
import POM_HW.Steps.PracticePageSteps;
import POM_HW.Steps.SubmitPopUpSteps;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import static com.codeborne.selenide.Selenide.*;

public class TestClass {

    MainPageSteps homePageSteps = new MainPageSteps();
    FormsPageSteps formsPageSteps = new FormsPageSteps();
    PracticePageSteps practiceFormPageSteps = new PracticePageSteps();
    SubmitPopUpSteps submitPopUpSteps = new SubmitPopUpSteps();


    @BeforeTest
    public void setupTest(){
        Configuration.holdBrowserOpen=false;
        open("https://demoqa.com/");

    }
    @org.testng.annotations.Test
    public void Test(){
        homePageSteps.clickFormsElement();
        formsPageSteps.clickPracticeElement();

        practiceFormPageSteps.
                setFirstNameText().
                setLastNameText().
                setMobileNum().
                GenderClick().
                clickSubmitButton();


        submitPopUpSteps.
                validateGreetingTextIsVisible().
                validateFirstName().
                validateGender().
                validateNumber();
    }

    @AfterTest
    public void endTest(){
        closeWebDriver();
    }
}
