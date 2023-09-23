package POM_WITH_FACTORY.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SwoopMoviesPage {
    private WebDriver driver;
    public SwoopMoviesPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public WebElement firstMovie;



}
