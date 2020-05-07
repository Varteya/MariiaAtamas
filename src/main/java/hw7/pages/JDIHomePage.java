package hw7.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.ui.html.elements.common.Button;
import hw7.entities.User;
import hw7.forms.JDILogin;
import org.openqa.selenium.support.FindBy;

@Url("/index.html") @Title("Home Page")
public class JDIHomePage extends JDIBasePage {

    @FindBy(linkText = "Metals & Colors")
    private Button metalsAndColorsButton;

    public void goToMetalsAndColors(){
        metalsAndColorsButton.click();
    }

}
