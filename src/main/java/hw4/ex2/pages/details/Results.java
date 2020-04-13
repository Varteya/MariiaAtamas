package hw4.ex2.pages.details;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;

public class Results extends BaseDetail {

    @FindBy(css = "ul.results")
    private WebElement results;
    private String summaryResult;
    private List<String> elementsResult;
    private String colorResult;
    private String metalResult;
    private List<String> vegetablesResult;

    public Results(WebDriver driver) {
        super(driver);
        List<WebElement> resultData = results.findElements(By.cssSelector("li"));
        for (WebElement dataElement : resultData) {
            String string = dataElement.getText();
            String[] splitted = string.split(": |, ");
            if (splitted[0].equals("Summary")) {
                summaryResult = splitted[1];
            } else if (splitted[0].equals("Color")){
                colorResult = splitted[1];
            } else if (splitted[0].equals("Metal")){
                metalResult = splitted[1];
            } else if (splitted[0].equals("Elements")){
                elementsResult = Arrays.asList(Arrays.copyOfRange(splitted, 1, splitted.length));
            } else {
                vegetablesResult = Arrays.asList(Arrays.copyOfRange(splitted, 1, splitted.length));
            }

        }

    }


    public String getSummaryResult() {
        return summaryResult;
    }

    public List<String> getElementsResult() {
        return elementsResult;
    }

    public String getColorResult() {
        return colorResult;
    }

    public String getMetalResult() {
        return metalResult;
    }

    public List<String> getVegetablesResult() {
        return vegetablesResult;
    }



}
