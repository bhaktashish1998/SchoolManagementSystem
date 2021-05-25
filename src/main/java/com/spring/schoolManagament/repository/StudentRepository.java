package com.spring.schoolManagament.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.schoolManagament.entity.StudentEntity;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

	StudentEntity findByName(String name);

	StudentEntity findBysurnem(String surnem);

	StudentEntity findBypinCode(int pinCode);

}
