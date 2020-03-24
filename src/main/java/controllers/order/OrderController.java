package controllers.order;

import endpoints.Endpoint;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.order.OrderFoundModel;
import models.order.OrderNotFoundModel;

import static  io.restassured.RestAssured.*;
import static java.lang.String.*;

public class OrderController {

    private RequestSpecification defaultRequestSpecification;

    public OrderController(){
        defaultRequestSpecification = new RequestSpecBuilder()
                .addHeader("api_key", "a8a8a8a8")
                .setContentType(ContentType.JSON)
                .setBasePath(Endpoint.orderResource)
                .log(LogDetail.ALL)
                .build();
    }

    public OrderFoundModel getOrderById(int id){
        Response response = given(defaultRequestSpecification)
                .get(valueOf(id));
        return response.as(OrderFoundModel.class);
    }

    public OrderNotFoundModel getDeletedOrderById(int id){
        return given(defaultRequestSpecification)
                .get(valueOf(id))
                .as(OrderNotFoundModel.class);
    }

    public void addOrder(OrderFoundModel model){
        given(defaultRequestSpecification)
                .body(model)
                .post()
                .as(OrderFoundModel.class);
    }

    public void deleteOrderWithCertainId(int id){
        given(defaultRequestSpecification)
                .delete(valueOf(id));
    }

}
