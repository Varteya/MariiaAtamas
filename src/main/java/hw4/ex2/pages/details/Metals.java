package hw4.ex2.pages.details;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Metals extends Dropdown {

    @FindBy(id = "metals")
    private WebElement metals;

    public Metals (WebDriver driver){
        super(driver);
        dropdownMenu = metals;
    }

    public void setNewMetal (String newMetal){
        super.setNewOption(newMetal);
    }

    public String getSelectedMetal (){
        return super.getActualOption();
    }
}
