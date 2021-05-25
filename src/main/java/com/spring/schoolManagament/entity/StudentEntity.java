package com.spring.schoolManagament.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.validation.annotation.Validated;

@Entity
@Validated
public class StudentEntity {
	@Id
	private long s_Id;
	@NotEmpty(message = "Field Shuld not emply")
	@NotNull(message = "Field Shuld not be null")
	private String name;
	@NotEmpty(message = "Field Shuld not emply")
	@NotNull(message = "Field Shuld not be null")
	private String surnem;
	@Past(message = "Date Shuld be past")
	private Date birthDate;
	@Future(message = "Date Shuld be Future")
	private Date joiningDate;
	private int pinCode;

	public StudentEntity() {
		super();
	}

	public StudentEntity(long s_Id, String name, String surnem, Date birthDate, Date joiningDate, int pinCode) {
		super();
		this.s_Id = s_Id;
		this.name = name;
		this.surnem = surnem;
		this.birthDate = birthDate;
		this.joiningDate = joiningDate;
		this.pinCode = pinCode;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	public void setS_Id(long s_Id) {
		this.s_Id = s_Id;
	}

	public long getS_Id() {
		return s_Id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurnem() {
		return surnem;
	}

	public void setSurnem(String surnem) {
		this.surnem = surnem;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	@Override
	public String toString() {
		return "StudentEntity [s_Id=" + s_Id + ", name=" + name + ", surnem=" + surnem + ", birthDate=" + birthDate
				+ ", joiningDate=" + joiningDate + ", pinCode=" + pinCode + "]";
	}

}
