package com.spring.schoolManagament.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface StudentService<StudentEntity, ID> {

	public StudentEntity saveStudent(StudentEntity entity);

	public StudentEntity updateStudent(StudentEntity entity);

	public StudentEntity getById(long s_id);

	public List<StudentEntity> getAll();

	public StudentEntity getByName(String name);

	public StudentEntity getBysurnem(String surnem);

	public StudentEntity getBypinCode(int pinCode);

}
