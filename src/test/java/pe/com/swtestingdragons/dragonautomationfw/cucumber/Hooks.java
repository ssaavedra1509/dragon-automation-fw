package pe.com.swtestingdragons.dragonautomationfw.cucumber;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pe.com.swtestingdragons.dragonautomationfw.base.BaseTest;
import pe.com.swtestingdragons.dragonautomationfw.util.Urls;

import static org.hamcrest.Matchers.lessThan;

public class Hooks {

    private static RequestSpecification redmineRequestSpecification;
    private static ResponseSpecification redmineResponseSpecification;

    @Before("@ApiRest")
    public static void setup() {

        redmineRequestSpecification = new RequestSpecBuilder()
                .setBaseUri(Urls.REDMINE_URL)
                .setBasePath("/")
                //.setPort(8081)
                .addHeader("Content-Type", "application/json")
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .addHeader("Accept", "application/json")
                .addHeader("X-Redmine-API-Key", "3bf031106d2a0f3878e225d012627b995f5eeb9d")
                .build();

        redmineResponseSpecification = new ResponseSpecBuilder()
                .expectResponseTime(lessThan(3000L))
                .build();

        RestAssured.requestSpecification = redmineRequestSpecification;
        RestAssured.responseSpecification = redmineResponseSpecification;
    }

    @After("@ApiRest")
    public static void cleanUp(){
        RestAssured.reset();
    }

    @Before("@E2E")
    public static void setUp(){
        BaseTest.setUpAndLaunchApp();
    }

    @After("@E2E")
    public static void tearDown(){
        BaseTest.tearDown();
    }
}