package hw4.ex2.pages.details;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BaseDetail {

    protected BaseDetail (WebDriver driver){
        PageFactory.initElements(driver, this);
    }
}
