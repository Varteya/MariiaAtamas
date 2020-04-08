package hw3.tests;

import hw3.po.Browser;
import hw3.po.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected final String URL = "https://jdi-testing.github.io/jdi-light/index.html";
    protected final String login = "Roman";
    protected final String password = "Jdi1234";
    protected final String username = "ROMAN IOVLEV";

    protected Browser browser;
    protected HomePage homePage;


    @BeforeMethod
    public void setUp () {
        WebDriverManager.chromedriver().setup();
        browser = new Browser(new ChromeDriver());
        homePage = browser.getHomePage();
    }

    protected boolean openAndCheckSite () {
        homePage.openSite(URL);
        return homePage.checkURL(URL);
    }

    protected boolean homePageIsOpened () {
        return homePage.checkHeader("Home Page");
    }

    protected boolean login() {
        homePage.login(login, password);
        return homePage.logoutButtonHasAppeared();
    }

    protected boolean checkUsername () {
        return homePage.checkUsername(username);
    }

    @AfterMethod
    public void tearDown () {
        browser.tearDown();
    }
}
