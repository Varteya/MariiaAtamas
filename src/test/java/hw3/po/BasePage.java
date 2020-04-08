package hw3.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

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


    public boolean navigationBarButtonsAreDisplayed() {
        return allElementsAreDisplayed(navigationBarButtons);
    }

    public List<String> getNavigationBarButtonsTexts(){
        if (navigationBarButtonsTexts == null){
            navigationBarButtonsTexts = webElementsToText(navigationBarButtons);
        }
        return navigationBarButtonsTexts;
    }

    public boolean leftSectionIsDisplayed(){
        return allElementsAreDisplayed(leftMenu);
    }

    public List<String> getLeftMenuTexts(){
        if (leftMenuTexts == null){
            leftMenuTexts = webElementsToText(leftMenu);
        }
        return leftMenuTexts;
    }

    protected List<String> webElementsToText (List<WebElement> list){
        List<String> result = new ArrayList<>();
        for (WebElement element : list){
            result.add(element.getText());
        }
        return result;
    }

    protected boolean allElementsAreDisplayed(List<WebElement> list){
        for (WebElement element : list){
            if (!element.isDisplayed()){
                return false;
            }
        }
        return true;
    }

    public boolean checkURL (String expectedURL){
        return URL.equals(expectedURL);
    }
}
