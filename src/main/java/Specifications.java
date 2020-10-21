import java.util.Map;

public class Specifications {
	private Map<String, String> mapSpecification;

	public Specifications(Map<String, String> mapSpecification) {
		this.mapSpecification = mapSpecification;
	}

	public Map<String, String> getMapSpecification() {
		return mapSpecification;
	}

	public void setMapSpecification(Map<String, String> mapSpecification) {
		this.mapSpecification = mapSpecification;
	}
	public void addSpecification(String key,String value){
		mapSpecification.put(key, value);
	}

}
