package hw3.tests;

import hw3.po.Browser;
import hw3.po.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BaseTest {

    private static Properties properties;

    {
        properties = new Properties();
        try(InputStream inputStream = BaseTest.class.getClassLoader().getResourceAsStream("hw3/testData.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected final String URL = properties.getProperty("url");
    protected final String login = properties.getProperty("login");
    protected final String password = properties.getProperty("password");
    protected final String username = properties.getProperty("username");

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
