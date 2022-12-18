package com.emp.payroll.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

import com.emp.payroll.model.Employee;

public interface EmpRepository extends JpaRepository<Employee, Integer>{

}
