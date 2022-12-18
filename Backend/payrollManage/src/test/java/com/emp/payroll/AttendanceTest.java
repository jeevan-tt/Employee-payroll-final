package com.emp.payroll;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

//import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.emp.payroll.model.Attendance;
import com.emp.payroll.repository.AttendanceRepository;

//import com.Attendance .spring.model.Schedule;
//import com.emp.leave.model.Leave;


@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class AttendanceApplicationTests {

	@Autowired
	AttendanceRepository aRepo;
		@Test
		@Order(1)
			public void testCreate ()
			{
			Attendance a=new Attendance();
		//a.setEmpId(10800);
		a.setDate("2022-03-09");
		a.setStatus("present");
		assertNotNull(aRepo.findById((long) 10800).get());
			
			}
		@Test
		@Order(2)
		public void testRead () {
			Attendance attendance = aRepo.findById(10800L).get();
			assertEquals("present", attendance.getStatus());
		}
		private void assertEquals(String string, String duration) {
			// TODO Auto-generated method stub
			
		}
		@Test
		@Order(3)
		public void testReadAll () {
			List list = aRepo.findAll();
			assertThat(list).size().isGreaterThan(0);
		}
		
		@Test
		@Order(4)
		public void testUpdate () {
			Attendance  a = aRepo.findById(10801L).get();
			a.setDate("2022-03-04");
			aRepo.save(a);
			assertNotEquals(4/3/2022, aRepo.findById(10801L).get().getDate());
		}

		
		@Test
		@Order(5)
		public void testDelete () {
			aRepo.deleteById(10800L);
			assertThat(aRepo.existsById(10800L)).isFalse();
		}


		private void assertNotNull(Attendance attendance) {
			// TODO Auto-generated method stub
			
		}
}
