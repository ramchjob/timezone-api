package com.learn.timezone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.timezone.entity.Student;
import com.learn.timezone.service.StudentService;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {

    @Autowired
    StudentService service;


    @GetMapping("{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable  Integer id) {
    	Student details = service.getStudentById(id);
        return ResponseEntity.ok(details);
    }
    
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteStudnetById(@PathVariable  Integer id) {
    	service.deleteById(id);
        return ResponseEntity.ok().build();
    }
    
    @PostMapping
    public ResponseEntity<Student> getStudentById(@RequestBody  Student student) {
    	Student details = service.createStudent(student);
        return ResponseEntity.ok(details);
    }
    
    @PutMapping("{id}")
    public ResponseEntity<Student> updateStudent(@RequestBody  Student student, @PathVariable  Integer id) {
    	Student details = service.updateStudent(student, id);
        return ResponseEntity.ok(details);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getStudents() {
        List<Student> details = service.getStudents();
        return ResponseEntity.ok(details);
    }

}
