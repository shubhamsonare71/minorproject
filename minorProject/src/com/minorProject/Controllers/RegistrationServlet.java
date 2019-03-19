package com.minorProject.Controllers;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.imageio.stream.ImageInputStream;
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


@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RegistrationServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
	   
		String uname = request.getParameter("username");
		String pass = request.getParameter("password");
		String name = request.getParameter("name");
		String adds = request.getParameter("address");
		String mob = request.getParameter("mobile");
		String email = request.getParameter("email");
		
		
		if (uname != null && pass !=null && name != null && adds != null && mob != null && email != null) {
			
			   System.out.println("helloRegistrationServlet");
		       Users obj = new Users(uname,pass,name,adds,mob,email);
		       UserDao dc = new UserDao();
		       dc.create(obj);
		}
		int uid = UserDao. checkAvailablity(uname, pass);
		if (uid != -1) {
			HttpSession session = request.getSession();
			
			session.setAttribute("user name", uname);
			System.out.println(uname);
			session.setAttribute("password", pass);
			session.setAttribute("uid", uid);
		 response.sendRedirect("ExpenseCategory ");
	
        }
	}
}

