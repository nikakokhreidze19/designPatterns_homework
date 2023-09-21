package POW_WITHOUT_FACTORY.Steps;


import POW_WITHOUT_FACTORY.Data.Data;
import POW_WITHOUT_FACTORY.Pages.TicketPopUp;
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
    Data data=new Data();
    WebDriver driver;
    TicketPopUp page;
    WebDriverWait wait;
    Actions actions;
    JavascriptExecutor javascriptExecutor;

    public TicketPopUpSteps(WebDriver driver){
        this.driver=driver;
        page=new TicketPopUp(driver);
        this.wait=new WebDriverWait(driver, 40);
        this.actions=new Actions(driver);
        this.javascriptExecutor=(JavascriptExecutor)driver;

    }

    public TicketPopUpSteps chooseFreeSeat(){
        List<WebElement> freeSeats=page.getCinemaTickets().findElements(By.xpath("//div[@class=\"seat free\"]//div[@class=\"seat-new-part\"]"));
        WebElement firstFreeSeat=freeSeats.get(0);
        wait.until(ExpectedConditions.elementToBeClickable(firstFreeSeat));
        javascriptExecutor.executeScript("arguments[0].click();",firstFreeSeat);

        return this;
    }


    public TicketPopUpSteps validateMovie(){

        String movieName=page.getMovieNameInPopUp().getText();
        System.out.println("This is from popup: "+movieName);
        System.out.println("This is dynamic: "+data.movieName);
        Assert.assertEquals(movieName,data.movieName);



        return this;
    }
    public TicketPopUpSteps validateCinema(){

        System.out.println("This is dynamic: "+data.cinemaName);
        String cinemaName=page.getCinemaNameInPopUp().getText();
        System.out.println("This is from popup: "+cinemaName);
        Assert.assertEquals(cinemaName,data.cinemaName);

        return this;
    }

    public TicketPopUpSteps validateDate(){

        String date=page.getDateInPopUp().getText();
        System.out.println("This is from popup: "+date);
        Assert.assertEquals(date.trim(),page.getDateInPopUp().getText()
                .split(" ")[0]+" "+data.map.get(data.currentMonth)+" "+data
                .lastOptionHoursDate.trim());



        return this;
    }


}