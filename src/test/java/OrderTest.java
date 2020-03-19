import com.fasterxml.jackson.core.JsonProcessingException;
import controllers.order.OrderController;
import controllers.pet.PetController;
import models.order.OrderFoundModel;
import models.pet.PetModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class OrderTest extends BaseTest{

    @Test
    @DisplayName("Verify that order can be added")
    public void verifyThatOrderCanBeAdded(){
        OrderFoundModel orderModel = new OrderFoundModel(9,2, 8,"2020-02-19T20:36:13.283Z","placed",true);
        OrderController controller = new OrderController();
        controller.addOrder(orderModel);
        OrderFoundModel addedOrder = controller.getOrderById(8);
        assertThat(addedOrder.getId()).isEqualTo(8);
        assertThat(addedOrder.getPetId()).isEqualTo(9);
        assertThat(addedOrder.getQuantity()).isEqualTo(2);
    }

}
