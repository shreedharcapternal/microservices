package com.example.microservices.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.microservices.entity.Department;
import com.example.microservices.repository.DepartmentRepo;

@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentRepo departmentRepo;

	public Department saveDepartment(Department department) {
		return departmentRepo.save(department);
	}

	public Department findDepartmentById(Long departmentId) {
		return departmentRepo.findById(departmentId).get();
	}
}
