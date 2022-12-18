package com.emp.payroll.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emp.payroll.model.Admin;
import com.emp.payroll.service.AdminRegistrationService;

@RestController
public class AdminRegistrationController {
	@Autowired
	private AdminRegistrationService service;
	
	@PostMapping("/register")
	@CrossOrigin(origins ="*")
	public Admin registerAdmin(@RequestBody Admin adm) throws Exception{
		String tempEmailId = adm.getEmailId();
		if(tempEmailId != null && !"".equals(tempEmailId))
		{
			Admin empobj = service.fetchAdmByEmailId(tempEmailId);
			if(empobj != null)
			{
				throw new Exception("Admin with "+tempEmailId+" is already exists");
			}
			
		}
		Admin admObj=null;
		admObj = service.saveUser(adm);
		return admObj;
	}
	@PostMapping("/login")
	@CrossOrigin(origins ="*")
	public Admin loginadm(@RequestBody Admin adm) throws Exception {
		String tempEmailId = adm.getEmailId();
		String tempPass=adm.getPassword();
		Admin admObj = null;
		if(tempEmailId != null && tempPass != null ) {
			admObj = service.fetchAdmByEmailIdandPassword(tempEmailId, tempPass);
			
		}
		if(admObj ==null) {
			throw new Exception("Bad  Credentials");
		}
			
		return admObj;

	}
}