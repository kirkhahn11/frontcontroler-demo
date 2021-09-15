package com.whatever.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.whatever.dao.EmployeeDao;
import com.whatever.models.Employee;
import com.whatever.servicelayer.EmployeeService;

public class EmployeeServiceTest {

	private EmployeeDao mockdao;
	private EmployeeService eserv;
	
	@Before
	public void setUp() {
		mockdao = mock(EmployeeDao.class);
		eserv = new EmployeeService(mockdao);
	}
	
	
	@After
	public void teardown() {
		
		eserv = null;
		mockdao = null;
	}
	
	// Happy Path Scenario (everything works)
	@Test
	public void testConfirmLogin_success() {
		
		// need a fake db of employee objects
		Employee e1 = new Employee(3, "Scott", "Lang", "Antman", "bugs");
		Employee e2 = new Employee(4, "Steve", "Rogers", "Cap", "USAUSA");
		
		List<Employee> dummyDb = new ArrayList<>();
		dummyDb.add(e1);
		dummyDb.add(e2);
		
		when(mockdao.findAll()).thenReturn(dummyDb);
		
		// pass in expected, actual
		assertEquals(e2, eserv.confrimLogin("Cap", "USAUSA"));
	}
	
	@Test
	public void testFailConfirmLogin_returnNull() {
		Employee e1 = new Employee(3, "Scott", "Lang", "Antman", "bugs");
		Employee e2 = new Employee(4, "Steve", "Rogers", "Cap", "USAUSA");
		
		List<Employee> dummyDb = new ArrayList<>();
		dummyDb.add(e1);
		dummyDb.add(e2);
		
		when(mockdao.findAll()).thenReturn(dummyDb);
		
		assertNull(eserv.confrimLogin("Batman", "WrongPass"));
	}
	
	
	
}