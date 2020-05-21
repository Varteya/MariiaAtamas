package hw9;

import hw9.asserts.SpellerAssertions;
import hw9.service.RestService;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

public class RussianCheckTextTest {
    
    @Test(description = "Testing without options", dataProvider = "wordsWithoutOptions")
    public void testingWithoutOptions(String[] data) {
        new SpellerAssertions(RestService.getRestService().spellerGetTextRuWithoutOptions(new String[]{data[0]}))
                .verifyTextResult(Arrays.asList(Arrays.copyOfRange(data, 1, data.length)));
    }

    @Test(description = "Testing with ignoring digits", dataProvider = "wordsWithDigitsIgnore")
    public void testingWithIgnoringDigits(String[] data) {
        new SpellerAssertions(RestService.getRestService().spellerGetTextWithOptions(RestService.getIgnoreDigits(), new String[]{data[0]}))
                .verifyTextResult(Arrays.asList(Arrays.copyOfRange(data, 1, data.length)));
    }

    @Test(description = "Testing with finding repeats", dataProvider = "wordsWithRepeats")
    public void testingRepeatingWords(String[] data) {
        new SpellerAssertions(RestService.getRestService().spellerGetTextWithOptions(RestService.getFindRepeatWords(), new String[]{data[0]}))
                .verifyTextResult(Arrays.asList(Arrays.copyOfRange(data, 1, data.length)));
    }

    @Test(description = "Testing incorrect capitalization", dataProvider = "ignoreIncorrectCapitalization")
    public void testingIgnoringIncorrectCapitalization(String[] data) {
        new SpellerAssertions(RestService.getRestService().spellerGetTextWithOptions(RestService.getIgnoreCapitalization(), new String[]{data[0]}))
                .verifyTextResult(Arrays.asList(Arrays.copyOfRange(data, 1, data.length)));
    }


    @DataProvider
    public Object[][] wordsWithoutOptions() {
        return new Object[][]{
                {"Фозан", "Фозан"},
                {"Кортошко", "Кортошко"},
                {"Сидит кшка на окошке", "кшка"},
                {"Что нам делать с пьяным мтрсм?", "мтрсм"},
                {"Верная смрть. Никаких шааансов на успих. Так чево же мы ждём?", "смрть", "шааансов", "успих", "чево"},
                {"Я получл влллксть, корооря и не снилаь моему отцу!", "получл", "влллксть", "корооря", "снилаь"},
                {"Вам ли4 кланяться", "ли4"},
                {"По нашим данным, вы являетесь официальным опекуном двух разумных киборгов модели ДЕКС6", "ДЕКС6"},
                {"Не печалься о теХ чьё вРЕмя уже пришло.", "теХ", "вРЕмя"}
        };
    }

    @DataProvider
    public Object[][] wordsWithDigitsIgnore() {
        return new Object[][]{
                {"Ваакам ли4 кланяться", "Ваакам"},
                {"По нвим данным, вы являауветесь официальным опекуном двух раывзумных киборгов модели DEX-6", "являауветесь", "нвим", "раывзумных"}
        };
    }

    @DataProvider
    public Object[][] wordsWithRepeats() {
        return new Object[][]{
                {"Благородный поступок не не должен быть остановлен холодным советом", "не"},
                {"И и и хватит отчаяния", "и"}
        };
    }

    @DataProvider
    public Object[][] ignoreIncorrectCapitalization() {
        return new Object[][]{
                {"Не печалься о теХ чьё вРЕмя ужжж пришло.", "ужжж"}
        };
    }

}
