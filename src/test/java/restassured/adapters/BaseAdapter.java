package restassured.adapters;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import restassured.RestAssuredOutputPrinter;
import utils.PropertyReader;

import java.io.ByteArrayOutputStream;

import static models.Constants.*;
import static org.apache.http.HttpStatus.SC_OK;

public class BaseAdapter {

    private static final String TOKEN = PropertyReader.getProperty(TOKEN_PROPERTY, TOKEN_PROPERTY);
    private static final String URL = PropertyReader.getProperty("ApiUrl");
    private static final int RESPONSE_TIMEOUT = Integer.parseInt(PropertyReader.getProperty("ResponseTimeout"));

    Gson converter = new Gson();

    public Response post(String uri, String body) {
        return getDefaultSpecification()
                .body(body)
                .log().all()
                .when()
                .post(uri)
                .then()
                .statusCode(SC_OK)
                .log().all()
                .extract().response();
    }

    public Response get(String uri, int limit) {
        return getDefaultSpecification()
                .param("limit", limit)
                .log().all()
                .when()
                .get(URL + uri)
                .then()
                .statusCode(SC_OK)
                .log().all()
                .extract().response();
    }

    private RequestSpecification getDefaultSpecification() {
        return RestAssured
                .given()
                .baseUri(URL)
                .config(getHttpClientConfig())
                .filter(new ResponseLoggingFilter(new RestAssuredOutputPrinter(new ByteArrayOutputStream())))
                .filter(new RequestLoggingFilter(new RestAssuredOutputPrinter(new ByteArrayOutputStream())))
                .contentType(ContentType.JSON)
                .header("Token", TOKEN);
    }

    private RestAssuredConfig getHttpClientConfig() {
        return RestAssured
                .config()
                .httpClient(HttpClientConfig.httpClientConfig()
                        .setParam(HTTP_CONNECTION_TIMEOUT, RESPONSE_TIMEOUT)
                        .setParam(HTTP_SOCKET_TIMEOUT, RESPONSE_TIMEOUT)
                        .setParam(HTTP_CONNECTION_MANAGER_TIMEOUT, RESPONSE_TIMEOUT));
    }
}
