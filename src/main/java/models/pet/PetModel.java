package models.pet;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;


import java.util.List;

@JsonPropertyOrder({"id", "category", "name", "photoUrls", "tags", "status"})
@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
public class PetModel {

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

    @Override
    public String toString() {
        return
                "PetModel {" +
                        "photoUrls = '" + photoUrls + '\'' +
                        ",name = '" + name + '\'' +
                        ",id = '" + id + '\'' +
                        ",category = '" + category + '\'' +
                        ",tags = '" + tags + '\'' +
                        ",status = '" + status + '\'' +
                        "}";
    }

}
