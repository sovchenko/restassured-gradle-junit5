import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.assertj.core.api.Assertions.*;


public class BaseTest {
    @BeforeAll
    public static void setUp(){
        baseURI = Endpoints.baseUri;

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
                .body("results.name", hasItems("Luke Skywalker", "C-3PO", "R2-D2", "Darth Vader", "Leia Organa", "Owen Lars"));
    }

    @Test
    public void verifyDeserializedObject(){
        HeroDTO hero = given()
                .accept(ContentType.JSON)
                .basePath("/people/1")
        .when()
                .get().as(HeroDTO.class);

        assertThat(hero.name).isEqualTo("Luke Skywalker");
    }

}
