package hw9.service;

import com.google.gson.Gson;
import hw9.dto.SpellerDTO;
import hw9.utils.GetProperties;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class BaseService {

    protected RequestSpecification REQUEST_SPECIFICATION;
    protected static final String CHECK_TEXT_URI = "checkText";
    protected static final String CHECK_TEXTS_URI = "checkTexts";
    protected static final String RU = "ru";
    protected static final String EN = "en";
    protected static final String UK = "uk";


    protected BaseService(){
        String url = GetProperties.getUrl();
        REQUEST_SPECIFICATION = new RequestSpecBuilder()
                .setBaseUri(url)
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();
    }

    public SpellerDTO[] spellerGetTextWithOptions(int options, String[] data) {
        RequestSpecification specification = given(REQUEST_SPECIFICATION);
        specification.param("options", options);
        Response result = getWithTextParams(CHECK_TEXT_URI, specification, data);
        return jsonToDto(result);
    }

    public SpellerDTO[] spellerGetTextWithLang(String lang, String[] data){
        RequestSpecification specification = given(REQUEST_SPECIFICATION);
        specification.param("lang", lang);
        for (String part : data) {
            specification.param("text", part);
        }
        Response result = specification.get(CHECK_TEXT_URI);
        return jsonToDto(result);
    }

    public SpellerDTO[][] spellerGetTextsWithLang(String lang, String[] data){
        RequestSpecification specification = given(REQUEST_SPECIFICATION);
        specification.param("lang", lang);
        for (String part : data) {
            specification.param("text", part);
        }
        Response result = specification.get(CHECK_TEXTS_URI);
        return jsonToDtoTexts(result);
    }


    protected Response getWithTextParams(String uri, RequestSpecification specification, String[] data){
        for (String part : data) {
            specification.param("text", part);
        }
        return specification.get(uri);
    }

    protected SpellerDTO[] jsonToDto (Response response){
        return new Gson().fromJson(response.getBody().asString(),SpellerDTO[].class);
    }

    protected SpellerDTO[][] jsonToDtoTexts (Response response){
        return new Gson().fromJson(response.getBody().asString(),SpellerDTO[][].class);
    }
}
