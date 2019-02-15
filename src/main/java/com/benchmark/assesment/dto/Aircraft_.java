
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
    "319",
    "332"
})
public class Aircraft_ {

    @JsonProperty("319")
    private String _319;
    @JsonProperty("332")
    private String _332;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("319")
    public String get319() {
        return _319;
    }

    @JsonProperty("319")
    public void set319(String _319) {
        this._319 = _319;
    }

    @JsonProperty("332")
    public String get332() {
        return _332;
    }

    @JsonProperty("332")
    public void set332(String _332) {
        this._332 = _332;
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
