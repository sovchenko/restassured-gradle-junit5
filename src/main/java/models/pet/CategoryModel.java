package models.pet;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class CategoryModel {

    @JsonProperty("id")
    private int id;

    @JsonProperty("name")
    private String name;
}
