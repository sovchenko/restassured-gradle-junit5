package models.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class OrderFoundModel {

    @JsonProperty("petId")
    private final int petId;

    @JsonProperty("quantity")
    private final int quantity;

    @JsonProperty("id")
    private final int id;

    @JsonProperty("shipDate")
    private final String shipDate;


    @JsonProperty("status")
    private final String status;

    @JsonProperty("complete")
    private final boolean complete;

    public OrderFoundModel() {
        this.complete = false;
        this.id = 0;
        this.petId = 0;
        this.quantity = 0;
        this.shipDate = "0";
        this.status = "null";
    }

    public OrderFoundModel(int petId, int quantity, int id, String shipDate, String status, boolean complete) {
        this.petId = petId;
        this.quantity = quantity;
        this.id = id;
        this.shipDate = shipDate;
        this.status = status;
        this.complete = complete;
    }
}