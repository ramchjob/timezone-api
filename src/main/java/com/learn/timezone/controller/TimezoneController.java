package com.learn.timezone.controller;

import com.learn.timezone.model.TimeZoneDetails;
import com.learn.timezone.service.TimeZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/timezone")
public class TimezoneController {

    @Autowired
    TimeZoneService service;


    @GetMapping("{timeZoneName}")
    public ResponseEntity<TimeZoneDetails> getTimeZoneDetails(@PathVariable  String timeZoneName) {
        TimeZoneDetails details = service.getTimeZoneDetails(timeZoneName);
        return ResponseEntity.ok(details);
    }

    @GetMapping
    public ResponseEntity<List<String>> getTimeZoneDetails() {
        List<String> details = service.getTimeZoneDetails();
        return ResponseEntity.ok(details);
    }

}
