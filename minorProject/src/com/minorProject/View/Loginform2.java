
package com.minorProject.View;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Loginform2")
public class Loginform2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Loginform2() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		RequestDispatcher rd = null;
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"en\">");
		out.println("<head>");
		out.println("<title>Accounting</title>");
		out.println("<meta charset=\"utf-8\">");
		out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
		out.println(
				"<link rel=\"stylesheet\" type=\"text/css\" href=\"/minorProject/resources/FS.css\" media=\"all\" />");
		out.println("</head>");
		out.println("<body>");
		out.println("<header class=\"header\">");
		
       
	    rd = request.getRequestDispatcher("OnlyforlogReg");
		rd.include(request, response);
		
        out.println("</header>");
		out.println("<div class=\"row\">");
		out.println("  <div class=\"column side\">");
		

		out.println("</div>");
		out.println("<div class=\"column middle\">");
		out.println("<h2 >Forget_PassWord coloumn</h2>");
//		 rd = request.getRequestDispatcher("Forgot_password");
//			rd.include(request, response);
		out.println(" </div>");
		out.println("<div class=\"column side\">");

		out.println(" <h2>Login Form</h2>");
		out.println("<form id=\"contactform\" action=\"/minorProject/LoginServlet\" method=\"post\">");
		out.println("<p class=\"contact\">");
		out.println("<label for=\"username\">User Name</label>");
		out.println("</p>");
		out.println(
				"<input id=\"username\" name=\"username\" placeholder=\"user name\" required=\"\" tabindex=\"1\" type=\"text\" >");
		out.println("<p class=\"contact\">");
		out.println("<label for=\"email\">Password</label>");
		out.println("</p>");
		out.println(
				"<input type=\"password\" id=\"password\" name=\"password\" placeholder=\"password\"  required=\"\" tabindex=\"2\"> <br>");
		out.println(
				"<br> <input class=\"buttom\" name=\"submit\" id=\"submit\" tabindex=\"3\" value=\"Login !\" type=\"submit\">");
		out.println("<p class=\"contact\">");
		out.println("<h5><a href=\"/minorProject/Forgot_password\">Forgot Password</a></h5>");
		
		out.println("</p>");
	
		out.println("<p class=\"contact\">");
		out.println("<h1><a href=\"/minorProject/Registrationform2\">Register Me</a></h1>");
		out.println("</p>");

		out.println("</form>");
		out.println(" </div>");
		out.println("</div>");
		
		out.println("<div class=\"contact\">");
		rd = request.getRequestDispatcher("Contact");
		rd.include(request, response);
		out.println("</div>");
		
		out.println("<div class=\"footer\">");
		rd = request.getRequestDispatcher("Footer");
		rd.include(request, response);
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
