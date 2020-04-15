package hw5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BasePage {

    protected WebDriver driver;

    protected String URL;
    protected String header;

    @FindBy(css = "ul.uui-navigation.nav > li")
    protected List<WebElement> navigationBarButtons;
    protected List<String> navigationBarButtonsTexts;

    @FindBy(css = "ul.sidebar-menu > li")
    protected List<WebElement> leftMenu;
    protected List<String> leftMenuTexts;

    public BasePage (WebDriver driver){
        this.driver = driver;
        this.URL = driver.getCurrentUrl();
        PageFactory.initElements(driver, this);
    }


    public boolean navigationBarButtonsAreDisplayed() {
        return allElementsAreDisplayed(navigationBarButtons);
    }

    public List<String> getNavigationBarButtonsTexts() {
        navigationBarButtonsTexts = webElementsToText(navigationBarButtons);
        return navigationBarButtonsTexts;
    }

    public boolean leftSectionIsDisplayed() {
        return allElementsAreDisplayed(leftMenu);
    }

    public List<String> getLeftMenuTexts() {
        leftMenuTexts = webElementsToText(leftMenu);
        return leftMenuTexts;
    }

    protected List<String> webElementsToText(@Nullable List<WebElement> list) {
        if (list != null) {
            return list.stream().map(WebElement::getText).collect(Collectors.toList());
        } else {
            return null;
        }
    }

    protected boolean allElementsAreDisplayed(List<WebElement> list) {
        for (WebElement element : list) {
            if (!element.isDisplayed()) {
                return false;
            }
        }
        return true;
    }

    public boolean checkURL(String expectedURL) {
        return URL.equals(expectedURL);
    }
}
