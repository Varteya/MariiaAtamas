package hw7.pages;

import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.ui.html.elements.common.Button;
import hw7.entities.MetalsAndColorsData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static junit.framework.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;


@Url("metals-colors.html") @Title("Metal and Colors")
public class JDIMetalsAndColors extends WebPage {

    @FindBy(id="odds-selector")
    private WebElement oddsRow;

    @FindBy(id="even-selector")
    private WebElement evenRow;

    @FindBy(id="calculate-button")
    private WebElement calculateButton;


    @FindBy(id = "submit-button")
    private Button submitButton;

    @JDropdown(root = "#colors",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    private Dropdown colors;


    @JDropdown(root = "#metals",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    private Dropdown metals;

    @JDropdown(root = "#salad-dropdown",
            value = ".btn",
            list = "li",
            expand = ".caret")
    private Dropdown vegetables;

    @FindBy(css = "#elements-checklist input")
    private Checklist elements;

    @FindBy(css = "ul.results > li")
    private WebList results;


    public void setValues(MetalsAndColorsData data){
        this.setSummary(data.getSummary());
        this.setElements(data.getElements());
        this.setColor(data.getColor());
        this.setMetal(data.getMetals());
        this.setVegetables(data.getVegetables());
        submitButton.click();
    }


    private void setColor(String color){
        colors.select(color);
    }

    private void setMetal (String metal){
        metals.select(metal);
    }

    private void setVegetables (List<String> newVegetables){
        vegetables.select("Vegetables");
        for (String vegetable : newVegetables){
            vegetables.select(vegetable);
        }
    }

    private void setSummary(List<String> values){
        for (String value : values) {
            int intValue = Integer.valueOf(value);
            if (intValue % 2 == 1) {
                chooseValueInRow(value, oddsRow);
            } else {
                chooseValueInRow(value, evenRow);
            }
        }
    }

    private void chooseValueInRow (String value, WebElement row){
        List<WebElement> list = row.findElements(By.cssSelector("p.radio"));
        for (WebElement element : list){
            if (element.getText().equals(value)){
                element.click();
            }
        }
    }

    private void setElements(List<String> newElements){
        for (String element : newElements){
            elements.select(element);
        }
    }



    public void checkResults(MetalsAndColorsData expected){
        String summaryResult = "";
        List<String> elementsResult = null;
        String colorResult = "";
        String metalResult = "";
        List<String> vegetablesResult = null;

        for (WebElement dataElement : results) {
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


        String expectedSummary = Integer.valueOf(expected.getSummary().get(0)) + Integer.valueOf(expected.getSummary().get(1)) + "";
        assertTrue(summaryResult.equals(expectedSummary));
        assertTrue(elementsResult.containsAll(expected.getElements()) && expected.getElements().containsAll(elementsResult));
        assertTrue(colorResult.equals(expected.getColor()));
        assertTrue(metalResult.equals(expected.getMetals()));
        assertTrue(vegetablesResult.containsAll(expected.getVegetables()) && expected.getVegetables().containsAll(vegetablesResult));

    }



//    private MetalsAndColorsForm metalsAndColorsForm;
//
//    public void setValues(MetalsAndColorsData data){
//        metalsAndColorsForm.setValues(data);
//    }



}
