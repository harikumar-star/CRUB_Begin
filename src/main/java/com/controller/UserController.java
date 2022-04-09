package com.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.model.User;

public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String LIST_USER = "/home.jsp";
	private static String LIST_USER1 = "/update.jsp";
	List<User> users;
	UserDao dao;
	String forward = "";

	public UserController() {
		super();
		dao = new UserDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		System.out.println(action);

		if (action.equalsIgnoreCase("home")) {
			forward = LIST_USER;
			RequestDispatcher view = request.getRequestDispatcher(forward);

			List<User> users = dao.getAllUsers();
			System.out.println("Do get user----" + users);
			request.setAttribute("u", users);
			view.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String operation = request.getParameter("op");
	
		System.out.println("-------------"+operation);
		User user = new User();
		switch (operation) {
		case "Add":
			user.setName(request.getParameter("name"));
			user.setRollno(Integer.parseInt(request.getParameter("roll")));
			user.setLname(request.getParameter("lname"));
			dao.addUser(user);
			System.out.println(user.getLname() + user.getRollno() + user.getName());
		
		case "Updatechange": {
			
			System.out.println("Coming");
			user.setName(request.getParameter("name").trim());
			user.setRollno(Integer.parseInt(request.getParameter("roll").trim()));
			user.setLname(request.getParameter("lname").trim());
			System.out.println(user.getLname()+"checking------------");
			String stat = dao.updateUser(user);
			
			System.out.println("Status-----------"+stat);

			RequestDispatcher view = request.getRequestDispatcher("home.jsp");
			request.setAttribute("msg", stat);

			view.forward(request, response);
		}

		}

	}

}
