package models.inventory;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InventoryModel {

	@JsonProperty("sold")
	private int sold;

	@JsonProperty("string")
	private int string;

	@JsonProperty("pending")
	private int pending;

	@JsonProperty("available")
	private int available;

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"sold = '" + sold + '\'' + 
			",string = '" + string + '\'' + 
			",pending = '" + pending + '\'' + 
			",available = '" + available + '\'' + 
			"}";
		}
}