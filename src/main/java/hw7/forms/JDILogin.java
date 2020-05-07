package hw7.forms;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import hw7.entities.User;

public class JDILogin extends Form<User> {
    @FindBy(id = "name")
    private TextField name;

    @FindBy(id = "password")
    private TextField password;

    @FindBy(id = "login-button")
    private Button submit;
}
