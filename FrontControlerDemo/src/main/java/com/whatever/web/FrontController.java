package com.whatever.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. save the URI and rewrite it to determine what functionality the user is requesting
		final String URI = request.getRequestURI().replace("/FrontControllerDemo/", "");
		
		switch(URI) {
//		case "login": 
//			// call a method.... from Request Helper 
//			
		case "employees":
			RequestHelper.processEmployees(request, response);
			
		
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
