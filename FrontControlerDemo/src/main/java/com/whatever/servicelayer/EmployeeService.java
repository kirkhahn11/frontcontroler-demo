package com.whatever.servicelayer;

import java.util.List;
import java.util.Optional;

import com.whatever.dao.EmployeeDao;
import com.whatever.models.Employee;

public class EmployeeService {

	private EmployeeDao edao;
	
	// Dependency Injection via Constructor injection below
	public EmployeeService(EmployeeDao dao) {
		super();
		this.edao = dao;
	}
	
	// method: confirmLogin -> let's call the findAll() from the DAO, and use a stream to confirm the username and pwd
	public Employee confrimLogin(String username, String password) {
		
		// either returns the employee object or returns null
		Optional<Employee> emp = edao.findAll()
			.stream()
			.filter(e -> e.getUsername().equals(username) && e.getPassword().equals(password))
			.findFirst();
		
		return (emp.isPresent() ? emp.get() : null);
	}
	
	public int insert(Employee e) {
		return edao.insert(e);
	}
	
	public boolean update(Employee e) {
		return edao.update(e);
	}
	
	public boolean delete(Employee e) {
		return edao.delete(e);
	}
	
	public List<Employee> findAll() {
		return edao.findAll();
	}
}
