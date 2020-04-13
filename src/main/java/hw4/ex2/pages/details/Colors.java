package hw4.ex2.pages.details;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Colors extends Dropdown{

    @FindBy(id = "colors")
    private WebElement colors;

    public Colors (WebDriver driver){
        super(driver);
        dropdownMenu = colors;
    }

    public void setNewColor (String newColor){
        super.setNewOption(newColor);
    }

    public String getSelectedColor (){
        return super.getActualOption();
    }


}
