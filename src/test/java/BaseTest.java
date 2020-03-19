import endpoints.Endpoint;
import io.restassured.parsing.Parser;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.*;


public class BaseTest {
    @BeforeAll
    public static void setUp(){
        baseURI = Endpoint.baseURI;
        defaultParser = Parser.JSON;
    }
}
