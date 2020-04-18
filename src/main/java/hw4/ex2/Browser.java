package hw4.ex2;

import hw4.ex2.pages.HomePage;
import hw4.ex2.pages.MetalsAndColorsPage;
import org.openqa.selenium.WebDriver;

public class Browser {
    private WebDriver driver;
    private HomePage homePage;
    private MetalsAndColorsPage metalsAndColorsPage;

    public Browser (WebDriver driver) {
        this.driver = driver;
        driver.manage().window().maximize();
    }

    public HomePage getHomePage(){
        if (homePage == null){
            homePage = new HomePage(driver);
        }
        return homePage;
    }

    public MetalsAndColorsPage getMetalsAndColorsPage(){
        if (metalsAndColorsPage == null){
            metalsAndColorsPage = new MetalsAndColorsPage(driver);
        }
        return metalsAndColorsPage;
    }

    public String getURL(){
        return driver.getCurrentUrl();
    }

    public WebDriver getDriver(){
        return driver;
    }

    public void tearDown (){
        driver.quit();
    }
}
