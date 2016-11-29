package com.goeuro.location.client;


import com.goeuro.domain.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

/**
 * @author July on 28.11.2016.
 * @project GoEuroTest
 */
@Component
@Qualifier(value = "locationClient")
public class LocationClient {

    @Autowired
    private RestOperations restOperations;

    private final String url;

    @Autowired
    public LocationClient(@Value("${location.service.url}") final String url){
        this.url = url;
    }

    public Location[] getResponse(String cityName) {
        return restOperations.getForObject(url + cityName, Location[].class);
    }
}
