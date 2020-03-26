import com.fasterxml.jackson.core.JsonProcessingException;
import controllers.pet.PetController;
import models.pet.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PetTest extends BaseTest{

    @Test
    @DisplayName("Verify that pet can be added to the store")
    @Order(1)
    public void verifyThatPetCanBeAddedToTheStore(){
        CategoryModel categoryModel = new CategoryModel(10, "mammal");
        List<String> photos = new ArrayList<>();
        photos.add("https://www.myphoto.com");
        List<TagModel> tags = new ArrayList<>();
        tags.add(new TagModel(10, "Some Tag"));
        AbstractPetModel dog = new PetModel(4,categoryModel,"mops", photos,tags,"healthy");

        PetController controller = new PetController();
        controller.addPet(dog);
        AbstractPetModel retrievedDog = controller.getPetById(4);
        assertThat(retrievedDog).isEqualTo(dog);
    }



    @Test
    @DisplayName("This test checks whether method is good")
    @Order(2)
    public void verifyThatPetNameAndStatusCanBeUpdated(){
        PetController controller = new PetController();
        controller.updateNameAndStatusOfExistingPetById(4,"kangaroo", "new one");
        PetModel pet = (PetModel) controller.getPetById(4);
        assertThat(pet.getStatus()).isEqualTo("new one");
        assertThat(pet.getName()).isEqualTo("kangaroo");
    }

//    @Test
//    @DisplayName("Verify that pets can be retrieved by their status")
//    public void verifyThatPetsCanBeRetrievedByTheStatus() throws JsonProcessingException {
//        PetController controller = new PetController();
//        List<PetModel> soldPets = controller.getAllPetsByStatus("sold");
//
//        for(PetModel pet : soldPets){
//            assertThat(pet.getStatus()).isEqualTo("sold");
//        }
//    }

    @Test
    @DisplayName("Verify that pets can be deleted")
    @Order(3)
    public void verifyThatPetsCanBeDeleted(){
        PetController controller = new PetController();
        controller.deletePetById(4);
        PetNotFoundModel deletedPet = (PetNotFoundModel) controller.getPetById(4);
        assertThat(deletedPet.getMessage()).isEqualTo("Pet not found");
    }

}
