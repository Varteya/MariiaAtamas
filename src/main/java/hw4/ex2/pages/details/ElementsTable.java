package hw4.ex2.pages.details;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ElementsTable extends BaseDetail {

    @FindBy(id="elements-checklist")
    private WebElement table;
    private List<WebElement> elements;

    public ElementsTable (WebDriver driver){
        super(driver);
        initializeElements();
    }

    private void initializeElements(){
        elements = table.findElements(By.cssSelector("p.checkbox"));
    }

    public void setElements(List<String> list){
        for (WebElement element : elements){
            if (list.contains(element.getText())){
                element.click();
            }
        }
    }

    public List<String> getElements (){
        List<String> result = new ArrayList<>();
        for (WebElement element : elements){
            if (element.findElement(By.cssSelector("input")).isSelected()){
                result.add(element.getText());
            }
        }
        return result;
    }


}
