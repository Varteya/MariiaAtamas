package hw9;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;

public class BaseTest {

    protected int IGNORE_DIGITS = 2;
    protected int IGNORE_URLS = 4;
    protected int FIND_REPEAT_WORDS = 8;
    protected int IGNORE_CAPITALIZATION = 512;


}
