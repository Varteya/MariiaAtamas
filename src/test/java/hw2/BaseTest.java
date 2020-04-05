package hw2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;
    protected final String URL = "https://jdi-testing.github.io/jdi-light/index.html";
    protected final String login = "Roman";
    protected final String password = "Jdi1234";
    protected final String username = "ROMAN IOVLEV";


    @BeforeMethod
    public void setUp () {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    protected String openSite () {
        driver.get(URL);
        return driver.getCurrentUrl();
    }

    protected boolean homePageIsOpened () {
        return driver.getTitle().equals("Home Page");
    }

    protected boolean login() {
        driver.findElement(By.id("user-icon")).click();
        driver.findElement(By.id("name")).sendKeys(login);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
        return driver.findElement(By.cssSelector(".logout")).isDisplayed();
    }

    protected boolean checkUsername () {
        return driver.findElement(By.id("user-name")).getText().equals(username);
    }

    @AfterMethod
    public void tearDown () {
        driver.quit();
    }
}
