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

    public SpellerDTO[] spellerGetTextRuWithoutOptions(String[] data){
        return spellerGetTextWithLang(RU, data);
    }

    public SpellerDTO[] spellerGetTextEnWithoutOptions(String[] data){
        return spellerGetTextWithLang(EN, data);
    }

    public SpellerDTO[][] spellerGetTextsEnWithoutOptions(String[] data){
        return spellerGetTextsWithLang(EN, data);
    }

    public SpellerDTO[] spellerGetTextWithOptions(int options, String[] data){
        return super.spellerGetTextWithOptions(options, data);
    }


}
