package pl.parser.nbp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExchangeRate {
    @JsonProperty("Table")
    private String table;
    @JsonProperty("Currency")
    private String currency;
    @JsonProperty("Code")
    private String code;
    @JsonProperty("Rates")
    private List<Rate> rates;

}
