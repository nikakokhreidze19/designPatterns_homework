package POM_WITH_FACTORY.steps;

import POM_WITH_FACTORY.pages.SwoopMainPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SwoopMainPageSteps {
    WebDriver driver;
    SwoopMainPage page;
    public SwoopMainPageSteps(WebDriver driver){
        this.driver=driver;
        page=new SwoopMainPage(driver);
    }

    @Step
    public SwoopMainPageSteps findAndClickOnMoviesSection(){

        List<WebElement> menuItems=page.menuItemsContainer.findElements(By.tagName("li"));
        for (WebElement element:menuItems){
            if(element.getText().contains("კინო")){
                element.click();
                break;
            }
        }

        return this;
    }

}
