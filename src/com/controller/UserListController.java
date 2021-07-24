package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.BankBean;
import com.dao.BankDao;

public class UserListController extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		BankDao bankDao = new BankDao();
		
		ArrayList<BankBean> users = bankDao.getAllUsers();
		request.setAttribute("users", users);
		request.getRequestDispatcher("ListUser.jsp").forward(request, response);
	}
}