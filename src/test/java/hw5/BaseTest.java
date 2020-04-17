package hw5;

import hw5.steps.BaseSteps;
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
        try(InputStream inputStream = BaseTest.class.getClassLoader().getResourceAsStream("hw5/testData.properties")) {
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

    protected BaseSteps baseSteps;


    @BeforeMethod
    public void setUp () {
        WebDriverManager.chromedriver().setup();
        WebDriverSingleton.INSTANCE.createdDriver("CHROME");
        browser = new Browser(WebDriverSingleton.INSTANCE.getDriver());
        homePage = browser.getHomePage();
        baseSteps = new BaseSteps(browser);
    }

    @AfterMethod
    public void tearDown () {
        browser.tearDown();
    }
}