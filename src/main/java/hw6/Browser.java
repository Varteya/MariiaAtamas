package hw6;

import hw6.po.DifferentElements;
import hw6.po.HomePage;
import hw6.po.UserTable;
import org.openqa.selenium.WebDriver;

public class Browser {

    private WebDriver driver;
    private HomePage homePage;
    private DifferentElements differentElements;
    private UserTable userTable;

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

    public DifferentElements getDifferentElements() {
        if (differentElements == null){
            differentElements = new DifferentElements(driver);
        }
        return differentElements;
    }

    public UserTable getUserTable(){
        if (userTable == null){
            userTable = new UserTable(driver);
        }
        return userTable;
    }


    public void tearDown (){
        driver.quit();
    }
}
