
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
    "locations",
    "carriers",
    "currencies",
    "aircraft"
})
public class Dictionaries {

    @JsonProperty("locations")
    private Locations locations;
    @JsonProperty("carriers")
    private Carriers carriers;
    @JsonProperty("currencies")
    private Currencies currencies;
    @JsonProperty("aircraft")
    private Aircraft_ aircraft;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("locations")
    public Locations getLocations() {
        return locations;
    }

    @JsonProperty("locations")
    public void setLocations(Locations locations) {
        this.locations = locations;
    }

    @JsonProperty("carriers")
    public Carriers getCarriers() {
        return carriers;
    }

    @JsonProperty("carriers")
    public void setCarriers(Carriers carriers) {
        this.carriers = carriers;
    }

    @JsonProperty("currencies")
    public Currencies getCurrencies() {
        return currencies;
    }

    @JsonProperty("currencies")
    public void setCurrencies(Currencies currencies) {
        this.currencies = currencies;
    }

    @JsonProperty("aircraft")
    public Aircraft_ getAircraft() {
        return aircraft;
    }

    @JsonProperty("aircraft")
    public void setAircraft(Aircraft_ aircraft) {
        this.aircraft = aircraft;
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
