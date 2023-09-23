package POW_WITHOUT_FACTORY.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class TicketPopUp {
    WebDriver driver;

    public TicketPopUp(WebDriver driver) {
        this.driver = driver;
    }

    By cinemaTickets = By.xpath("//div[@class=\"container mobile-class-for-height\"]");

    public WebElement getCinemaTickets() {
        return driver.findElement(cinemaTickets);
    }

    By movieNameInPopUp = By.xpath("//div[@class=\"content-header\"]//p[@class=\"movie-title\"]");

    public WebElement getMovieNameInPopUp() {
        return driver.findElement(movieNameInPopUp);
    }

    By cinemaNameInPopUp = By.xpath("//div[@class=\"content-header\"]//p[@class=\"movie-cinema\" and contains(text(),'კავეა')]");

    public WebElement getCinemaNameInPopUp() {
        return driver.findElement(cinemaNameInPopUp);
    }

    By dateInPopUp = By.xpath("//div[@class=\"content-header\"]//p[@class=\"movie-cinema\" and contains(text(),'სექტემბერი')]");

    public WebElement getDateInPopUp() {
        return driver.findElement(dateInPopUp);
    }
}
