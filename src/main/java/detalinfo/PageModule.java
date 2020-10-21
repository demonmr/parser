package detalinfo;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
public class PageModule {
	@JsonProperty
	private String title;
	@JsonProperty
	private String imagePath;

}
