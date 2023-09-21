package POW_WITHOUT_FACTORY.Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class SwoopMoviesPage {
    private WebDriver driver;
    public SwoopMoviesPage(WebDriver driver) {
        this.driver=driver;

    }

    public WebElement firstMovie;
}
