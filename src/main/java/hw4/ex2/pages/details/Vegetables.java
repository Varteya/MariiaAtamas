package hw4.ex2.pages.details;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Vegetables extends Dropdown {

    @FindBy(id = "salad-dropdown")
    private WebElement vegetables;

    public Vegetables(WebDriver driver) {
        super(driver);
        dropdownMenu = vegetables;
    }

    public void setVegetables (List<String> vegetables){
        cleanField();
        setValues(vegetables);
    }

    public List<String> allValues (){
        openCloseMenu();
        List<WebElement> menu = vegetables.findElements(By.cssSelector("ul.dropdown-menu > li"));
        List<String> result = new ArrayList<>();
        for (WebElement element : menu){
            result.add(element.getText());
        }
        return result;
    }

    private void setValues (List<String> vegetables){
        for (String vegetable : vegetables){
            setNewOption(vegetable);
        }
    }

    public List<String> getActualOptions (){
        return Arrays.asList(vegetables.findElement(By.cssSelector("button.btn")).getText().split(", "));
    }

    private void cleanField (){
        setValues(getActualOptions());
    }

    @Override
    public String getActualOption(){
        throw new UnsupportedOperationException();
    }

}
