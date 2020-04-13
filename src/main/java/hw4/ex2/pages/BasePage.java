package hw4.ex2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    WebDriver driver;
    protected String URL;

    @FindBy(id = "user-icon")
    private WebElement userIcon;

    @FindBy(id = "name")
    private WebElement nameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(css = ".logout")
    private WebElement logoutButton;

    @FindBy(linkText = "Metals & Colors")
    private WebElement metalsAndColorsButton;


    public BasePage (WebDriver driver){
        this.driver = driver;
        this.URL = driver.getCurrentUrl();
        PageFactory.initElements(driver, this);
    }

    public void login (String name, String password) {
        userIcon.click();
        nameField.sendKeys(name);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public boolean logoutButtonHasAppeared (){
        return logoutButton.isDisplayed();
    }

    public void goToMetalsAndColors(){
        metalsAndColorsButton.click();
    }
}
