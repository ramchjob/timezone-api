package com.learn.timezone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.timezone.entity.Student;
import com.learn.timezone.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    StudentRepository  repository;

	public Student getStudentById(Integer id) {
		return repository.findById(id).get();
	}

	public List<Student> getStudents() {
		return repository.findAll();
	}

	public Student createStudent(Student student) {
		return repository.save(student);
	}
    
    
}
