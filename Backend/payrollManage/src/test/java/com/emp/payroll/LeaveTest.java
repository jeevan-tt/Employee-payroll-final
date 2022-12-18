package com.emp.payroll;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;

import com.emp.payroll.model.Leave;
import com.emp.payroll.repository.LeaveRepository;


@SpringBootTest
class LeavesApplicationTests {
	@Autowired
	LeaveRepository leRepo;

	@Test
	@Order(1)
	public void testcreate() {
		Leave le = new Leave();
		le.setEmpId(5L);
		le.setLeavetype("sick leave");
		le.setStartdate("2022-02-03");
		le.setEnddate("2022-02-03");
		le.setDuration("full day");
		leRepo.save(le);
		assertNotNull(leRepo.findById(5L).get());

	}

	@Test
	@Order(2)
	public void testReadAll() {
		List<Leave> list = leRepo.findAll();
		assertThat(list).size().isGreaterThan(0);

	}

	@Test
	@Order(3)
	public void testSingleProduct() {
		Leave leave = leRepo.findById(5L).get();
		assertEquals("sick leave", leave.getLeavetype());
	}

	@Test
	@Order(4)
	public void testUpdate() {
		Leave le = leRepo.findById(6L).get();
		le.setLeavetype("casual leave");
		leRepo.save(le);
		assertNotEquals("sick leave", leRepo.findById(6L).get().getLeavetype());
	}

	@Test
	@Order(5)
	public void testDelete() {
		leRepo.deleteById(5L);
		assertThat(leRepo.existsById(5L)).isFalse();
	}
}