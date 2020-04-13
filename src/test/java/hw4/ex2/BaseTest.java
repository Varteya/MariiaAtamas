package hw4.ex2;

import hw4.ex2.pages.HomePage;
import hw4.ex2.pages.MetalsAndColorsPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
        try(InputStream inputStream = BaseTest.class.getClassLoader().getResourceAsStream("hw4/ex2/data.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    protected WebDriver driver;
    protected Browser browser;
    protected HomePage homePage;
    protected final String firstURL = properties.getProperty("first_url");
    protected final String login = properties.getProperty("login");
    protected final String password = properties.getProperty("password");
    protected final String secondURL = properties.getProperty("second_url");



    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        browser = new Browser(new ChromeDriver());
        homePage = browser.getHomePage();
    }


    protected void openSite(){
        homePage.openSite(firstURL);
    }

    protected boolean checkURL(String expected) {
        return browser.getURL().equals(expected);
    }

    protected void login(){
        homePage.login(login, password);
    }

    protected boolean isLoggined(){
        return homePage.logoutButtonHasAppeared();
    }

    protected void goToMetalsAndColors (){
        homePage.goToMetalsAndColors();
    }



    @AfterMethod
    public void tearDown() {
        browser.tearDown();
    }

}
