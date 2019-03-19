package com.minorProject.Controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import com.minorProject.Daos.UserDao;

@WebServlet("/changepass")
public class changepass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public changepass() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	                             String OTP = request.getParameter("OTP");
	                           
	                             String newpass  = request.getParameter("pass");
	                             
	                             HttpSession sess = request.getSession(); 
	                            if(sess == null)
	                            {
	                            	System.out.println("Session Timeout");
	                            }
	                             String s=(String)sess.getAttribute("Otp");
	                             String email = (String)sess.getAttribute("email");
	                            
	                             if(OTP.equals(s))
	                             {
                                       boolean b = UserDao.changePass(newpass,email);
                                       if(b==true)
                                       {
                                    	      System.out.println("password Succesfully changed");
                                    	      response.sendRedirect("Loginform2");
                                       }
                                       else
                                       {
                                    	   System.out.println("password not changed");
                             	      response.sendRedirect("Loginform2");
                                       }
	                             }
	                             else
	                            	 System.out.println("Plz enter valid OTP");
	}

}
