package pl.parser.nbp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Rate {
    @JsonProperty("No")
    private String no;
    @JsonProperty("EffectiveDate")
    private Date effectiveDate;
    @JsonProperty("Bid")
    private double bid;
    @JsonProperty("Ask")
    private double ask;
}
