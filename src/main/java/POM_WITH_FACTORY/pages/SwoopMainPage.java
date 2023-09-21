package POM_WITH_FACTORY.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SwoopMainPage {
    private WebDriver driver;

    public SwoopMainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"body\"]//*[@class=\"Menus\"]")
    public WebElement menuItemsContainer;

}
