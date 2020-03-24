import controllers.order.OrderController;
import models.order.OrderFoundModel;
import models.order.OrderNotFoundModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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

    @Test
    @DisplayName("Verify that order can be retrieved")
    public void verifyThatOrderCanBeRetrieved(){
        OrderController controller = new OrderController();
        OrderFoundModel orderFoundModel = controller.getOrderById(8);
        assertThat(orderFoundModel.getStatus()).isEqualTo("placed");
        assertThat(orderFoundModel.getQuantity()).isEqualTo(2);
        
    }

    @Test
    @DisplayName("Verify that order can be deleted")
    public void verifyThatOrderCanBeDeleted(){
        OrderController orderController = new OrderController();
        orderController.deleteOrderWithCertainId(8);
        OrderNotFoundModel deletedOrder = orderController.getDeletedOrderById(8);
        assertThat(deletedOrder.getMessage()).isEqualTo("Order not found");

    }
}
