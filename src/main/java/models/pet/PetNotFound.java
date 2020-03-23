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
public class PetNotFound {

	@JsonProperty("code")
	private int code;

	@JsonProperty("type")
	private String type;

	@JsonProperty("message")
	private String message;

	public PetNotFound(int code, String type, String message) {
		this.code = code;
		this.type = type;
		this.message = message;
	}

	public PetNotFound() {

	}
}