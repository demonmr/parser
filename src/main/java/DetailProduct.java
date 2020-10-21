import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import detalinfo.ActionModule;
import detalinfo.ImageModule;
import detalinfo.PageModule;
import detalinfo.PriceModule;


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

	@Override
	public String toString() {
		return "DetailProduct{" +
				"name='" + name + '\'' +
				", minPrice='" + minPrice + '\'' +
				", maxPrice='" + maxPrice + '\'' +
				", description='" + description + '\'' +
				", specifications=" + specifications +
				", pageModule=" + pageModule +
				", imageModule=" + imageModule +
				", priceModule=" + priceModule +
				'}';
	}

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
