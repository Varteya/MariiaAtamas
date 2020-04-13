package hw4.ex2.pages.details;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Dropdown extends BaseDetail {

    protected WebElement dropdownMenu;

    protected Dropdown(WebDriver driver) {
        super(driver);
    }

    protected void setNewOption (String newOption){
        openCloseMenu();
        List<WebElement> dropdown = dropdownMenu.findElements(By.cssSelector("ul.dropdown-menu li"));
        for (WebElement element : dropdown){
            if(element.getText().equals(newOption)){
                element.click();
            }
        }
    }

    protected String getActualOption (){
        openCloseMenu();
        WebElement actualElement = dropdownMenu.findElement(By.cssSelector("ul.dropdown-menu li.selected"));
        String result = actualElement.getText();
        openCloseMenu();
        return result;
    }

    protected void openCloseMenu (){
        dropdownMenu.findElement(By.cssSelector("span.caret")).click();
    }
}
