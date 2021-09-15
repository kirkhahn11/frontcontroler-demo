package com.whatever.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.whatever.dao.EmployeeDao;
import com.whatever.models.Employee;
import com.whatever.servicelayer.EmployeeService;

public class RequestHelper {
	private static Logger log = Logger.getLogger(RequestHelper.class);
	public static EmployeeService eserv = new EmployeeService(new EmployeeDao());
	private static ObjectMapper om = new ObjectMapper();
	
	public static void processEmployees(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		
		// We need to get the list of all employees in the db (using Jackson Databind Object Mapper)
		List<Employee> emps = eserv.findAll();
		
		// then we need to parse the list of java objects to a JSON string
		String json = om.writeValueAsString(emps);
		
		// finally we will use a printwriter to write the objects to the response body seen in the browser
		PrintWriter out = response.getWriter();
		out.println(json);
	}
	
}
