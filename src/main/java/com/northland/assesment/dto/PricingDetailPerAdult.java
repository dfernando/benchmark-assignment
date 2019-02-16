
package com.northland.assesment.dto;

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
    "travelClass",
    "fareClass",
    "availability",
    "fareBasis"
})
public class PricingDetailPerAdult {

    @JsonProperty("travelClass")
    private String travelClass;
    @JsonProperty("fareClass")
    private String fareClass;
    @JsonProperty("availability")
    private Integer availability;
    @JsonProperty("fareBasis")
    private String fareBasis;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("travelClass")
    public String getTravelClass() {
        return travelClass;
    }

    @JsonProperty("travelClass")
    public void setTravelClass(String travelClass) {
        this.travelClass = travelClass;
    }

    @JsonProperty("fareClass")
    public String getFareClass() {
        return fareClass;
    }

    @JsonProperty("fareClass")
    public void setFareClass(String fareClass) {
        this.fareClass = fareClass;
    }

    @JsonProperty("availability")
    public Integer getAvailability() {
        return availability;
    }

    @JsonProperty("availability")
    public void setAvailability(Integer availability) {
        this.availability = availability;
    }

    @JsonProperty("fareBasis")
    public String getFareBasis() {
        return fareBasis;
    }

    @JsonProperty("fareBasis")
    public void setFareBasis(String fareBasis) {
        this.fareBasis = fareBasis;
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
