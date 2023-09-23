package POM_HW.Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    public SelenideElement formElement = $(By.xpath("//div[@class='category-cards']//h5[text()='Forms']"));
}
