package detalinfo;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
public class PriceModule {
	@JsonProperty
	private String formatedActivityPrice;
	@JsonProperty
	private String formatedPrice;

	@Override
	public String toString() {
		return  formatedActivityPrice + ";" +
				formatedPrice;
	}
}
