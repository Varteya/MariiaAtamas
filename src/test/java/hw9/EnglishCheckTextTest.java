package hw9;

import hw9.asserts.SpellerAssertions;
import hw9.service.RestService;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

public class EnglishCheckTextTest extends BaseTest {

    private static final String CHECK_TEXT_URI = "checkText";
    private static final String LANG = "en";

    @Test(description = "Testing one word with a mistake", dataProvider = "oneWordWithMistakeData")
    public void oneWordWithMistake(String[] data){
        SpellerAssertions result = new SpellerAssertions(RestService.getRestService().spellerGetTextWithLang(CHECK_TEXT_URI, LANG, data));
        result.verifyTextResult(Arrays.asList(data));
    }

    @Test(description = "Testing with ignoring URLs", dataProvider = "testWithIgnoringURLs")
    public void ignoringURLs(String[] data){
        SpellerAssertions result = new SpellerAssertions(RestService.getRestService().spellerGetTextWithOptions(CHECK_TEXT_URI, IGNORE_URLS, new String[]{data[0]}));
        result.verifyTextResult(Arrays.asList(Arrays.copyOfRange(data, 1, data.length)));
    }

    @Test(description = "Testing without ignoring URLs", dataProvider = "testWithoutIgnoringURLs")
    public void findingURLs(String[] data){
        SpellerAssertions result = new SpellerAssertions(RestService.getRestService().spellerGetTextWithLang(CHECK_TEXT_URI, LANG, new String[]{data[0]}));
        result.verifyTextResult(Arrays.asList(Arrays.copyOfRange(data, 1, data.length)));
    }

    @DataProvider
    public Object[][] oneWordWithMistakeData() {
        return new Object[][]{
                {"Feeel"},
                {"Myyyy"},
                {"Wrth"}
        };
    }

    @DataProvider
    public Object[][] testWithIgnoringURLs(){
        return new Object[][]{
                {"For my father the Kiing and https://www.google.com!", "Kiing"},
                {"https://www.google.com knowss what I'm doing.", "knowss"}
        };
    }

    @DataProvider
    public Object[][] testWithoutIgnoringURLs(){
        return new Object[][]{
                {"For my father the King and https://www.google.com!", "google", "com"},
                {"https://www.google.com knows what I'm doing.", "google", "com"}
        };
    }

}
