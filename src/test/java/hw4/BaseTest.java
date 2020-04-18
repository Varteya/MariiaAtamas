package hw4;

import hw4.ex2.Browser;
import hw4.ex2.pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected Browser browser;
    protected HomePage homePage;

    public void setUp() {
        WebDriverManager.chromedriver().setup();
        browser = new Browser(new ChromeDriver());
        homePage = browser.getHomePage();
    }

    protected void openSite(String url){
        homePage.openSite(url);
    }

    protected boolean checkURL(String expected) {
        return browser.getURL().equals(expected);
    }

    protected void login(String login, String password){
        homePage.login(login, password);
    }

    protected boolean isLoggined(){
        return homePage.logoutButtonHasAppeared();
    }


    @AfterMethod
    public void tearDown() {
        browser.tearDown();
    }

}
