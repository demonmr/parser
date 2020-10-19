import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

@JsonAutoDetect
public class Product {
    @JsonProperty
    private long productId;
    @JsonProperty
    private int sellerId;
    @JsonProperty
    private String oriMinPrice;
    @JsonProperty
    private String oriMaxPrice;
    @JsonProperty
    private long promotionId;
    @JsonProperty
    private Date startTime;
    @JsonProperty
    private Date endTime;
    @JsonProperty
    private int phase;
    @JsonProperty
    private String productTitle;
    @JsonProperty
    private String minPrice;
    @JsonProperty
    private String maxPrice;
    @JsonProperty
    private int discount;
    @JsonProperty
    private int totalStock;
    @JsonProperty
    private int stock;

    @JsonProperty
    private int orders;
    @JsonProperty
    private boolean soldout;
    @JsonProperty
    private String productImage;
    @JsonProperty("productDetailUrl")
    private String detailUrl;
    @JsonIgnore
    private String trace;
    @JsonProperty
    private int totalTranpro3;
    @JsonProperty
    private  String productPositiveRate;
    @JsonProperty
    private String productAverageStar;
    @JsonProperty
    private int itemEvalTotalNum;
    @JsonProperty
    private int gmtCreate;

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", sellerId=" + sellerId +
                ", oriMinPrice='" + oriMinPrice + '\'' +
                ", oriMaxPrice='" + oriMaxPrice + '\'' +
                ", promotionId=" + promotionId +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", phase=" + phase +
                ", productTitle='" + productTitle + '\'' +
                ", minPrice='" + minPrice + '\'' +
                ", maxPrice='" + maxPrice + '\'' +
                ", discount=" + discount +
                ", totalStock=" + totalStock +
                ", stock=" + stock +
                ", orders=" + orders +
                ", soldout=" + soldout +
                ", productImage='" + productImage + '\'' +
                ", detailUrl='" + detailUrl + '\'' +
                ", trace='" + trace + '\'' +
                ", totalTranpro3=" + totalTranpro3 +
                ", productPositiveRate='" + productPositiveRate + '\'' +
                ", productAverageStar='" + productAverageStar + '\'' +
                ", itemEvalTotalNum=" + itemEvalTotalNum +
                ", gmtCreate=" + gmtCreate +
                '}';
    }
}
