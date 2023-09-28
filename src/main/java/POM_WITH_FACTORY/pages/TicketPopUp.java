package POM_WITH_FACTORY.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TicketPopUp {
    WebDriver driver;
    public TicketPopUp(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//div[@class=\"container mobile-class-for-height\"]")
    public WebElement cinemaTickets;
    @FindBy(xpath = "//div[@class=\"content-header\"]//p[@class=\"movie-title\"]")
    public WebElement movieNameInPopUp;
    @FindBy(xpath = "//div[@class=\"content-header\"]//p[@class=\"movie-cinema\" and contains(text(),'კავეა')]")
    public WebElement cinemaNameInPopUp;
    @FindBy(xpath = "//div[@class=\"content-header\"]//p[@class=\"movie-cinema\" and contains(text(),'ოქტომბერი')]")
    public WebElement dateInPopUp;
}