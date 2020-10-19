import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@JsonAutoDetect
public class Results implements Serializable {
    @JsonIgnore
    public String contextId;
    @JsonIgnore
    public boolean success;
    @JsonIgnore
    public int code;
    @JsonIgnore
    private String trace;

    @JsonProperty("results")
    public List<Product> products;
    @JsonIgnore
    public boolean finished;
    @JsonIgnore
    public int page;
    @JsonIgnore
    public int pageSize;
    @JsonIgnore
    public String postback;
    @JsonIgnore
    public String pin;
    @JsonIgnore
    public Map<String, String> runtime;




    public Results() {
    }

    @Override
    public String toString() {
        return "Results{" +
                "contextId='" + contextId + '\'' +
                ", success=" + success +
                ", code=" + code +
                ", trace='" + trace + '\'' +
                ", products=" + products +
                ", finished=" + finished +
                ", page=" + page +
                ", pageSize=" + pageSize +
                ", postback='" + postback + '\'' +
                ", pin='" + pin + '\'' +
                ", runtime=" + runtime +
                '}';
    }
}
