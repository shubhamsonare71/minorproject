package com.minorProject.Controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.minorProject.SendMail.OTPgeneration;
import com.minorProject.SendMail.sendMail;

@WebServlet("/ForgotPassController")
public class ForgotPassController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ForgotPassController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                                  
                               	PrintWriter out = response.getWriter();
                               
		                           String email =  request.getParameter("email");
		                           HttpSession sess = request.getSession();
		                           sess.setAttribute("email", email);
                                   String v=sendMail.Mail(email);
                                   sess.setAttribute("Otp", v);
                                   sess.setMaxInactiveInterval(2*60);
                                   System.out.println(v);
                                   if(v!=null)
                                   response.sendRedirect("EnterOTP");
                                                                   
                                   
                                   
	}

}
