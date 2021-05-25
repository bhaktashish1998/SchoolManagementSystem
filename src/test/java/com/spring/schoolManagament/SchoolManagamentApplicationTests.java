package com.spring.schoolManagament;

import static org.junit.Assert.assertNotNull;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.easymock.EasyMock;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.schoolManagament.entity.StudentEntity;
import com.spring.schoolManagament.repository.StudentRepository;
import com.spring.schoolManagament.service.StudentSeviceImpl;

@SpringBootTest
class SchoolManagamentApplicationTests {
	private static StudentEntity entity = new StudentEntity();
	private static StudentRepository proxy = EasyMock.createMock(StudentRepository.class);
	private static StudentSeviceImpl service = new StudentSeviceImpl();
	StudentEntity entity1;

	@Test
	public void testGetAllStudent() throws ParseException {
		ArrayList<StudentEntity> list = new ArrayList<StudentEntity>();
		entity.setName("Ashish");
		DateFormat format = new SimpleDateFormat("DD/MM/YYYY");

		entity.setBirthDate(format.parse("15/12/1998"));
		entity.setJoiningDate(format.parse("15/12/2000"));
		entity.setS_Id(101);
		entity.setSurnem("Bhakt");
		entity.setPinCode(414603);
		list.add(entity);
		EasyMock.expect(proxy.findAll()).andReturn(list);
		EasyMock.replay(proxy);
		service.setRepo(proxy);
		List<StudentEntity> entity1 = service.getAll();
		assertNotNull(entity1);
	}

	@Test
	public void testUpdateStudent() throws ParseException {
		// ArrayList<StudentEntity> list = new ArrayList<StudentEntity>();
		StudentEntity entity = new StudentEntity();
		entity.setName("Anjali");
		DateFormat format = new SimpleDateFormat("DD/MM/YYYY");
		Date d = new Date();
		entity.setBirthDate(format.parse("15/12/1998"));
		entity.setJoiningDate(format.parse("10/2/2021"));
		entity.setS_Id(101);
		entity.setSurnem("Bhakt");
		entity.setPinCode(414603);
		// list.add(entity);
		StudentRepository proxy = EasyMock.createMock(StudentRepository.class);
		EasyMock.expect(proxy.save(entity)).andReturn(entity);
		EasyMock.replay(proxy);
		StudentSeviceImpl service = new StudentSeviceImpl();
		service.setRepo(proxy);
		StudentEntity entity1 = service.updateStudent(entity);
		assertNotNull(entity1);
	}

	@Test
	public void testGetByIdStudent() throws ParseException {
		StudentEntity entity = new StudentEntity();
		entity.setName("Ashish");
		entity.setSurnem("Bhakt");
		DateFormat format = new SimpleDateFormat("DD/MM/YYY");
		entity.setBirthDate(format.parse("15/12/1998"));
		entity.setJoiningDate(format.parse("12/12/2022"));
		entity.setPinCode(414603);
		entity.setS_Id(101l);
		StudentRepository proxy = EasyMock.createMock(StudentRepository.class);
		EasyMock.expect(proxy.findById(101l)).andReturn(Optional.of(entity));
		EasyMock.replay(proxy);
		StudentSeviceImpl service = new StudentSeviceImpl();
		service.setRepo(proxy);
		StudentEntity entity1 = service.getById(101l);
		assertNotNull(entity1);

	}

	@Test
	public void testFindByNameStudent() throws ParseException {

		entity.setName("Ashish");
		entity.setSurnem("Bhakt");
		entity.setS_Id(101l);
		DateFormat format = new SimpleDateFormat("DD/MM/YYYY");
		entity.setBirthDate(format.parse("15/12/1998"));
		entity.setJoiningDate(format.parse("15/12/2021"));
		entity.setPinCode(414603);
		StudentRepository proxy = EasyMock.createMock(StudentRepository.class);
		EasyMock.expect(proxy.findByName("Ashish")).andReturn(entity);
		EasyMock.replay(proxy);
		StudentSeviceImpl service = new StudentSeviceImpl();
		service.setRepo(proxy);
		StudentEntity entity1 = service.getByName("Ashish");
		assertNotNull(entity1);

	}

	@Test
	public void testGetStudentByPinCode() throws ParseException {
		entity.setName("Ashish");
		entity.setSurnem("Bhakt");
		entity.setS_Id(101l);
		DateFormat format = new SimpleDateFormat("DD/MM/YYYY");
		entity.setBirthDate(format.parse("15/12/1998"));
		entity.setJoiningDate(format.parse("15/12/2021"));
		entity.setPinCode(414603);

		EasyMock.expect(proxy.findBypinCode(414603)).andReturn(entity);
		EasyMock.replay(proxy);
		service.setRepo(proxy);
		entity1 = service.getBypinCode(414603);

	}

}