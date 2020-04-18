package hw4.ex1;

import hw4.BaseTest;
import hw4.ex2.Browser;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

public class TestImplementation extends BaseTest {

    private static Properties properties;

    {
        properties = new Properties();
        try(InputStream inputStream = TestImplementation.class.getClassLoader().getResourceAsStream("hw4/ex1/data.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected WebDriver driver;
    protected final String firstURL = properties.getProperty("first_url");
    protected final String firstTitle = properties.getProperty("first_title");
    protected final String login = properties.getProperty("login");
    protected final String password = properties.getProperty("password");
    protected final String username = properties.getProperty("username");
    protected final String newValueForShowEntries = properties.getProperty("new_value_for_show_entries");
    protected final String typeToSearch = properties.getProperty("type_to_search");

    private Select showEntries;
    private List<WebElement> table;

    @BeforeMethod
    public void setUp() {
        super.setUp();
        driver = browser.getDriver();
    }

    protected boolean checkTitle (String expected){
        return homePage.checkTitle(expected);
    }

    protected boolean checkUsername() {
        return homePage.getUsername().equals(username);
    }

    protected void openTableWithPages () {
        driver.findElement(By.linkText("Service")).click();
        driver.findElement(By.linkText("Table with pages")).click();
    }

    protected String showEntriesValue (){
        initializeShowEntries();
        return showEntries.getFirstSelectedOption().getText();
    }

    protected void selectNewShowEntriesValue(String newValue){
        initializeShowEntries();
        showEntries.selectByValue(newValue);
    }

    protected void initializeShowEntries (){
        if (showEntries == null) {
            showEntries = new Select(driver.findElement(By.cssSelector("[name='table-with-pages_length']")));
        }
    }

    protected boolean isTableDisplayedCorrect (){
        initializeTable();
        String tableInfo = driver.findElement(By.id("table-with-pages_info")).getText();
        String[] tableInfoSplited = tableInfo.split(" ");
        int allTableSize = Integer.valueOf(tableInfoSplited[tableInfoSplited.length - 2]);
        int expectedTableSize = Integer.valueOf(showEntriesValue());
        return ((table.size() == expectedTableSize) ||
                ((expectedTableSize > allTableSize) && (table.size() == allTableSize)));
    }

    protected void typeToSearch (){
        WebElement search = driver.findElement(By.cssSelector("#table-with-pages_filter > label > input"));
        search.sendKeys(typeToSearch);
    }

    protected boolean checkTableAfterSearch() {
        initializeTable();
        for (WebElement row : table){
            if (!checkRow(row)){
                return false;
            }
        }
        return true;
    }

    protected boolean checkRow(WebElement row){
        List<WebElement> parts = row.findElements(By.cssSelector("td"));
        for (WebElement part : parts){
            if (part.getText().toLowerCase().contains(typeToSearch.toLowerCase())){
                return true;
            }
        }
        return false;
    }

    protected void initializeTable (){
        table = driver.findElements(By.cssSelector("#table-with-pages > tbody > tr"));
    }


}
