package POW_WITHOUT_FACTORY.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



import java.util.List;

public class FirstMoviePage {
    WebDriver driver;

    public FirstMoviePage(WebDriver driver) {
        this.driver = driver;

    }

    By caveaEastPoint = By.xpath("//a[contains(@id,'ui-id-') and text() ='კავეა ისთ ფოინთი']");

    public WebElement getCaveaEastPoint() {
        return driver.findElement(caveaEastPoint);
    }

    By returnedOptions = By.xpath("//*[contains(@id,'day-choose-')]/a");

    public List<WebElement> getReturnedOptions() {
        return driver.findElements(returnedOptions);
    }

    By dateOptionsTabList = By.xpath("//*[@id=\"384933\"]//*[@role=\"tablist\"]");

    public WebElement getDateOptionsTabList() {
        return driver.findElement(dateOptionsTabList);
    }
}
