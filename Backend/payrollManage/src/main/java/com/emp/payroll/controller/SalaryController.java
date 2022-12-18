package com.emp.payroll.controller;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

import com.emp.payroll.model.Leave;
import com.emp.payroll.model.Salary;
import com.emp.payroll.repository.SalaryRepository;
import com.emp.payroll.service.SalaryServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RequestMapping("/api/v7/")
@RestController
public class SalaryController {
	@Autowired
	private SalaryServices service;
	private SalaryRepository salaryrepo;
	
	@GetMapping("/{id}")
	public Optional<Salary> getEmployeeById(@PathVariable int id)
	{
		
		//System.out.println(salaryrepo.findById(empId));
		return service.fetchSalarybyId(id);
	}
	
	
	@GetMapping("/salaries")
	public List<Salary> fetchSalaryList()
	{
		List<Salary> salary = new ArrayList<Salary>();
		//fetch salary
		salary = service.fetchSalaryList();
		return salary;
	}
	
	@PostMapping("/salaries")
	public Salary saveSalary(@RequestBody Salary salary){
		return service.saveSalaryDb(salary);
		
		
	}
	
	@PostMapping("/editsalaries")
	@CrossOrigin(origins = "http://localhost:4200")
	public Salary editSalary(@RequestBody Salary salary){
		return service.saveSalaryDb(salary);
		
		
	}
	
	@GetMapping("/salaries/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public Salary fetchSalaryById(@PathVariable int id)
	{
		return service.fetchSalarybyId(id).get();
		
	}
	
	@DeleteMapping("/salaries/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public String deleteSalById(@PathVariable int id){
		return service.deleteSalById(id);
		
		
	}
	
	@GetMapping("/empid/{empId}")
	public Optional<Salary> getEmployeeByempId(@PathVariable int empId)
	{
		
		//System.out.println(salaryrepo.findById(empId));
		return service.fetchSalarybyempId(empId);
	}
	
}

