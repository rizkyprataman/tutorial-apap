package apap.tutorial.pergipergi.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class TourGuideDetail {
    
    @JsonProperty("name")
    private String nama;

    @JsonProperty("age")
    private Integer age;

    @JsonProperty("count")
    private Integer count;
}
