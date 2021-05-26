package com.spring.schoolManagament.service;

import java.util.Date;
import java.util.Comparator;

import com.spring.schoolManagament.entity.StudentEntity;

public class SortByDate implements Comparator<StudentEntity> {

	@Override
	public int compare(StudentEntity o1, StudentEntity o2) {
		Date d1=(Date) o1.getBirthDate();
		Date d2=(Date) o2.getBirthDate();
		return d1.compareTo(d2);
	}

}
