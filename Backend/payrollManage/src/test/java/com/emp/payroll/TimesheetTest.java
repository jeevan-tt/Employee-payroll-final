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

import com.emp.payroll.model.Timesheet;
import com.emp.payroll.repository.TimesheetRepository;


@SpringBootTest
class AdmintimesheetApplicationTests {

	@Autowired
	TimesheetRepository tRepo;

	@Test
	@Order(1)
	public void testcreate() {
		Timesheet t = new Timesheet();
		t.setEmpId(4);
		t.setDate("4-03-2022");
		t.setInTime("9am");
		t.setBreakTime("1pm");
		t.setOutTime("6pm");
		t.setRegularTime("8");
		t.setOvertimeHours("2");
		t.setTotalHours("10");
		tRepo.save(t);
		assertNotNull(tRepo.findById(4).get());

	}

	@Test
	@Order(2)
	public void testReadAll() {
		List<Timesheet> list = (List<Timesheet>) tRepo.findAll();
		assertThat(list).size().isGreaterThan(0);

	}

	@Test
	@Order(4)
	public void testSingleProduct() {
		Timesheet timesheet = tRepo.findById(4).get();
		assertEquals("1pm", timesheet.getBreakTime());
	}

	@Test
	@Order(3)
	public void testUpdate() {
		Timesheet a = tRepo.findById(3).get();
		a.setBreakTime("2");
		tRepo.save(a);
		assertNotEquals("1pm", tRepo.findById(3).get().getBreakTime());
	}

	@Test
	@Order(5)
	public void testDelete() {
		tRepo.deleteById(4);
		assertThat(tRepo.existsById(4)).isFalse();
	}
}