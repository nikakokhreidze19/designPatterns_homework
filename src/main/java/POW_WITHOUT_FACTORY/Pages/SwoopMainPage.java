package POW_WITHOUT_FACTORY.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class SwoopMainPage {
    private WebDriver driver;

    public SwoopMainPage(WebDriver driver) {
        this.driver = driver;
    }

    By menuItemContainer = By.xpath("//*[@id=\"body\"]//*[@class=\"Menus\"]");

    public WebElement getMenuItemContainer() {
        return driver.findElement(menuItemContainer);
    }

}
