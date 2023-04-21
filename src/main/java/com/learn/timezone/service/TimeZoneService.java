package com.learn.timezone.service;

import com.learn.timezone.client.TimeZoneApiClient;
import com.learn.timezone.model.TimeZoneDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TimeZoneService {

    @Autowired
    TimeZoneApiClient client;
    public TimeZoneDetails getTimeZoneDetails(String timeZone) {

        return client.getTimeZoneById(timeZone);
    }

    public List<String> getTimeZoneDetails() {

        List<String> usTimeZones =  client.getTimeZones();
        return usTimeZones.stream().filter(tz -> tz.startsWith("US")).map( m -> m.replace("US/", ""))
        .collect(Collectors.toList());
    }
}
