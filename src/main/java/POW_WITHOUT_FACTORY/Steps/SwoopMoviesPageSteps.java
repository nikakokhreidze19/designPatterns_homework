package POW_WITHOUT_FACTORY.Steps;



import POW_WITHOUT_FACTORY.Pages.SwoopMoviesPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.List;

public class SwoopMoviesPageSteps {
    WebDriver driver;
    SwoopMoviesPage page;
    WebDriverWait wait;
    Actions actions;
    JavascriptExecutor javascriptExecutor;
    public SwoopMoviesPageSteps(WebDriver driver){
        this.driver=driver;
        page=new SwoopMoviesPage(driver);
        this.wait=new WebDriverWait(driver, 40);
        this.actions=new Actions(driver);
        this.javascriptExecutor=(JavascriptExecutor)driver;
    }
    public WebElement firstMovie() {
        List<WebElement> movieContainers = driver.findElements(By.xpath("//div[@class='movies-deal']"));
        for (WebElement movieContainer : movieContainers) {
            List<WebElement> logos = movieContainer.findElements(By.xpath(".//div[@class='movie-logos']//img"));
            for (WebElement logo : logos) {
                String logoSrc = logo.getAttribute("src");
                if ("https://www.swoop.ge/Images/NewDesigneImg/CinemaIcons/cavea-istFointi.svg".equals(logoSrc)) {
                    return movieContainer;
                }
            }
        }
        return null;
    }


    public SwoopMoviesPageSteps clickOnBuyFirstMovie(){
        page.firstMovie=firstMovie();



        wait.until(ExpectedConditions.elementToBeClickable(page.firstMovie));
        actions.moveToElement(page.firstMovie).perform();
        WebElement buyButton=page.firstMovie.findElement(By.className("info-cinema-ticket"));
        wait.until(ExpectedConditions.visibilityOf(buyButton));
        actions.moveToElement(buyButton).perform();
        wait.until(ExpectedConditions.elementToBeClickable(buyButton));
        buyButton.click();

        return this;
    }
}
