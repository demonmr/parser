package detalinfo;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

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
    public String toCSVWrite(){
        Date date = new Date();
        return  productId +
                ";" + sellerId +
                ";" + oriMinPrice  +
                ";" + oriMaxPrice  +
                ";" + promotionId +
                //";" + startTime +
                ";" + new Date((startTime!=null)?(new Date().getTime()-startTime.getTime()):date.getTime()) +
                ";" + new Date((endTime!=null)?(endTime.getTime()+new Date().getTime()):date.getTime()) +

                // ";" + endTime +
                ";" + phase +
                ";" + productTitle +
                ";" + minPrice +
                ";" + maxPrice +
                ";" + discount +
                ";" + totalStock +
                ";" + stock +
                ";" + orders +
                ";" + soldout +
                ";" + productImage +
                ";" + detailUrl  +
                ";" + trace  +
                ";" + totalTranpro3 +
                ";" + productPositiveRate  +
                ";" + productAverageStar +
                ";" + itemEvalTotalNum +
                ";" + gmtCreate ;
    }
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

    public long getProductId() {
        return productId;
    }

    public int getSellerId() {
        return sellerId;
    }

    public String getOriMinPrice() {
        return oriMinPrice;
    }

    public String getOriMaxPrice() {
        return oriMaxPrice;
    }

    public long getPromotionId() {
        return promotionId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public int getPhase() {
        return phase;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public String getMinPrice() {
        return minPrice;
    }

    public String getMaxPrice() {
        return maxPrice;
    }

    public int getDiscount() {
        return discount;
    }

    public int getTotalStock() {
        return totalStock;
    }

    public int getStock() {
        return stock;
    }

    public int getOrders() {
        return orders;
    }

    public boolean isSoldout() {
        return soldout;
    }

    public String getProductImage() {
        return productImage;
    }

    public String getDetailUrl() {
        return detailUrl;
    }

    public String getTrace() {
        return trace;
    }

    public int getTotalTranpro3() {
        return totalTranpro3;
    }

    public String getProductPositiveRate() {
        return productPositiveRate;
    }

    public String getProductAverageStar() {
        return productAverageStar;
    }

    public int getItemEvalTotalNum() {
        return itemEvalTotalNum;
    }

    public int getGmtCreate() {
        return gmtCreate;
    }
}
