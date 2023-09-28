package POW_WITHOUT_FACTORY.Steps;


import POW_WITHOUT_FACTORY.Pages.FirstMoviePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FirstMoviePageSteps {
    WebDriver driver;
    FirstMoviePage page;
    WebDriverWait wait;
    Actions actions;
    JavascriptExecutor javascriptExecutor;
    public FirstMoviePageSteps(WebDriver driver){
        this.driver=driver;
        page=new FirstMoviePage(driver);
        this.wait=new WebDriverWait(driver, 40);
        this.actions=new Actions(driver);
        this.javascriptExecutor=(JavascriptExecutor)driver;
    }
    @Step
    public FirstMoviePageSteps selectCaveaEastPoint(){
        WebElement caveaEastPoint= page.getCaveaEastPoint();
        javascriptExecutor.executeScript("arguments[0].scrollIntoView",caveaEastPoint);
        wait.until(ExpectedConditions.elementToBeClickable(caveaEastPoint));
        caveaEastPoint.click();

        return this;
    }




    @Step
    public FirstMoviePageSteps selectLastDate(){
        List<WebElement> dateOptions=page.getDateOptionsTabList().findElements(By.className("ui-tabs-anchor"));
        WebElement lastDate=dateOptions.get(dateOptions.size()-1);

        javascriptExecutor.executeScript("arguments[0].scrollIntoView",lastDate);
        wait.until(ExpectedConditions.elementToBeClickable(lastDate));

        lastDate.click();


        return this;

    }

    @Step
    public FirstMoviePageSteps selectLastOption(){
        List<WebElement> options=driver.findElements(By.xpath("//*[contains(@id,'day-choose')]/a"));

        List<WebElement> eastPointOptions=new ArrayList<>();
        for (WebElement element:options){
            if(element.getText().contains("კავეა ისთ ფოინთი")){
                eastPointOptions.add(element);
            }
        }
        WebElement lastOption=eastPointOptions.get(eastPointOptions.size()-1);



        javascriptExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        javascriptExecutor.executeScript("arguments[0].click();",lastOption);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        List<String> handles=new ArrayList<>(driver.getWindowHandles());
        int currentIndex=handles.indexOf(driver.getWindowHandle());
        int nextHandleIndex = (currentIndex + 1) % handles.size();
        driver.switchTo().window(handles.get(nextHandleIndex));
        return this;
    }

}