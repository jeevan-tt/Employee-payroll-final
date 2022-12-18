package com.emp.payroll.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emp.payroll.model.Employee;
import com.emp.payroll.repository.EmpRepository;

@Repository
@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/v2/")
public class EmpController {

	@Autowired
	private EmpRepository emprepository;
	
	@GetMapping("/{empId}")
	public Optional<Employee> getEmployeeById(@PathVariable int empId)
	{
		//Employee employee = emprepository.findById(empId);
		
//		System.out.println(employee);
//		System.out.println(emprepository);

		//return (ResponseEntity<Employee>) emprepository.findByEmailId(empId);
		System.out.println(emprepository.findById(empId));
		return emprepository.findById(empId);
		
		//return "redirect:/admin/{empId}"; 
	}
	
//	@PutMapping("/employee/{emailId}")
//	public ResponseEntity<Employee> updateEmployee(@PathVariable int empId, @RequestBody(required=false) Employee admin1)
//	{
//		Employee employee = emprepository.findById(empId);
//
//		employee.setEmpId(admin1.getEmpId());
//		employee.setfName(admin1.getfName());
//		employee.setlName(admin1.getlName());
//		employee.setDob(admin1.getDob());
//		employee.setGender(admin1.getGender());
//		employee.setStreet(admin1.getStreet());
//		employee.setLocation(admin1.getLocation());
//		employee.setCity(admin1.getCity());
//		employee.setState(admin1.getState());
//		employee.setPincode(admin1.getPincode());
//		employee.setMobNo(admin1.getMobNo());
//		employee.setEmailId(admin1.getEmailId());
//		employee.setPassword(admin1.getPassword());
//		employee.setdesignation(admin1.getdesignation());
//		
//		Employee updatedEmployee = emprepository.save(employee);
//		
//		return ResponseEntity.ok(updatedEmployee);
//	}	
	
		
	}
