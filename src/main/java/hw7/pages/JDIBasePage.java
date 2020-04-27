package hw7.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;
import hw7.entities.User;
import hw7.forms.JDILogin;
import org.openqa.selenium.WebElement;

public class JDIBasePage extends WebPage {

    private JDILogin loginForm;

    @FindBy(id = "user-icon")
    private Button userButton;

    @FindBy(id = "user-name")
    private Text username;


    public void login(User user) {
        userButton.click();
        loginForm.login(user);
    }

    public boolean checkUsername(User user){
        return user.getUsername().equals(username.getValue());
    }

}
