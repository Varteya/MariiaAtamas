package hw5.steps;

import hw5.BaseTest;
import hw5.Browser;
import hw5.HomePage;
import io.qameta.allure.Step;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class BaseSteps {

    protected Browser browser;
    protected HomePage homePage;

    public BaseSteps (Browser browser){
        this.browser = browser;
        this.homePage = browser.getHomePage();
    }

    @Step("Open site by URL '{0}'")
    public void openSite (String url){
        homePage.openSite(url);
    }

    @Step("Check actual URL")
    public void checkURL (String expected){
        assertTrue(homePage.checkURL(expected));
    }

    @Step("Check header")
    public void checkHeader(String expected){
        assertTrue(homePage.checkHeader(expected));
    }

    @Step("Login as '{0}'")
    public void login (String username, String password){
        homePage.login(username, password);
    }

    @Step("Check username")
    public void checkUsername (String expected){
        assertTrue(homePage.checkUsername(expected));
    }



}
