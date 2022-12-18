package com.emp.payroll.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.payroll.model.Admin;
import com.emp.payroll.repository.AdminRegistrationRepository;

@Service
public class AdminRegistrationService {

	@Autowired
	private AdminRegistrationRepository repo;
	
	public Admin saveUser(Admin adm){
		return repo.save(adm);
		}
	public Admin fetchAdmByEmailId(String email)
	{
		return repo.findByEmailId(email);
	}

	public Admin fetchAdmByEmailIdandPassword(String email, String password)
	{
		return repo.findByEmailIdAndPassword(email, password);
	}

}
