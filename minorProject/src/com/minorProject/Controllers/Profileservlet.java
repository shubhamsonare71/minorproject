package com.minorProject.Controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.minorProject.Daos.UserDao;
import com.minorProject.pojos.Users;
import com.mysql.jdbc.Blob;

/**
 * Servlet implementation class Profileservlet
 */
@WebServlet("/Profileservlet")
public class Profileservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Profileservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("username");
		String pass = request.getParameter("password");
		String name = request.getParameter("name");
		String adds = request.getParameter("address");
		String mob = request.getParameter("mobile");
		String email = request.getParameter("email");
		
		HttpSession session = request.getSession();
		int uid =(int) session.getAttribute("uid");
		
		Users u; 
		u = new Users(uid, uname, pass, name, adds, mob, email);
		UserDao ud = new UserDao();
		if(uname == null) {
			u = ud.find(uid);
			} else {
				ud.edit(u);
			}
		session.setAttribute("userpro", u);
		response.sendRedirect("Profile");
	}

	}


