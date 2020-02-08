import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;
@Data
public class HeroDTO {
    public final String name;
    public final String height;
    public final String mass;
    public final String hairColor;
    public final String skinColor;
    public final String eyeColor;
    public final String birthYear;
    public final String gender;
    public final String homeworld;
    public final List<String> films;
    public final String species;
    public final String vehicles;
    public final List<String>  starships;
    public final String created;
    public final String edited;
    public final String url;
    
}
