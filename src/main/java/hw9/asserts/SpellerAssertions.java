package hw9.asserts;


import hw9.dto.SpellerDTO;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

public class SpellerAssertions {

    private SpellerDTO[] spellerResult;

    public SpellerAssertions (SpellerDTO[] response){
        this.spellerResult = response;
    }

    public void verifyTextResult (List<String> expectedMistakes){
        List<String> actualMistakes = new ArrayList<>();
        for (SpellerDTO result : spellerResult){
            actualMistakes.add(result.getWord());
        }
        assertTrue(expectedMistakes.containsAll(actualMistakes)
                        && actualMistakes.containsAll(expectedMistakes));
    }
}
