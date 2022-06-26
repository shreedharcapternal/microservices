package com.example.microservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.microservices.entity.Department;

@Repository
public interface DepartmentRepo extends JpaRepository<Department,Long> {
		
}
