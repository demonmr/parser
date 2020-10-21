package detalinfo;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonAutoDetect
public class ImageModule {
	@JsonProperty
	private List<String> imagePathList;

	@JsonProperty
	private List<String> summImagePathList;
}
