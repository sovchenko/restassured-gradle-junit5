package controllers.order;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.order.OrderFoundModel;
import models.order.OrderModel;
import models.order.OrderNotFoundModel;
import models.pet.PetModel;

import static  io.restassured.RestAssured.*;

public class OrderController {

    private RequestSpecification defaultRequestSpecification;

    public OrderController(){
        defaultRequestSpecification = new RequestSpecBuilder()
                .addHeader("api_key", "a8a8a8a8")
                .setContentType(ContentType.JSON)
                .setBasePath("/v2/store/order")
                .log(LogDetail.ALL)
                .build();
    }

    public OrderModel getOrderWithCertainId(int id){
        Response response = given(defaultRequestSpecification)
                .get(String.valueOf(id));

        if(response.statusCode() == 200){
            return response.as(OrderFoundModel.class);
        } else {
            return response.as(OrderNotFoundModel.class);
        }

    }

    public void addOrder(OrderModel model){
        given(defaultRequestSpecification)
                .body(model)
                .post().as(OrderFoundModel.class);
    }

    public void deleteOrderWithCertainId(int id){
        given(defaultRequestSpecification)
                .delete(String.valueOf(id));

    }


}
