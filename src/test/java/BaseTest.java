import io.restassured.RestAssured;
import io.restassured.authentication.BasicAuthScheme;
import io.restassured.common.mapper.TypeRef;
import io.restassured.config.ConnectionConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.assertj.core.api.Assertions.*;


public class BaseTest {
    @BeforeAll
    public static void setUp(){
        //add base uri
        // RestAssured.baseUri = Endpoints.baseUri;
        RestAssuredConfig.config()
                .set().connectionConfig(new ConnectionConfig().closeIdleConnectionsAfterEachResponse());
        authentication = new BasicAuthScheme();

    }

    @Test
    public void verifyNameOfThePersonWithFirstId(){
        get("/people/1")
                .then()
                .statusCode(200)
                .and()
                .body("name",equalTo("Luke Skywalker"));

    }

    @Test
    public void verifyThatStatusCode(){
        given()
                .accept(ContentType.JSON)
                .basePath("/people")
        .when()
                .get()
        .then()
                .statusCode(200)
                .contentType(ContentType.JSON);
    }

    @Test
    public void verifyThatBodyContainsCorrectName(){
        given()
                .accept(ContentType.JSON)
                .basePath("/people")
        .when()
                .get()
        .then()
                .body("count",equalTo(87))
                .and()
                .body("results.name", hasItems("Luke Skywalker", "C-3PO", "R2-D2", "Darth Vader", "Leia Organa", "Owen Lars"))
                .and()
                .log().all(true);
    }

    @Test
    public void verifyDeserializedObjectToMap(){
        Map<String,Object> hero  = given()
                .accept(ContentType.JSON)
                .basePath("/people/1")
        .when()
                .get().as(new TypeRef<Map<String, Object>>() {
                });

       System.out.println(hero);
       assertThat(hero.get("name")).isEqualTo("Luke Skywalker");
    }

    @Test
    public void verifyDeserializedObjectToDTO(){
        given()
                .header("myparam", "test")
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .cookie(new Cookie.Builder("someName", "someValue")
                    .setComment("this is my comment")
                    .setExpiryDate(new Date(10000000000000000L))
                    .setSecured(true)
                    .build()
                )
                .body("{ \"message\": \"message\"}")
                .log().ifValidationFails()

         .when()
                .post()
         .then()
                .statusCode(301);
    }

    @Test
    public void  verifyBasicAuth(){
        given()
                .auth().basic("admin","root")
                .auth().oauth2("somekingofaccess token");
    }

    @Test
    public void test(){
    }

}
