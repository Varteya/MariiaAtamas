package hw4.ex2.pages;

import hw4.ex2.pages.details.*;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class MetalsAndColorsPage extends BasePage {

    private SummaryTable summaryTable;
    private ElementsTable elementsTable;
    private Colors colors;
    private Metals metals;
    private Vegetables vegetables;
    private SubmitButton submitButton;
    private Results results;

    public MetalsAndColorsPage (WebDriver driver){
        super(driver);
        summaryTable = new SummaryTable(driver);
        elementsTable = new ElementsTable(driver);
        colors = new Colors(driver);
        metals = new Metals(driver);
        vegetables = new Vegetables(driver);
        submitButton = new SubmitButton(driver);
    }

    public void setSummaryValues(List<String> list){
        summaryTable.chooseValues(list);
    }

    public List<String> getSummaryValues(){
        return summaryTable.actualValues();
    }

    public void setElementsTable (List<String> list){
        elementsTable.setElements(list);
    }

    public List<String> getElementsTable (){
        return elementsTable.getElements();
    }

    public void setNewColor (String newColor){
        colors.setNewColor(newColor);
    }

    public String getSelectedColor (){
        return colors.getSelectedColor();
    }

    public void setNewMetal (String newMetal){
        metals.setNewMetal(newMetal);
    }

    public String getSelectedMetal (){
        return metals.getSelectedMetal();
    }

    public void setVegetables (List<String> newVegetables){
        vegetables.setVegetables(newVegetables);
    }

    public List<String> getVegetables () {
        return vegetables.getActualOptions();
    }

    public void submit (){
        submitButton.submit();
        results = new Results(driver);
    }

    public String getSummaryResult() {
        return results.getSummaryResult();
    }

    public List<String> getElementsResult() {
        return results.getElementsResult();
    }

    public String getColorResult() {
        return results.getColorResult();
    }

    public String getMetalResult() {
        return results.getMetalResult();
    }

    public List<String> getVegetablesResult() {
        return results.getVegetablesResult();
    }

    public List<String> vegetablesAllValues(){
        return vegetables.allValues();
    }

}
