package com.emp.payroll.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emp.payroll.model.Employee;
import com.emp.payroll.repository.AdminRepository;

@Repository
@CrossOrigin(origins ="*")
@RestController
@RequestMapping("/api/v1/")
public class AdminController {

	@Autowired
	private AdminRepository adminrepository;
	
	@GetMapping("/admins")
	public List<Employee> getAllEmployee()
	{
		return adminrepository.findAll();
	}
	
	@PostMapping("/admins")
	public Employee createEmployee(@RequestBody Employee employee) 
	{
		return adminrepository.save(employee);
	}
	
	@GetMapping("/{empId}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable int empId)
	{
		Employee employee = adminrepository.findById((int) empId).orElseThrow();
		return ResponseEntity.ok(employee);
		//return "redirect:/admin/{empId}"; 
	}
	
	@PutMapping("/{empId}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable int empId, @RequestBody(required=false) Employee admin1)
	{
		Employee employee = adminrepository.findById((int) empId).orElseThrow();

		employee.setEmpId(admin1.getEmpId());
		employee.setfName(admin1.getfName());
		employee.setlName(admin1.getlName());
		employee.setDob(admin1.getDob());
		employee.setGender(admin1.getGender());
		employee.setStreet(admin1.getStreet());
		employee.setLocation(admin1.getLocation());
		employee.setCity(admin1.getCity());
		employee.setState(admin1.getState());
		employee.setPincode(admin1.getPincode());
		employee.setMobNo(admin1.getMobNo());
		employee.setEmailId(admin1.getEmailId());
		employee.setPassword(admin1.getPassword());
		employee.setdesignation(admin1.getdesignation());
		
		Employee updatedEmployee = adminrepository.save(employee);
		return ResponseEntity.ok(updatedEmployee);
	}	
	
		@DeleteMapping("/{empId}")
		public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable int empId)
		{
			Employee employee = adminrepository.findById((int) empId).orElseThrow();
			
			adminrepository.delete(employee);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}
	}
