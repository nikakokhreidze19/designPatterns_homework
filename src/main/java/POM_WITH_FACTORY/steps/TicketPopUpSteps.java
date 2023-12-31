package POM_WITH_FACTORY.steps;

import POM_WITH_FACTORY.data.DynamicData;
import POM_WITH_FACTORY.pages.TicketPopUp;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.List;

public class TicketPopUpSteps {
    DynamicData data = new DynamicData();
    WebDriver driver;
    TicketPopUp page;
    WebDriverWait wait;
    Actions actions;
    JavascriptExecutor javascriptExecutor;

    public TicketPopUpSteps(WebDriver driver) {
        this.driver = driver;
        page = new TicketPopUp(driver);
        this.wait = new WebDriverWait(driver, 40);
        this.actions = new Actions(driver);
        this.javascriptExecutor = (JavascriptExecutor) driver;
    }

    @Step("choose free seat")
    public TicketPopUpSteps chooseFreeSeat() {
        List<WebElement> freeSeats = page.cinemaTickets.findElements(By.xpath("//div[@class=\"seat free\"]//div[@class=\"seat-new-part\"]"));
        WebElement firstFreeSeat = freeSeats.get(0);
        wait.until(ExpectedConditions.elementToBeClickable(firstFreeSeat));
        javascriptExecutor.executeScript("arguments[0].click();", firstFreeSeat);

        return this;
    }

    @Step("movie validation")
    public TicketPopUpSteps validateMovie() {

        String movieName = page.movieNameInPopUp.getText();
        Assert.assertEquals(movieName, DynamicData.movieName);
        return this;
    }

    @Step("cinema validation")
    public TicketPopUpSteps validateCinema() {
        String cinemaName = page.cinemaNameInPopUp.getText();
        Assert.assertEquals(cinemaName, DynamicData.cinemaName);
        return this;
    }
    //აქ ხელით ვაწვდი ოქტომბერს რადგან მომდევნო თვეში გადადის სეანსი და ერორი ამერიდებიან
    //აღარ ვეწვალე ამის გასწორებას  , ისედაც დიდი დრო დავკარგე გასწორებისთვოს და არც დავალება
    //იყო ამისთვის განკუთვნილი
    @Step("date validation")
    public TicketPopUpSteps validateDate() {
        String date = page.dateInPopUp.getText();
        Assert.assertEquals(date.trim(), page.dateInPopUp.getText()
                .split(" ")[0] + " " + "ოქტომბერი" + " " + DynamicData
                .lastOptionHoursDate.trim());

        return this;
    }


}
