package detalinfo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CommonModule {
    @JsonProperty
    private String productId;

    @Override
    public String toString() {
        return productId;
    }
}
