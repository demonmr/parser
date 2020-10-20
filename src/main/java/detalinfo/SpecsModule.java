package detalinfo;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.TreeMap;

@JsonAutoDetect
public class SpecsModule {
	@JsonProperty
	private List<Specifications> props;
}
