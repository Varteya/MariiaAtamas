package hw9.service;

import com.google.gson.Gson;
import hw9.utils.GetProperties;
import hw9.dto.SpellerDTO;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;


public class RestService extends BaseService {

    private static RestService restService;

    public static RestService getRestService(){
        if (restService == null){
            restService = new RestService();
        }
        return restService;
    }

    private RestService(){}


    public SpellerDTO[] spellerGetTextWithLang(String uri, String lang, String[] data){
        RequestSpecification specification = given(REQUEST_SPECIFICATION);
        specification.param("lang", lang);
        for (String part : data) {
            specification.param("text", part);
        }
        Response result = specification.get(uri);
        return jsonToDto(result);
    }

    public SpellerDTO[] spellerGetTextWithOptions(String uri, int options, String[] data) {
        RequestSpecification specification = given(REQUEST_SPECIFICATION);
        specification.param("options", options);
        Response result = getWithTextParams(uri, specification, data);
        return jsonToDto(result);
    }



}
