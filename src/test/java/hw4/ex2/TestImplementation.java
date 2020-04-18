package hw4.ex2;

import hw4.BaseTest;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestImplementation extends BaseTest {

    private static Properties properties;

    {
        properties = new Properties();
        try(InputStream inputStream = TestImplementation.class.getClassLoader().getResourceAsStream("hw4/ex2/data.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected final String firstURL = properties.getProperty("first_url");
    protected final String login = properties.getProperty("login");
    protected final String password = properties.getProperty("password");
    protected final String secondURL = properties.getProperty("second_url");

    @BeforeMethod
    public void setUp (){
        super.setUp();
    }

    protected void goToMetalsAndColors (){
        homePage.goToMetalsAndColors();
    }


}
