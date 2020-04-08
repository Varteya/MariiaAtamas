package hw3.po;

import org.openqa.selenium.WebDriver;

public class Browser {
    private WebDriver driver;
    private HomePage homePage;

    public Browser (WebDriver driver) {
        this.driver = driver;
        driver.manage().window().maximize();
    }

    public HomePage getHomePage() {
        if (homePage == null){
            homePage = new HomePage(driver);
        }
        return homePage;
    }

    public void tearDown (){
        driver.quit();
    }
}
