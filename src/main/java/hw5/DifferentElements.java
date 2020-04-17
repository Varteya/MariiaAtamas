package hw5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;



public class DifferentElements extends BasePage {

    @FindBy(css = "label.label-checkbox")
    private List<WebElement> checkboxes;

    @FindBy(css = "div.checkbox-row > label.label-radio")
    private List<WebElement> radios;

    @FindBy(css = "select.uui-form-element")
    private WebElement webColor;
    private Select color;

    @FindBy(css = "ul.panel-body-list > li")
    private List<WebElement> logs;
    private List<String[]> logsData;

    public DifferentElements(WebDriver driver) {
        super(driver);
    }

    public void setCheckboxes (List<String> list){
        for (WebElement element : checkboxes) {
            if (list.contains(element.getText())) {
                element.click();
            }
        }
    }

    public void setRadios (String metal){
        for (WebElement element : radios) {
            if (element.getText().equals(metal)) {
                element.click();
            }
        }
    }

    public void setColor (String color){
        this.color = new Select(webColor);
        this.color.selectByVisibleText(color);
    }

    public void splitLogs (){
        logsData = new ArrayList<>();
        for (WebElement element : logs){
            logsData.add(element.getText().split(" "));
        }
    }

    public String findColor (){
        return findSmth("Colors:");
    }

    public String findMetal (){
        return findSmth("metal:");
    }

    public void findElements (Map<String, Boolean> actualElements){
        for (String[] data : logsData){
            if (!data[1].equals("metal:") && !data[1].equals("Colors:")){
                String elementLog = data[1].substring(0, data[1].length() - 1);
                if (!actualElements.containsKey(elementLog)){
                    boolean state = data[data.length - 1].equals("true");
                    actualElements.put(elementLog, state);
                }
            }
        }
    }

    public String findSmth (String toFind) {
        for (String[] data : logsData){
            if (data[1].equals(toFind)){
                return data[data.length - 1];
            }
        }
        throw new IllegalArgumentException();
    }

    public boolean checkCheckboxes (Map<String, Boolean> actualElements){
        for (WebElement element : checkboxes) {
            WebElement checkboxField = element.findElement(By.cssSelector("input[type='checkbox']"));
            String checkBoxText = element.getText();
            if (checkboxField.isSelected() != actualElements.get(checkBoxText).booleanValue()){
                return false;
            }
        }
        return true;
    }

    public boolean checkRadios (String actualMetal){
        for (WebElement element : radios) {
            if (element.getText().equals(actualMetal)) {
                return element.findElement(By.cssSelector("input[type='radio']")).isSelected();
            }
        }
        return false;
    }

    public boolean checkColor(String actualColor){
        return color.getFirstSelectedOption().getText().equals(actualColor);
    }
}