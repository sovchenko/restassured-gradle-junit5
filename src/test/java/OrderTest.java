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
    @DisplayName("first test")
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
    @DisplayName("This test checks whether method is good")
    public void testPostByIdMethod(){
        PetController controller = new PetController();
        controller.updateNameAndStatusOfExistingPetById(10,"Luigi", "CasualGuy");
    }

    @Test
    @DisplayName("this is third test brodas")
    public void someTest(){
        PetController controller = new PetController();
        List<PetModel> soldPets = null;
        try {
            soldPets = controller.getAllPetsByStatus("sold");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        for(PetModel pet : soldPets){
            assertThat(pet.getStatus()).isEqualTo("sold");
        }
    }
}
