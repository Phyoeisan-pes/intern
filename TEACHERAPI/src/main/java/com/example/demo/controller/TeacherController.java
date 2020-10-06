package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Teacher;
import com.example.demo.service.TeacherService;

@RestController

public class TeacherController {
	
	@Autowired
	TeacherService teacherService;
	
	@GetMapping ( value="/teacher")
	public List<Teacher> getTeacher(){
		return teacherService.getTeacher();
		
	}
	
	@PostMapping (value="/teacher")
	public Teacher addTeacher(@RequestBody Teacher teacher)
	{
		return teacherService.addTeacher(teacher);
	}
	
	@GetMapping (value="/teacher/{id}")
	public Teacher getById(@PathVariable Long id)
	{
		return teacherService.findById(id);
	}
	
	@DeleteMapping (value="/teacher/{id}")
	public void deleteById(@PathVariable Long id)
	{
		teacherService.deleteTeacher(id);
	}
	
	@GetMapping(value="/teacher/search")
	public List<Teacher> searchTeacher(String name,String phone,String address){
		return teacherService.searchTeacher(name,phone,address);
	}
	
	

	

}
