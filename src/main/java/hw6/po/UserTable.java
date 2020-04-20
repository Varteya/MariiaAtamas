package hw6.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class UserTable extends BasePage {

    @FindBy(id = "user-table")
    private WebElement usertable;
    private List<WebElement> dropdowns;
    private List<WebElement> usernames;
    private List<String> usernamesStringList;
    private List<WebElement> descriptionTexts;
    private List<WebElement> checkboxes;
    private List<WebElement> rows;

    public UserTable(WebDriver driver) {
        super(driver);
    }

    private void initializeDropdowns (){
        dropdowns = usertable.findElements(By.cssSelector("select"));
    }

    private void initializeUsernames (){
        usernames = usertable.findElements(By.cssSelector("td > a"));
        usernamesStringList = webElementsToStrings(usernames);
    }

    private void initializeDescriptionTexts (){
        descriptionTexts = usertable.findElements(By.cssSelector("div.user-descr"));
    }

    private void initializeCheckBoxes (){
        checkboxes = usertable.findElements(By.cssSelector("div.user-descr > input"));
    }

    private void initializeRows(){
        rows = usertable.findElements(By.cssSelector("tr"));
    }


    private boolean checkSmth (int count, List<WebElement> list){
        if (list.size() != count){
            return false;
        }
        for (WebElement element : list){
            if (!element.isDisplayed()){
                return false;
            }
        }
        return true;
    }

    public boolean checkDropdowns (int count){
        if (dropdowns == null){
            initializeDropdowns();
        }
        return checkSmth(count, dropdowns);
    }

    public boolean checkUsernames(int count){
        if (usernames == null){
            initializeUsernames();
        }
        return checkSmth(count, usernames);
    }

    public boolean checkDescriptionTests(int count){
        if (descriptionTexts == null){
            initializeDescriptionTexts();
        }
        return checkSmth(count, descriptionTexts);
    }

    public boolean checkCheckboxes(int count){
        if (checkboxes == null){
            initializeCheckBoxes();
        }
        return checkSmth(count, checkboxes);
    }

    public boolean checkRows (String expectedNumber, String expectedUser, String expectedDescription){
        if (rows == null){
            initializeRows();
        }
        WebElement actualRow = rows.get(Integer.valueOf(expectedNumber));
        String rowText = actualRow.getText();
        WebElement description = actualRow.findElement(By.cssSelector("div.user-descr > span"));
        String descriptionText = description.getText();
        descriptionText = descriptionText.replaceAll("\\s", " ");
        String[] splittedRowText = rowText.split("\\s\\s+|\\n");
        return (splittedRowText[0].equals(expectedNumber) &&
                splittedRowText[4].equals(expectedUser) &&
                descriptionText.equals(expectedDescription));
    }


    public boolean checkDropdownForUser (List<String> expectedDropdownValues, String username){
        if (rows == null){
            initializeRows();
        }
        int index = -1;
        for (int i = 0; i < usernamesStringList.size(); i++){
            if (usernamesStringList.get(i).equals(username)){
                index = i;
                break;
            }
        }
        if (index == -1){
            throw new IllegalArgumentException();
        }
        WebElement actualRow = rows.get(index);
        Select dropdown = new Select(dropdowns.get(index));
        List<WebElement> options = dropdown.getOptions();
        List<String> optionsTexts = webElementsToStrings(options);
        if (optionsTexts.size() != expectedDropdownValues.size()){
            return false;
        }
        return optionsTexts.containsAll(expectedDropdownValues);
    }

    private List<String> webElementsToStrings (List<WebElement> list){
        List<String> result = new ArrayList<>();
        for (WebElement element : list){
            result.add(element.getText());
        }
        return result;
    }

}
