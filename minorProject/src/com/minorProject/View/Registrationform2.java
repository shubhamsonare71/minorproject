package com.minorProject.View;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Registrationform2")
public class Registrationform2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Registrationform2() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher rd = null;
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"en\">");
		out.println("<head>");
		out.println("<title>Registration Form</title>");
		out.println("<meta charset=\"utf-8\">");
		out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
		out.println(
				"<link rel=\"stylesheet\" type=\"text/css\" href=\"/minorProject/resources/FS.css\" media=\"all\" />");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"header\">");

		rd = request.getRequestDispatcher("OnlyforlogReg");
		rd.include(request, response);

         
		out.println("</div>");
;
		out.println("<div class=\"row\">");
//		side column
		out.println("  <div class=\"column side\">");
		
		;
		out.println("</div>");
		out.println("<div class=\"column middle\">");
		out.println("<h2>Main Content</h2>");
		out.println(
				"<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas sit amet pretium urna. Vivamus venenatis</p>");
		out.println(" </div>");
		out.println("<div class=\"column side\">");

		out.println(" <h2>Registration Form</h2>");
		out.println("<div  class=\"form\">");
		out.println("<form id=\"contactform\" action=\"/minorProject/RegistrationServlet\" method=\"post\" >");
		out.println("<p class=\"contact\">");
		out.println("<label for=\"name\">User Name:-</label>");
		out.println("</p>");
		out.println(
				"<input id=\"name\" name=\"username\" placeholder=\"User Name\" required=\"\" tabindex=\"1\" type=\"text\" >");
		out.println("<p class=\"contact\">");
		out.println("<label for=\"Password\">Password:-</label>");
		out.println("</p>");
		out.println(
				"<input id=\"password\" name=\"password\" placeholder=\"Password\" required=\"\" tabindex=\"2\" type=\"password\" >");
		out.println("<p class=\"contact\">");
		out.println("<label for=\"name\">Name:-</label>");
		out.println("</p>");
		out.println(
				"<input id=\"name\" name=\"name\" placeholder=\" Name\" required=\"\" tabindex=\"3\" type=\"text\" >");
		out.println("<p class=\"contact\">");
		out.println("<label for=\"address\">Address:-</label>");
		out.println("</p>");
		out.println(
				"<input id=\"address\" name=\"address\" placeholder=\"Address\" required=\"\" tabindex=\"4\" type=\"text\" >");
		out.println("<p class=\"contact\">");
		out.println("<label for=\"mobile\">Mobile No.:-</label>");
		out.println("</p>");
		out.println(
				"<input id=\"mobile\" name=\"mobile\" placeholder=\"Mobile No.\" required=\"\" tabindex=\"5\" type=\"text\" >");
		out.println("<p class=\"contact\">");
		out.println("<label for=\"email\">Email:-</label>");
		out.println("</p>");
		out.println(
				"<input type=\"email\" id=\"email\" name=\"email\" placeholder=\"Email\"  required=\"\" tabindex=\"6\"> <br>");
		
		out.println(
				"<br> <input class=\"buttom\" name=\"submit\" id=\"submit\" tabindex=\"6\" value=\"Register\" type=\"submit\">");
		out.println("<input name=\"Userid\" id=\"Userid\"   type=\"hidden\">");
		
		
		

		out.println("</form>");
		out.println("</div>");
		out.println(" </div>");
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
