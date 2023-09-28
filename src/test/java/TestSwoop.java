
import POM_WITH_FACTORY.steps.TicketPopUpSteps;
import POM_WITH_FACTORY.steps.FirstMoviePageSteps;
import POM_WITH_FACTORY.steps.SwoopMainPageSteps;
import POM_WITH_FACTORY.steps.SwoopMoviesPageSteps;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(Config.class)
@Epic("we test swoop.ge site")
@Feature("buy ticket and validation data")
public class TestSwoop{
    static SwoopMainPageSteps actionsForMainPage;
    static SwoopMoviesPageSteps actionsForMoviesPage;
    static FirstMoviePageSteps actionsForFirstMovie;
    static TicketPopUpSteps actionsForBuyTicketPopUp;
    static WebDriver driver;



    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.swoop.ge/");
        driver.manage().window().maximize();
        actionsForMainPage = new SwoopMainPageSteps(driver);
        actionsForMoviesPage = new SwoopMoviesPageSteps(driver);
        actionsForBuyTicketPopUp = new TicketPopUpSteps(driver);
        actionsForFirstMovie = new FirstMoviePageSteps(driver);
    }
    @Severity(SeverityLevel.CRITICAL)
    @Description("open test site , click buy  button , choose last session and validate data")
    @Story("Buying first movie in movies section and validate")
    @Test(description = "choose first movie ,buy ticket choose free seat and validate info")
    public static void buyAndValidateFirstMovie() {
        actionsForMainPage.findAndClickOnMoviesSection("კინო");
        actionsForMoviesPage.clickOnBuyFirstMovie();

        actionsForFirstMovie.
                selectCaveaEastPoint().
                selectLastDate()
                .selectLastOption("კავეა ისთ ფოინთი");

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
