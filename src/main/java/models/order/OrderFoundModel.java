package models.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderFoundModel extends OrderModel{

    @JsonProperty("petId")
    private int petId;

    @JsonProperty("quantity")
    private int quantity;

    @JsonProperty("id")
    private int id;

    @JsonProperty("shipDate")
    private String shipDate;

    @JsonProperty("complete")
    private boolean complete;

    @JsonProperty("status")
    private String status;

    @Override
    public String toString() {
        return
                "Order Model {" +
                        "petId = '" + petId + '\'' +
                        ",quantity = '" + quantity + '\'' +
                        ",id = '" + id + '\'' +
                        ",shipDate = '" + shipDate + '\'' +
                        ",complete = '" + complete + '\'' +
                        ",status = '" + status + '\'' +
                        "}";
    }
}