package hw4.ex2.pages.details;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SubmitButton extends BaseDetail {

    @FindBy(id = "submit-button")
    private WebElement button;

    public SubmitButton(WebDriver driver) {
        super(driver);
    }

    public void submit (){
        button.click();
    }
}
