package models.pet;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TagModel {

    @JsonProperty("id")
    private int id;

    @JsonProperty("name")
    private String name;

    @Override
    public String toString() {
        return
                "TagsModel {" +
                        "name = '" + name + '\'' +
                        ",id = '" + id + '\'' +
                        "}";
    }
}
