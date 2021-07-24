package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bean.BankBean;
import com.dao.BankDao;

public class AddUserController extends HttpServlet{
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		BankBean bank = new BankBean();
		bank.setFirstName(first_name);
		bank.setLastName(last_name);
		bank.setEmail(email);
		bank.setPassword(password);
	
		BankDao bankDao = new BankDao();
		bankDao.insertUpdate(bank);
				
		response.sendRedirect("UserListController");
	}
}
