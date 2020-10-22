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

	@Override
	public String toString() {
		StringBuilder imagePath = new StringBuilder();
		StringBuilder summImagePath = new StringBuilder();
		imagePathList.stream().forEach(e->{
			imagePath.append(e+",");
		});
		summImagePathList.stream().forEach(e->{
			summImagePath.append(e+",");
		});

		return imagePath+";"+summImagePath;
	}
}
