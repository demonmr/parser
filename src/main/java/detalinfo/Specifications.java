package detalinfo;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;
@JsonAutoDetect
public class Specifications {

	@JsonProperty
	private String attrName;

	@JsonProperty
	private String attrValue;


	@Override
	public String toString() {
		return  attrName + "," +
				 attrValue;
	}
}
