package hw9.service;

import com.google.gson.Gson;
import hw9.dto.SpellerDTO;
import hw9.utils.GetProperties;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService {

    protected RequestSpecification REQUEST_SPECIFICATION;


    protected BaseService(){
        String url = GetProperties.getUrl();
        REQUEST_SPECIFICATION = new RequestSpecBuilder()
                .setBaseUri(url)
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();
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
}
