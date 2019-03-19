package com.minorProject.Controllers;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.minorProject.Daos.UserDao;
import com.minorProject.pojos.Users;


/**
 * Servlet implementation class LoginServlet
 */
@MultipartConfig(maxFileSize=16177216)
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd= null;
		String uname = request.getParameter("username");
		String pass = request.getParameter("password");
		
		if (uname == null && pass == null)
			response.sendRedirect("Loginform2");
		int uid = UserDao. checkAvailablity(uname, pass);
		if (uid != -1) {
			HttpSession session = request.getSession();
			
			session.setAttribute("user name", uname);
			
			session.setAttribute("password", pass);
			session.setAttribute("uid", uid);
			          response.sendRedirect("ExpcatController");
			System.out.println("login success");
		} else {
			      response.sendRedirect("Loginform2");
		}
	}

}
