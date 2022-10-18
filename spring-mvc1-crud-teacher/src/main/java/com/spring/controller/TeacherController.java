package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.spring.dto.Teacher;
import com.spring.service.TeacherService;

@RestController
public class TeacherController {
	@Autowired
	TeacherService ts;
	
	@RequestMapping("/loadTeacher")
	public ModelAndView loadTeacher(Teacher teacher) 
	{
		ModelAndView andView = new ModelAndView("register.jsp");
		andView.addObject("teacher", new Teacher());
		return andView ;
	}
	@RequestMapping("/saveTeacher")
	public ModelAndView saveTeacher(Teacher teacher) {
		ModelAndView addView = new ModelAndView("loadTeacher");
		ts.saveTeacher(teacher);
		return addView.addObject("msg","data inserted successfully");
		
	}
	@RequestMapping("/getAllData")
	public ModelAndView getAllData() {
		ModelAndView andView = new ModelAndView("display.jsp");
		List<Teacher> teacher = ts.getAllData();
		return andView.addObject("getTeacher",teacher);
	}
	@RequestMapping("/deleteData")
	public ModelAndView deleteData(@RequestParam int id) {
		ModelAndView andView = new ModelAndView("getAllData");
		ts.deleteById(id);
		return andView;
		
	}
	@RequestMapping("/editTeacher")
	public ModelAndView editTeacher(@RequestParam int id) {
		ModelAndView andView = new ModelAndView("editTeacher.jsp");
		return andView.addObject("editTeach",ts.getById(id));
		
	}
	@RequestMapping("/updateTeacher")
	public ModelAndView updateTeacher(@ModelAttribute Teacher teacher) {
		ModelAndView andView = new ModelAndView("getAllData");
		ts.updateTeacher(teacher);
		return andView;
		
	}

}
