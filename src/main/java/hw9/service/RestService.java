package hw9.service;

import com.google.gson.Gson;
import hw9.dto.SpellerDTO;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;


public class RestService extends BaseService {

    private static final String CHECK_TEXT_URI = "checkText";
    private static final String CHECK_TEXTS_URI = "checkTexts";
    private static final String RU = "ru";
    private static final String EN = "en";
    private static final String UK = "uk";

    private static final int IGNORE_DIGITS = 2;
    private static final int IGNORE_URLS = 4;
    private static final int FIND_REPEAT_WORDS = 8;
    private static final int IGNORE_CAPITALIZATION = 512;

    private static RestService restService;

    public static RestService getRestService() {
        if (restService == null) {
            restService = new RestService();
        }
        return restService;
    }

    private RestService() {
    }

    public static int getIgnoreDigits() {
        return IGNORE_DIGITS;
    }

    public static int getIgnoreUrls() {
        return IGNORE_URLS;
    }

    public static int getFindRepeatWords() {
        return FIND_REPEAT_WORDS;
    }

    public static int getIgnoreCapitalization() {
        return IGNORE_CAPITALIZATION;
    }

    public SpellerDTO[] spellerGetTextRuWithoutOptions(String[] data) {
        return spellerGetText(null, RU, data);
    }

    public SpellerDTO[] spellerGetTextEnWithoutOptions(String[] data) {
        return spellerGetText(null, EN, data);
    }

    public SpellerDTO[] spellerGetTextWithOptions(Integer options, String[] data) {
        return spellerGetText(options, null, data);
    }


    public SpellerDTO[] spellerGetText(Integer options, String lang, String[] data) {
        Map<String, String> params = new HashMap<>();
        if (options != null) {
            params.put("options", String.valueOf(options));
        }
        if (lang != null) {
            params.put("lang", lang);
        }
        for (String part : data) {
            params.put("text", part);
        }
        Response result = getWithParams(CHECK_TEXT_URI, params);
        return jsonToDto(result);
    }

    private SpellerDTO[] jsonToDto(Response response) {
        return new Gson().fromJson(response.getBody().asString(), SpellerDTO[].class);
    }


//    public SpellerDTO[][] spellerGetTextsEnWithoutOptions(String[] data){
//        return spellerGetTextsWithLang(EN, data);
//    }
//    private SpellerDTO[][] spellerGetTextsWithLang(String lang, String[] data){
//        RequestSpecification specification = given(REQUEST_SPECIFICATION);
//        specification.param("lang", lang);
//        for (String part : data) {
//            specification.param("text", part);
//        }
//        Response result = specification.get(CHECK_TEXTS_URI);
//        return jsonToDtoTexts(result);
//    }
//    private SpellerDTO[][] jsonToDtoTexts (Response response){
//        return new Gson().fromJson(response.getBody().asString(),SpellerDTO[][].class);
//    }

}
