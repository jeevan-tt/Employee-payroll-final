package com.emp.payroll;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.emp.payroll.model.Salary;
import com.emp.payroll.repository.SalaryRepository;



@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class SalaryTest {
	
	@Autowired
	SalaryRepository repo;
	
	@Test
	@Order(1)
	public void TestCreate() {
		Salary s = new Salary();
		s.setSalId(2);
		s.setEmpId(100);
		s.setPfAmount(233.21);
		s.setTranDate("12/11/2001");
		s.setBasicPay(231.33);
		s.setDa(23.23);
		s.setHra(233.32);
	    s.setGrossSalary(85444.3);
	    s.setTax(232.32);
	    s.setDeduction(3432.333);
		s.setNetPay(655446.43);
		
		
		repo.save(s);
		assertNotNull(repo.findById(1).get());
		
}
	
	
	private void assertNotNull(Salary salary) {
		// TODO Auto-generated method stub
		
	}
	
@Test
	@Order(2)
	public void TestReadAll() {
	List<Salary> list = repo.findAll();
	assertThat(list).size().isGreaterThan(0);
	
	}
	@Test
	@Order(3)
	public void TestSingleSalary() {
	
     Salary salary = repo.findById(1).get();
     assertEquals(1, salary.getEmpId());
	}
	
	@Test
	@Order(4)
	public void TestUpdate() {
	Salary s = repo.findById(1).get();
		s.setEmpId(143);;
		repo.save(s);
		assertNotEquals(3, repo.findById(1).get().getEmpId());
	}
	@Test
	@Order(5)
	public void Testdelete() {
		repo.deleteById(2);
		assertThat(repo.existsById(2)).isFalse();
		
	}
	
	
		
		
	private void assertNotEquals(int i, int empId) {
		// TODO Auto-generated method stub
		
	}

	private void assertEquals(int i, int j) {
		// TODO Auto-generated method stub
		
	}

}

	
	
		