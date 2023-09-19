package Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import Data.InfoData;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

public class PracticePage {
        InfoData infoData = new InfoData();

        public SelenideElement firstNameInput = $(byId("firstName"));
        public SelenideElement lastNameInput = $(byId("lastName"));
        public SelenideElement gender = $(By.cssSelector("input[value='"+ infoData.gender + "']"));

        public SelenideElement mobileInput = $(byId("userNumber"));

        public SelenideElement submitButton = $(byId("submit"));

}


