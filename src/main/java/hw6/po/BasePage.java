package hw6.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class BasePage {

    protected WebDriver driver;

    protected String URL;
    protected String header;


    public BasePage (WebDriver driver){
        this.driver = driver;
        this.URL = driver.getCurrentUrl();
        PageFactory.initElements(driver, this);
    }

    public boolean checkURL(String expectedURL) {
        return URL.equals(expectedURL);
    }
}
