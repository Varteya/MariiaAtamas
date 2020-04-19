package hw6.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

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

    @FindBy(id = "user-name")
    private WebElement username;

    @FindBy(linkText = "Service")
    private WebElement serviceButton;

    @FindBy(linkText = "Different elements")
    private WebElement differentElementsButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openSite (String URL){
        driver.get(URL);
        this.URL = driver.getCurrentUrl();
        header = driver.getTitle();
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

    public boolean checkHeader (String expected){
        return header.equals(expected);
    }

    public boolean checkUsername (String expected){
        return username.getText().equals(expected);
    }

    public void clickServiceButton(){
        serviceButton.click();
    }

    public void goToDifferentElements(){
        differentElementsButton.click();
    }

}
