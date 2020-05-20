package hw9;

import hw9.asserts.SpellerAssertions;
import hw9.service.RestService;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

public class RussianCheckTextTest extends BaseTest {

    @Test(description = "Testing one word with a mistake", dataProvider = "oneWordWithMistakeData")
    public void oneWordWithMistake(String data){
        new SpellerAssertions(RestService.getRestService().spellerGetTextRuWithoutOptions(new String[]{data}))
                .verifyTextResult(Arrays.asList(data));
    }

    @Test(description = "Testing one word with a mistake on full sentence", dataProvider = "oneWordWithMistakeInSentenceData")
    public void oneWordWithMistakeInSentence(String[] data){
        new SpellerAssertions(RestService.getRestService().spellerGetTextRuWithoutOptions(new String[]{data[0]}))
                .verifyTextResult(Arrays.asList(data[1]));
    }

    @Test(description = "Testing some words with mistakes", dataProvider = "someWordsWithMistakes")
    public void someWordsWithMistakes(String[] data){
        new SpellerAssertions(RestService.getRestService().spellerGetTextRuWithoutOptions(new String[]{data[0]}))
                .verifyTextResult(Arrays.asList(Arrays.copyOfRange(data, 1, data.length)));
    }

    @Test(description = "Testing with ignoring digits", dataProvider = "wordsWithDigitsIgnore")
    public void testingWithIgnoringDigits (String[] data){
        new SpellerAssertions(RestService.getRestService().spellerGetTextWithOptions(IGNORE_DIGITS, new String[]{data[0]}))
                .verifyTextResult(Arrays.asList(Arrays.copyOfRange(data, 1, data.length)));
    }

    @Test(description = "Testing without ignoring digits", dataProvider = "wordsWithoutDigitsIgnore")
    public void testingWithoutIgnoringDigits (String[] data){
        new SpellerAssertions(RestService.getRestService().spellerGetTextRuWithoutOptions(new String[]{data[0]}))
                .verifyTextResult(Arrays.asList(Arrays.copyOfRange(data, 1, data.length)));
    }

    @Test(description = "Testing with finding repeats", dataProvider = "wordsWithRepeats")
    public void testingRepeatingWords (String[] data){
        new SpellerAssertions(RestService.getRestService().spellerGetTextWithOptions(FIND_REPEAT_WORDS, new String[]{data[0]}))
                .verifyTextResult(Arrays.asList(Arrays.copyOfRange(data, 1, data.length)));
    }

    @Test(description = "Testing incorrect capitalization", dataProvider = "ignoreIncorrectCapitalization")
    public void testingIgnoringIncorrectCapitalization (String[] data){
        new SpellerAssertions(RestService.getRestService().spellerGetTextWithOptions(IGNORE_CAPITALIZATION, new String[]{data[0]}))
                .verifyTextResult(Arrays.asList(Arrays.copyOfRange(data, 1, data.length)));
    }

    @Test(description = "finding incorrect capitalization", dataProvider = "findIncorrectCapitalization")
    public void testingAndFindingIncorrectCapitalization (String[] data){
        new SpellerAssertions(RestService.getRestService().spellerGetTextRuWithoutOptions(new String[]{data[0]}))
                .verifyTextResult(Arrays.asList(Arrays.copyOfRange(data, 1, data.length)));
    }


    @DataProvider
    public Object[][] oneWordWithMistakeData() {
        return new Object[][]{
                {"Фозан"},
                {"Кортошко"}
        };
    }

    @DataProvider
    public Object[][] oneWordWithMistakeInSentenceData(){
        return new Object[][]{
                {"Сидит кшка на окошке", "кшка"},
                {"Что нам делать с пьяным мтрсм?", "мтрсм"}
        };
    }

    @DataProvider
    public Object[][] someWordsWithMistakes(){
        return new Object[][]{
                {"Верная смрть. Никаких шааансов на успих. Так чево же мы ждём?", "смрть", "шааансов", "успих", "чево"},
                {"Я получл влллксть, корооря и не снилаь моему отцу!", "получл", "влллксть", "корооря", "снилаь"}
        };
    }

    @DataProvider
    public Object[][] wordsWithDigitsIgnore(){
        return new Object[][]{
                {"Ваакам ли4 кланяться", "Ваакам"},
                {"По нвим данным, вы являауветесь официальным опекуном двух раывзумных киборгов модели DEX-6", "являауветесь", "нвим", "раывзумных"}
        };
    }

    @DataProvider
    public Object[][] wordsWithoutDigitsIgnore(){
        return new Object[][]{
                {"Вам ли4 кланяться", "ли4"},
                {"По нашим данным, вы являетесь официальным опекуном двух разумных киборгов модели ДЕКС6", "ДЕКС6"}
        };
    }

    @DataProvider
    public Object[][] wordsWithRepeats(){
        return new Object[][]{
                {"Благородный поступок не не должен быть остановлен холодным советом", "не"},
                {"И и и хватит отчаяния", "и"}
        };
    }

    @DataProvider
    public Object[][] ignoreIncorrectCapitalization(){
        return new Object[][]{
                {"Не печалься о теХ чьё вРЕмя ужжж пришло.", "ужжж"}
        };
    }

    @DataProvider
    public Object[][] findIncorrectCapitalization(){
        return new Object[][]{
                {"Не печалься о теХ чьё вРЕмя уже пришло.", "теХ", "вРЕмя"}
        };
    }


}
