package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.Cookie;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.BankBean;
import com.dao.BankDao;

public class LoginUserController extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		BankDao bankDao = new BankDao();
		bankDao.authenticate(email, password);
		BankBean users = bankDao.authenticate(email, password);
		
		RequestDispatcher rd;
		if(users == null) {
			request.setAttribute("error", "Invalid Credentials");
			rd = request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);
		}
		else {
			Cookie firstName = new Cookie("firstName", users.getFirstName() + "");
			Cookie acc_no = new Cookie("userId", users.getAcc_no() + "");
			
			response.addCookie(acc_no);
			response.addCookie(firstName);
			String url = "";
			response.encodeURL(url);
			
			response.sendRedirect(url);
		}
	}
}
