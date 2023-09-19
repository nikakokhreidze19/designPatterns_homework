package Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SubmitPopUpPage {
    public SelenideElement thanksText =
            $(byId("example-modal-sizes-title-lg"));

    public ElementsCollection tableElements = $$("table tbody tr");


}
