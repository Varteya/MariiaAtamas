package hw7;

import com.epam.jdi.light.elements.init.PageFactory;
import hw5.BaseTest;
import hw7.entities.MetalsAndColorsData;
import hw7.entities.User;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static org.testng.Assert.assertTrue;

public class JDITest {

    private static Properties properties;
    {
        properties = new Properties();
        try(InputStream inputStream = BaseTest.class.getClassLoader().getResourceAsStream("hw7/data.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected final String login = properties.getProperty("login");
    protected final String password = properties.getProperty("password");
    protected final String username = properties.getProperty("username");

    @BeforeSuite(alwaysRun = true)
    public void setUp (){
        PageFactory.initSite(JDISite.class);
        JDISite.open();
        User user = new User(login, password, username);
        JDISite.jdiHomePage.login(user);
        assertTrue(JDISite.jdiHomePage.isUsernameCorrect(user));
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        killAllSeleniumDrivers();
    }

    @Test(dataProviderClass = JDIDataProvider.class, dataProvider = "testDataset")
    public void openSiteAndLogin(MetalsAndColorsData testData){
        JDISite.jdiHomePage.goToMetalsAndColors();
        JDISite.jdiMetalsAndColors.setValues(testData);
        JDISite.jdiMetalsAndColors.checkResults(testData);
    }

}
