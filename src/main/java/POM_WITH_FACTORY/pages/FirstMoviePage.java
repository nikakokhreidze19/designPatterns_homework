package POM_WITH_FACTORY.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FirstMoviePage {
    WebDriver driver;
    public FirstMoviePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[contains(@id,'ui-id-') and text() ='კავეა ისთ ფოინთი']")
    public WebElement caveaEastPoint;
    @FindBy(xpath = "//*[contains(@id,'day-choose-')]/a")
    public List<WebElement> returnedOptions;
    @FindBy(xpath = "//*[@id=\"384933\"]//*[@role=\"tablist\"]")
    public static WebElement dateOptionsTabList;

}
