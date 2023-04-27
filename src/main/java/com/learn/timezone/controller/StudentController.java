package com.learn.timezone.controller;

import com.learn.timezone.entity.Student;
import com.learn.timezone.model.TimeZoneDetails;
import com.learn.timezone.service.StudentService;
import com.learn.timezone.service.TimeZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService service;


    @GetMapping("{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable  Integer id) {
    	Student details = service.getStudentById(id);
        return ResponseEntity.ok(details);
    }
    
    @PostMapping
    public ResponseEntity<Student> getStudentById(@RequestBody  Student student) {
    	Student details = service.createStudent(student);
        return ResponseEntity.ok(details);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getStudents() {
        List<Student> details = service.getStudents();
        return ResponseEntity.ok(details);
    }

}
