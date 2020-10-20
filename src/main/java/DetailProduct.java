import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import detalinfo.*;


@JsonAutoDetect
public class DetailProduct {

	private String name;

	private String minPrice;

	private String maxPrice;

	private String description;

	private Specifications specifications;

	@JsonProperty
	private PageModule pageModule;

	@JsonProperty
	private ImageModule imageModule;

	@JsonProperty
	private PriceModule priceModule;

	@JsonProperty
	private SpecsModule specsModule;


	public String getName() {
		return name;
	}

	public String getMinPrice() {
		return minPrice;
	}

	public String getMaxPrice() {
		return maxPrice;
	}

	public String getDescription() {
		return description;
	}

	public Specifications getSpecifications() {
		return specifications;
	}

	public PageModule getPageModule() {
		return pageModule;
	}

	public ImageModule getImageModule() {
		return imageModule;
	}

	public PriceModule getPriceModule() {
		return priceModule;
	}
}
