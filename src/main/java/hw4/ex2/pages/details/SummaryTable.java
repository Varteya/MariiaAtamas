package hw4.ex2.pages.details;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

public class SummaryTable extends BaseDetail{
    @FindBy(id="odds-selector")
    private WebElement oddsRow;

    @FindBy(id="even-selector")
    private WebElement evenRow;

    @FindBy(id="calculate-button")
    private WebElement calculateButton;

    public SummaryTable (WebDriver driver){
        super(driver);
    }

    public void chooseValues (List<String> values){
        for (String value : values) {
            int intValue = Integer.valueOf(value);
            if (intValue % 2 == 1) {
                chooseValueInRow(value, oddsRow);
            } else {
                chooseValueInRow(value, evenRow);
            }
        }
        calculateButton.click();
    }

    private void chooseValueInRow (String value, WebElement row){
        List<WebElement> list = row.findElements(By.cssSelector("p.radio"));
        for (WebElement element : list){
            if (element.getText().equals(value)){
                element.click();
            }
        }
    }

    public List<String> actualValues (){
        return Arrays.asList(actualValue(oddsRow), actualValue(evenRow));
    }

    private String actualValue (WebElement row){
        List<WebElement> list = row.findElements(By.cssSelector("p.radio"));
        for (WebElement element : list){
            if (element.findElement(By.cssSelector("input")).isSelected()){
                return element.getText();
            }
        }
        throw new IllegalStateException();
    }
}
