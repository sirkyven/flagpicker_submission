package com.venkateshgangisetti.FlagPicker;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.Getter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "continent",
        "countries"
})

@Data
public class Continent {

    @JsonProperty("continent")
    public String continent;
    @JsonProperty("countries")
    public List<Country> countries = new ArrayList<>();
}