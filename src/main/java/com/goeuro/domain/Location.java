package com.goeuro.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.Map;

/**
 * @author July on 28.11.2016.
 * @project GoEuroTest
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Location {
    @JsonProperty("_id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("type")
    private String type;

    @JsonProperty("latitude")
    private String latitude;

    @JsonProperty("longitude")
    private String longitude;

    @JsonCreator
    public Location(@JsonProperty("_id") String id,
                    @JsonProperty("name") String name,
                    @JsonProperty("type") String type,
                    @JsonProperty("geo_position") Map<String, String> geoPosition) {

        this.id = id;
        this.name = name;
        this.type = type;
        this.latitude = geoPosition.get("latitude");
        this.latitude = geoPosition.get("longitude");

    }

}
