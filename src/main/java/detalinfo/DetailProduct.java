package detalinfo;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import detalinfo.*;


@JsonAutoDetect
public class DetailProduct {


/*	private String name;

	private String minPrice;

	private String maxPrice;

	private String description;

	private Specifications specifications;*/

	@JsonProperty
	private CommonModule commonModule;

	@JsonProperty
	private PageModule pageModule;

	@JsonProperty
	private ImageModule imageModule;

	@JsonProperty
	private PriceModule priceModule;

	@JsonProperty
	private SpecsModule specsModule;




	public PageModule getPageModule() {
		return pageModule;
	}

	public ImageModule getImageModule() {
		return imageModule;
	}

	public PriceModule getPriceModule() {
		return priceModule;
	}

	public String toCSVWrite() {

		return commonModule.toString()+";"+

				pageModule.toString()+";"+
				imageModule.toString()+";"+
				priceModule.toString()+";"+
				specsModule.toString()+";";
	}
}
