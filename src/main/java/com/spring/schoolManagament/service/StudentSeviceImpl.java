package com.spring.schoolManagament.service;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.schoolManagament.entity.StudentEntity;
import com.spring.schoolManagament.repository.StudentRepository;

@Service
public class StudentSeviceImpl implements StudentService<StudentEntity, Long> {

	final static Comparator<StudentEntity> comparator = (StudentEntity s, StudentEntity t) -> s.getBirthDate()
			.compareTo(t.getBirthDate());

	@Autowired
	StudentRepository repo;

	public void setRepo(StudentRepository repo) {
		this.repo = repo;
	}

	public StudentEntity saveStudent(StudentEntity entity) {
		if (Objects.nonNull(entity))
			return repo.save(entity);
		else
			throw new RuntimeException("Student Not Found");
	}

	@Override
	public StudentEntity updateStudent(StudentEntity entity) {
		if (Objects.nonNull(entity))
			return repo.save(entity);
		else
			throw new RuntimeException("Student Not Found");

	}

	@Override
	public StudentEntity getById(long s_id) {
		StudentEntity entity = repo.findById(s_id).get();
		if (Objects.nonNull(entity))
			return entity;
		else
			throw new RuntimeException("Student Not Found");
	}

	@Override
	public List<StudentEntity> getAll() {
		return repo.findAll();
	}

	@Override
	public StudentEntity getByName(String name) {
		StudentEntity entity = repo.findByName(name);
		if (Objects.nonNull(entity))
			return entity;
		else
			throw new RuntimeException("Student Not Found");
	}

	@Override
	public StudentEntity getBysurnem(String surnem) {
		StudentEntity entity = repo.findBysurnem(surnem);
		if (Objects.nonNull(entity))
			return entity;
		else
			throw new RuntimeException("Student Not Found");
	}

	@Override
	public StudentEntity getBypinCode(int pinCode) {
		StudentEntity entity = repo.findBypinCode(pinCode);
		if (Objects.nonNull(entity))
			return entity;
		else
			throw new RuntimeException("Student Not Found");
	}

	@Override
	public List<StudentEntity> getStudentSortByBirthDate() {

		return repo.findAll()
				.stream()
				.sorted(comparator)
				.collect(Collectors.toList());
	}

}


