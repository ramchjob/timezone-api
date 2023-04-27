package com.learn.timezone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.timezone.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	 
}