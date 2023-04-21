package com.learn.timezone.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.learn.timezone.client.TimeZoneApiClient;
import com.learn.timezone.model.CurrentUtcOffset;
import com.learn.timezone.model.TimeZoneDetails;

@ExtendWith(MockitoExtension.class)
class TimeZoneServiceTest {


    @InjectMocks
    TimeZoneService service;

    @Mock
    TimeZoneApiClient client;

    @Test
    void getTimeZonesTest() {
        Mockito.when(client.getTimeZones()).thenReturn(List.of("US/Central", "US/Eastern"));
        List<String> timeZones = service.getTimeZoneDetails();
        assertNotNull(timeZones);
        assertEquals(2, timeZones.size());
    }

    @Test
    void getTimeZonesByIdTest() {
        Mockito.when(client.getTimeZoneById("Eastern")).thenReturn(buildTimeZoneDetails());
        TimeZoneDetails timeZone = service.getTimeZoneDetails("Eastern");
        assertNotNull(timeZone);
        assertNotNull(timeZone.getCurrentUtcOffset());
        assertEquals("Eastern", timeZone.getTimeZone());
        CurrentUtcOffset offSet = timeZone.getCurrentUtcOffset();
        assertEquals(1L, offSet.getMilliseconds());
        assertEquals(1L, offSet.getNanoseconds());
        assertEquals(1L, offSet.getSeconds());
        assertEquals(1L, offSet.getTicks());
    }

	private TimeZoneDetails buildTimeZoneDetails() {
		TimeZoneDetails details = new TimeZoneDetails();
		details.setDayLightSavingActive(false);
		details.setHasDayLightSaving(false);
		details.setCurrentLocalTime("Test");
		CurrentUtcOffset offSet = new CurrentUtcOffset();
		offSet.setMilliseconds(1L);
		offSet.setNanoseconds(1L);
		offSet.setSeconds(1L);
		offSet.setTicks(1L);
		details.setCurrentUtcOffset(offSet);
		details.setTimeZone("Eastern");
		return details;
	}


}
