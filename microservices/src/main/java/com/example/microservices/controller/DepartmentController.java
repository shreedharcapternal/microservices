package com.example.microservices.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservices.entity.Department;
import com.example.microservices.service.DepartmentService;


//@RestController
//@RequestMapping("/departments")
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	
	@Autowired
	private Environment environment;
	
	@PostMapping("/save")
	public Department saveDepartment(@RequestBody Department department) {
		System.out.println(department.toString());
		return departmentService.saveDepartment(department);
	}
	
	@GetMapping("/{id}")
	public Department findDepartmentById(@PathVariable("id") Long id) {
		System.out.println(id);
		
		return departmentService.findDepartmentById(id);
	}
	
	@GetMapping("/version")
	public ResponseEntity<String> getversion() {
		String version = environment.getProperty("versionNo");
		
		return ResponseEntity.ok(version);
	}
	 
	
	
	
}
