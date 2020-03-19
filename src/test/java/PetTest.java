import com.fasterxml.jackson.core.JsonProcessingException;
import controllers.pet.PetController;
import models.pet.CategoryModel;
import models.pet.PetModel;
import models.pet.TagModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PetTest {
    @Test
    @DisplayName("This test checks whether method is good")
    public void testPostByIdMethod(){
        PetController controller = new PetController();
        controller.updateNameAndStatusOfExistingPetById(10,"Luigi", "CasualGuy");
    }

    @Test
    @DisplayName("Verify that pets can be retrieved by their status")
    public void verifyThatPetsCanBeRetrievedByTheStatus() throws JsonProcessingException {
        PetController controller = new PetController();
        List<PetModel> soldPets = soldPets = controller.getAllPetsByStatus("sold");

        for(PetModel pet : soldPets){
            assertThat(pet.getStatus()).isEqualTo("sold");
        }
    }

    @Test
    @DisplayName("Verify that pet can be added to the store")
    public void verifyThatPetCanBeAddedToTheStore(){
        List<String> photoURLs = new ArrayList<>();
        photoURLs.add("some photo");
        List<TagModel> tags = new ArrayList<>();

        PetModel pet = new PetModel(10, new CategoryModel(10,"mammals"),"Supersonic",photoURLs,tags,"available");
        PetController controller = new PetController();
        controller.addPet(pet);

        PetModel retrievedPet = controller.getPetById(10);
        assertThat(retrievedPet).isEqualTo(pet);
    }
}
