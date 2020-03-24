package controllers.pet;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.pet.AbstractPetModel;
import models.pet.PetModel;
import models.pet.PetNotFoundModel;

import java.util.List;

import static endpoints.Endpoint.*;
import static io.restassured.RestAssured.*;
import static io.restassured.filter.log.LogDetail.*;
import static io.restassured.http.ContentType.*;
import static java.lang.String.*;

public class PetController {
    private RequestSpecification defaultSpecification;

    public PetController() {
        defaultSpecification = new RequestSpecBuilder()
                .setContentType(JSON)
                .setAccept(JSON)
                .setBasePath(petResource)
                .addHeader("api_key", "a8a8a8a8")
                .log(ALL)
                .build();
    }

    public AbstractPetModel getPetById(int id) {
        Response response = given(defaultSpecification)
                .get(valueOf(id));

        if (response.statusCode() == 200) {
            return response.as(PetModel.class);
        } else {
            return response.as(PetNotFoundModel.class);
        }
    }

    public PetModel addPet(AbstractPetModel pet) {
        return given(defaultSpecification)
                .body(pet)
                .post()
                .as(PetModel.class);
    }

    public void deletePetById(int id) {
        given(defaultSpecification)
                .delete(valueOf(id));
    }

    public void updateNameAndStatusOfExistingPetById(int id, String name, String status) {
        given(defaultSpecification)
                .contentType(URLENC)
                .formParams("name", name, "status", status)
                .post(valueOf(id));
    }

    public void updateExistingPet(PetModel model) {
        given(defaultSpecification)
                .body(model)
                .put()
                .as(PetModel.class);
    }

    public List<PetModel> getAllPetsByStatus(String status) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonResponse = given(defaultSpecification.param("status", status))
                .get("/findByStatus")
                .then()
                .extract()
                .body()
                .asString();

        List<PetModel> allPets = mapper.readValue(jsonResponse, new TypeReference<List<PetModel>>() {
        });
        return allPets;
    }
}
