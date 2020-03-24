package models.pet;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;


import java.util.List;

@JsonPropertyOrder({"id", "category", "name", "photoUrls", "tags", "status"})
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class PetModel extends AbstractPetModel{

    @JsonProperty("id")
    private int id;

    @JsonProperty("category")
    private CategoryModel category;

    @JsonProperty("name")
    private String name;

    @JsonProperty("photoUrls")
    private List<String> photoUrls;

    @JsonProperty("tags")
    private List<TagModel> tags;

    @JsonProperty("status")
    private String status;

    public PetModel(){

    }

    public PetModel(int id, CategoryModel category, String name, List<String> photoUrls, List<TagModel> tags, String status) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.photoUrls = photoUrls;
        this.tags = tags;
        this.status = status;
    }
}
