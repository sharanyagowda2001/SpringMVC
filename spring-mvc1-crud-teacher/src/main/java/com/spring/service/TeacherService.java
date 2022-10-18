package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.dao.TeacherDao;
import com.spring.dto.Teacher;
@Component
public class TeacherService {
	@Autowired
TeacherDao dao ;
	public Teacher saveTeacher(Teacher teacher) {
		return dao.saveTeacher(teacher);
		
	}
	public List<Teacher> getAllData() {
		return dao.getAllData();
	}
	public Teacher getById(int id) {
		return dao.getById(id);
	}
	public Teacher deleteById(int id) {
		return dao.deleteById(id);
	}
	public Teacher updateTeacher(Teacher teacher) {
		return dao.updateTeacher(teacher);
	}
}
