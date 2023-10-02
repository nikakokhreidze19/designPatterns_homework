

import POW_WITHOUT_FACTORY.Steps.FirstMoviePageSteps;
import POW_WITHOUT_FACTORY.Steps.SwoopMainPageSteps;
import POW_WITHOUT_FACTORY.Steps.SwoopMoviesPageSteps;
import POW_WITHOUT_FACTORY.Steps.TicketPopUpSteps;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TestSwoopWithoutFactory{
    static SwoopMainPageSteps actionsForMainPage;
    static SwoopMoviesPageSteps actionsForMoviesPage;
    static FirstMoviePageSteps actionsForFirstMovie;
    static TicketPopUpSteps actionsForBuyTicketPopUp;
    static WebDriver driver;



    @BeforeMethod
    public void setUp() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.get("https://www.swoop.ge/");
        driver.manage().window().maximize();
        actionsForMainPage = new SwoopMainPageSteps(driver);
        actionsForMoviesPage = new SwoopMoviesPageSteps(driver);
        actionsForBuyTicketPopUp = new TicketPopUpSteps(driver);
        actionsForFirstMovie = new FirstMoviePageSteps(driver);
    }

    @Test
    public static void buyAndValidateFirstMovie() {
        actionsForMainPage.findAndClickOnMoviesSection();

        actionsForMoviesPage.clickOnBuyFirstMovie();


        actionsForFirstMovie.
                selectCaveaEastPoint().
                selectLastDate()
                .selectLastOption();


        actionsForBuyTicketPopUp.
                chooseFreeSeat().
                validateCinema().
                validateMovie().
                validateDate();





    }

    @AfterTest
    public void close() {
        driver.close();
    }
}