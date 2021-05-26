package com.spring.schoolManagament.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.schoolManagament.entity.StudentEntity;
import com.spring.schoolManagament.service.StudentService;

@RestController
@RequestMapping(value = "/student", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
		MediaType.APPLICATION_JSON_VALUE })
public class StudentController {

	@Autowired
	StudentService<StudentEntity, Long> service;

	@GetMapping
	public List<StudentEntity> getAllStudent() {
		return service.getAll();
	}

	@PostMapping("/save")
	public StudentEntity saveStudent(@RequestBody StudentEntity entity) {
		return service.saveStudent(entity);
	}

	@PutMapping("update")
	public StudentEntity updateStudent(@RequestBody StudentEntity entity) {
		return service.updateStudent(entity);
	}

	@GetMapping("s_id/{s_id}")
	public StudentEntity findByIdStudent(@PathVariable("s_id") int s_id) {
		return service.getById(s_id);
	}

	@GetMapping("surnem/{surnem}")
	public StudentEntity findBySurNameStudent(@PathVariable("surnem") String surnem) {
		return service.getBysurnem(surnem);
	}

	@GetMapping("name/{name}")
	public StudentEntity getStudentByName(@PathVariable("name") String name) {
		return service.getByName(name);
	}

	@GetMapping("pinCode/{pinCode}")
	public StudentEntity getStudentByPin(@PathVariable("pinCode") int pinCode) {
		return service.getBypinCode(pinCode);
	}
	@GetMapping("sort")
	public List<StudentEntity> getSortStudentsByBirthDate() {
		return service.getStudentSortByBirthDate();
	}
}
