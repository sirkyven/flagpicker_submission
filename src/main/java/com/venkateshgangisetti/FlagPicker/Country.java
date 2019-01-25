package com.venkateshgangisetti.FlagPicker;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "flag"
})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Country {

    @JsonProperty("name")
    public String name;
    @JsonProperty("flag")
    public String flag;

}