package com.minorProject.Controllers;

import java.io.IOException;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.mail.Session;
import javax.mail.internet.*;
import javax.activation.*;
import javax.mail.Transport;
@WebServlet("/SendMail")
public class SendMail extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public SendMail() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);    
		 
		  		}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		 System.out.println("yaha tk aa gya"); 
			String name = request.getParameter("name");
			System.out.println(name);
			  String Email = request.getParameter("email");
			  String body = request.getParameter("message");
		      String recipient = "shubham.sonare.71@gmail.com";
		 
		  //   MailApp.send(Email, recipient, body);
		
	}

}
