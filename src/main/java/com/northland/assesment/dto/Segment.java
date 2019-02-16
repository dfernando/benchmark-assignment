
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
    "flightSegment",
    "pricingDetailPerAdult"
})
public class Segment {

    @JsonProperty("flightSegment")
    private FlightSegment flightSegment;
    @JsonProperty("pricingDetailPerAdult")
    private PricingDetailPerAdult pricingDetailPerAdult;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("flightSegment")
    public FlightSegment getFlightSegment() {
        return flightSegment;
    }

    @JsonProperty("flightSegment")
    public void setFlightSegment(FlightSegment flightSegment) {
        this.flightSegment = flightSegment;
    }

    @JsonProperty("pricingDetailPerAdult")
    public PricingDetailPerAdult getPricingDetailPerAdult() {
        return pricingDetailPerAdult;
    }

    @JsonProperty("pricingDetailPerAdult")
    public void setPricingDetailPerAdult(PricingDetailPerAdult pricingDetailPerAdult) {
        this.pricingDetailPerAdult = pricingDetailPerAdult;
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
