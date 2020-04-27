package hw7;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import hw7.entities.User;
import hw7.pages.JDIHomePage;
import hw7.pages.JDIMetalsAndColors;

//@JSite("https://jdi-testing.github.io/jdi-light/")
public class JDISite {

//    @Url("/index.html")
    public static JDIHomePage jdiHomePage;
    public static JDIMetalsAndColors jdiMetalsAndColors;

    public static void open(){
        jdiHomePage.open();
    }

    public static void openMetalsAndColors(){
        jdiMetalsAndColors.open();
    }

}
