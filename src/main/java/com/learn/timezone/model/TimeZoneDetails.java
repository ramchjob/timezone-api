package com.learn.timezone.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TimeZoneDetails {

    public TimeZoneDetails() {}

    private String timeZone;
    private String currentLocalTime;
    private CurrentUtcOffset currentUtcOffset;

    private boolean hasDayLightSaving;
    private boolean isDayLightSavingActive;

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getCurrentLocalTime() {
        return currentLocalTime;
    }

    public void setCurrentLocalTime(String currentLocalTime) {
        this.currentLocalTime = currentLocalTime;
    }

    public CurrentUtcOffset getCurrentUtcOffset() {
        return currentUtcOffset;
    }

    public void setCurrentUtcOffset(CurrentUtcOffset currentUtcOffset) {
        this.currentUtcOffset = currentUtcOffset;
    }

    public boolean isHasDayLightSaving() {
        return hasDayLightSaving;
    }

    public void setHasDayLightSaving(boolean hasDayLightSaving) {
        this.hasDayLightSaving = hasDayLightSaving;
    }

    public boolean isDayLightSavingActive() {
        return isDayLightSavingActive;
    }

    public void setDayLightSavingActive(boolean dayLightSavingActive) {
        isDayLightSavingActive = dayLightSavingActive;
    }
}