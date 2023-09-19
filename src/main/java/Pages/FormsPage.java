package Pages;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class FormsPage {
    public SelenideElement practiceFormElement =
            $(Selectors.byXpath("//li[@id='item-0']//span[text()='Practice Form']"));

}

