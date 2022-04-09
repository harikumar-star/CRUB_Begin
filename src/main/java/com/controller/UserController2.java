package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.model.User;

/**
 * Servlet implementation class UserController2
 */
public class UserController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UserDao dao;
	

	public UserController2() {
		super();
		// TODO Auto-generated constructor stub
		dao = new UserDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// <a href="UserController2?b=<%=b%> & op=<%=status%>">Update</a>

		String op = request.getParameter("op");
		String b = request.getParameter("b");

		int c = Integer.parseInt(b);
		System.out.println(op + "" + b);

		if (op.equalsIgnoreCase("update")) {
			User u = new User();
			u = dao.getUserById(c);
			System.out.println(u);
			RequestDispatcher view = request.getRequestDispatcher("update.jsp");
			request.setAttribute("u", u);
			view.forward(request, response);

		}
		else
		{
			String u ;
			u = dao.deleteUser(c);
			System.out.println("DELETE MSG-------"+u);
			RequestDispatcher view = request.getRequestDispatcher("home.jsp");
			request.setAttribute("msg", u);
			view.forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
