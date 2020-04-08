package hw3.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

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

    @FindBy(className = "benefit-icon")
    private List<WebElement> benefitIcons;

    @FindBy(className = "benefit-txt")
    private List<WebElement> benefitTexts;

    @FindBy(id = "frame")
    private WebElement frame;

    @FindBy(id = "frame-button")
    private WebElement frameButton;

    public HomePage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openSite (String URL){
        driver.get(URL);
        this.URL = driver.getCurrentUrl();
        header = driver.getTitle();
    }

    public boolean checkURL (String expectedURL){
        return URL.equals(expectedURL);
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

    public int benefitIconsSize(){
        return benefitIcons.size();
    }

    public List<String> getBenefitTextsTexts(){
        return webElementsToText(benefitTexts);
    }

    public boolean frameIsExists() {
        return frame != null;
    }

    public void switchToFrame(){
        driver.switchTo().frame("frame");
    }

    public boolean frameButtonIsExists(){
        return frameButton != null;
    }

    public boolean benefitIconsAreDisplayed(){
        return allElementsAreDisplayed(benefitIcons);
    }

    public boolean benefitTextsAreDisplayed(){
        return allElementsAreDisplayed(benefitTexts);
    }

    public void switchToHomePage (){
        driver.switchTo().defaultContent();
    }

}
