
package com.benchmark.assesment.dto;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "UX",
    "TP"
})
public class Carriers {

    @JsonProperty("UX")
    private String uX;
    @JsonProperty("TP")
    private String tP;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("UX")
    public String getUX() {
        return uX;
    }

    @JsonProperty("UX")
    public void setUX(String uX) {
        this.uX = uX;
    }

    @JsonProperty("TP")
    public String getTP() {
        return tP;
    }

    @JsonProperty("TP")
    public void setTP(String tP) {
        this.tP = tP;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
