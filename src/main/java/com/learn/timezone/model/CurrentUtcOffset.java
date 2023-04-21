package com.learn.timezone.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrentUtcOffset {

    public CurrentUtcOffset(){}

    private Long seconds;
    private Long milliseconds;
    private Long ticks;
    private Long nanoseconds;
	public Long getSeconds() {
		return seconds;
	}
	public void setSeconds(Long seconds) {
		this.seconds = seconds;
	}
	public Long getMilliseconds() {
		return milliseconds;
	}
	public void setMilliseconds(Long milliseconds) {
		this.milliseconds = milliseconds;
	}
	public Long getTicks() {
		return ticks;
	}
	public void setTicks(Long ticks) {
		this.ticks = ticks;
	}
	public Long getNanoseconds() {
		return nanoseconds;
	}
	public void setNanoseconds(Long nanoseconds) {
		this.nanoseconds = nanoseconds;
	}
 
}
