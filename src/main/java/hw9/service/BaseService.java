package hw9.service;

import com.google.gson.Gson;
import hw9.dto.SpellerDTO;
import hw9.utils.GetProperties;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;

public class BaseService {

    protected RequestSpecification REQUEST_SPECIFICATION;


    protected BaseService() {
        String url = GetProperties.getUrl();
        REQUEST_SPECIFICATION = new RequestSpecBuilder()
                .setBaseUri(url)
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();
    }

    protected Response getWithParams(String uri, Map<String, String> params) {
        return given(REQUEST_SPECIFICATION)
                .params(params)
                .get(uri);
    }

}
