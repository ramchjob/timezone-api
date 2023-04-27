package com.learn.timezone.client;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.learn.timezone.constants.TimeZoneAppConstants;
import com.learn.timezone.model.TimeZoneDetails;

@Component
public class TimeZoneApiClient {

    @Value("${timezone.api.client.url}")
    private String timeZoneApiUrl;

    @Autowired
    private RestTemplate restTemplate;
    public List<String> getTimeZones() {
        try {
            ResponseEntity<String[]> detailsResponse = restTemplate.exchange(timeZoneApiUrl + "/" + TimeZoneAppConstants.TIME_ZONES_PATH,
                    HttpMethod.GET, null, String[].class);
            return  Arrays.asList(detailsResponse.getBody());
        } catch (HttpClientErrorException e) {
            throw e;
        }
    }

    public TimeZoneDetails getTimeZoneById(String timeZone) {

        try {
            ResponseEntity<TimeZoneDetails> detailsResponse = restTemplate.exchange(timeZoneApiUrl + "/" + TimeZoneAppConstants.TIME_ZONE_BY_ID_PATH + "US/"+ timeZone,
                    HttpMethod.GET, null, TimeZoneDetails.class);
            return detailsResponse.getBody();
        } catch (HttpClientErrorException e) {
            throw e;
        }
    }
}
