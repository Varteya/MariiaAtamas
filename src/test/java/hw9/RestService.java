package hw9;

import com.google.gson.Gson;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;


public class RestService {

    private RequestSpecification REQUEST_SPECIFICATION;

    public RestService(){
        String url = GetProperties.getUrl();
        REQUEST_SPECIFICATION = new RequestSpecBuilder()
                .setBaseUri(url)
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();
    }

    public SpellerDTO[] spellerGetTextWithLang(String uri, String lang, String[] data){
        RequestSpecification specification = given(REQUEST_SPECIFICATION);
        specification.param("lang", lang);
        for (String part : data) {
            specification.param("text", part);
        }
        Response result = specification.get(uri);
        return new Gson().fromJson(result.getBody().asString(), SpellerDTO[].class);
    }

    public SpellerDTO[] spellerGetTextWithOptions(String uri, int options, String[] data) {
        RequestSpecification specification = given(REQUEST_SPECIFICATION);
        specification.param("options", options);
        for (String part : data) {
            specification.param("text", part);
        }
        Response result = specification.get(uri);
        return jsonToDto(result);
    }

    private SpellerDTO[] jsonToDto (Response response){
        return new Gson().fromJson(response.getBody().asString(),SpellerDTO[].class);
    }

}
