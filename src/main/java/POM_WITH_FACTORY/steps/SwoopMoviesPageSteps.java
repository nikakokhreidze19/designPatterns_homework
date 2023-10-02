package POM_WITH_FACTORY.steps;

import POM_WITH_FACTORY.data.DynamicData;
import POM_WITH_FACTORY.pages.SwoopMoviesPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
    public WebElement firstMovieElement() {
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
    @Step("click buy button")
    public SwoopMoviesPageSteps clickOnBuyFirstMovie(){

        page.firstMovie=firstMovieElement();


        DynamicData.movieName=page.firstMovie.getText();
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