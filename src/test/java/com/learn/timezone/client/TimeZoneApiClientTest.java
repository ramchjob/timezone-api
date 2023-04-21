package com.learn.timezone.client;

import com.learn.timezone.model.TimeZoneDetails;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class TimeZoneApiClientTest {

    @Mock
    RestTemplate template;

    @InjectMocks
    TimeZoneApiClient client;

    @Test
    void getTimeZonesTest() {
        String[] values = {"Central", "Eastern"};
        ResponseEntity<String[]> response = ResponseEntity.ok().body(values);
        Mockito.when(template.exchange(ArgumentMatchers.anyString(),
                ArgumentMatchers.any(HttpMethod.class),
                ArgumentMatchers.any(),
                ArgumentMatchers.<Class<String[]>>any())).thenReturn(response);
        List<String> timeZones = client.getTimeZones();
        assertNotNull(timeZones);
        assertEquals(2, timeZones.size());
    }

    @Test
    void getTimeZoneTest() {

        ResponseEntity<TimeZoneDetails> response = ResponseEntity.ok().body(buildTimeZone());
        Mockito.when(template.exchange(ArgumentMatchers.anyString(),
                ArgumentMatchers.any(HttpMethod.class),
                ArgumentMatchers.any(),
                ArgumentMatchers.<Class<TimeZoneDetails>>any())).thenReturn(response);
        TimeZoneDetails timeZoneDetails= client.getTimeZoneById("Central");
        assertNotNull(timeZoneDetails);

    }

    private TimeZoneDetails buildTimeZone() {
        TimeZoneDetails timeZoneDetails = new TimeZoneDetails();
        return timeZoneDetails;
    }
}
