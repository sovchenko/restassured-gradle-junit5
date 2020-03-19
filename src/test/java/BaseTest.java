import endpoints.Endpoint;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.*;


public class BaseTest {
    @BeforeAll
    public static void setUp(){
        baseURI = Endpoint.baseURI;
    }
}
