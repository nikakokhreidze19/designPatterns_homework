package POW_WITHOUT_FACTORY.Steps;

import POW_WITHOUT_FACTORY.Pages.SwoopMainPage;
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


    public SwoopMainPageSteps findAndClickOnMoviesSection(){

        List<WebElement> menuItems=page.getMenuItemContainer().findElements(By.tagName("li"));
        for (WebElement element:menuItems){
            if(element.getText().contains("კინო")){
                element.click();
                break;
            }
        }

        return this;
    }

}