
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
    "JFK",
    "EWR",
    "MAD",
    "LIS"
})
public class Locations {

    @JsonProperty("JFK")
    private JFK jFK;
    @JsonProperty("EWR")
    private EWR eWR;
    @JsonProperty("MAD")
    private MAD mAD;
    @JsonProperty("LIS")
    private LIS lIS;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("JFK")
    public JFK getJFK() {
        return jFK;
    }

    @JsonProperty("JFK")
    public void setJFK(JFK jFK) {
        this.jFK = jFK;
    }

    @JsonProperty("EWR")
    public EWR getEWR() {
        return eWR;
    }

    @JsonProperty("EWR")
    public void setEWR(EWR eWR) {
        this.eWR = eWR;
    }

    @JsonProperty("MAD")
    public MAD getMAD() {
        return mAD;
    }

    @JsonProperty("MAD")
    public void setMAD(MAD mAD) {
        this.mAD = mAD;
    }

    @JsonProperty("LIS")
    public LIS getLIS() {
        return lIS;
    }

    @JsonProperty("LIS")
    public void setLIS(LIS lIS) {
        this.lIS = lIS;
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
