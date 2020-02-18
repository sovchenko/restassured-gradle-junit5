package models.order;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class OrderNotFoundModel extends OrderModel {

    @JsonProperty("code")
    private int code;

    @JsonProperty("type")
    private String type;

    @JsonProperty("message")
    private String message;

    @Override
    public String toString() {
        return
                "OrderNotFoundModel {" +
                        "code = '" + code + '\'' +
                        ",type = '" + type + '\'' +
                        ",message = '" + message + '\'' +
                        "}";
    }
}