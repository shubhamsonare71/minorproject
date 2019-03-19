package com.minorProject.View;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.minorProject.pojos.Users;

@WebServlet("/Profile")
public class Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Profile() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		RequestDispatcher rd = null;
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"en\">");
		out.println("<head>");
		out.println("<title>Profile</title>");
		out.println("<meta charset=\"utf-8\">");
		out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
		out.println(
				"<link rel=\"stylesheet\" type=\"text/css\" href=\"/minorProject/resources/FS.css\" media=\"all\" />");
		out.println("<script>"); 
		out.println("function disable() {"); 
		out.println("if(document.getElementById(\"edit\").value == \"Cancel\"){"); 
		out.println("    document.getElementById(\"username\").disabled = true;"); 
		out.println("    document.getElementById(\"password\").disabled = true;"); 
		out.println("    document.getElementById(\"name\").disabled = true;"); 
		out.println("    document.getElementById(\"address\").disabled = true;"); 
		out.println("    document.getElementById(\"mobile\").disabled = true;"); 
		out.println("    document.getElementById(\"email\").disabled = true;"); 
		out.println("    document.getElementById(\"Update\").disabled = true;"); 
		out.println("	document.getElementById(\"edit\").value = \"update\""); 
		out.println("}"); 
		out.println("else {"); 
		out.println("    document.getElementById(\"username\").disabled = false;"); 
		out.println("    document.getElementById(\"password\").disabled = false;"); 
		out.println("    document.getElementById(\"name\").disabled = false;"); 
		out.println("    document.getElementById(\"address\").disabled = false;"); 
		out.println("    document.getElementById(\"mobile\").disabled = false;"); 
		out.println("    document.getElementById(\"email\").disabled = false;"); 
		out.println("    document.getElementById(\"Update\").disabled = false;"); 
		out.println("	document.getElementById(\"edit\").value = \"Cancel\""); 
		out.println("}"); 
		out.println("}"); 
		out.println("</script>");
		out.println("</head>");
		out.println("<body onload=\"fill()\">");
		out.println("<div class=\"header\">");
		rd = request.getRequestDispatcher("Header");
		rd.include(request, response);
		out.println("</div>");

		out.println("<div class=\"row\">");
		out.println("  <div class=\"column side\">");
		out.println("<h2 text-align=\"center\">Masters</h2>");
		out.println("<div class=\"vertical-menu\"> ");
		out.println("<a href=\"ExpcatController\">Expense Category</a> ");
		out.println("<a href=\"InccatController\">Income Category</a> ");
		out.println("<a href=\"Expense\">Expense</a> ");
		out.println("<a href=\"Income\">Income</a> ");
		out.println("<a href=\"cashbookController\">Cash Book</a> ");
		out.println("<a href=\"bankbookController\">Bank Book</a> ");
		out.println("<a href=\"DayBookController\">Day Book</a> ");
		out.println("<a href=\"BalanceSheetController\">Balance Sheet</a> ");
		out.println("</div>");
		out.println("</div>");
		out.println("<div class=\"column middle\">");
		out.println("<h2>Profile</h2>");
		out.println("<div id= \"form\">");
		
		HttpSession session = request.getSession();
		Users userpro = (Users) session.getAttribute("userpro");
		
		
		out.println("<form id=\"Profileform\" action=\"/minorProject/Profileservlet\" method=\"post\">");
		out.println("<table width=\"90%\"  align=\"center\" >");
		out.println(
				"<tr><td><input id=\"name\" name=\"username\" placeholder=\"User Name\" value=\""+userpro.getUsername()+"\" required=\"disabled\" tabindex=\"1\" type=\"text\" ></td><td><input id=\"name1\" name=\"name\" placeholder=\" Name\"  value=\""+userpro.getName()+"\"required=\"disabled\" tabindex=\"2\" type=\"text\" ></td></tr>");

		out.println(
				"<tr><td><input type=\"email\" id=\"email\" name=\"email\" value=\""+userpro.getEmail()+"\"placeholder=\"Email\"  required=\"disabled\" tabindex=\"3\"></td><td><input id=\"password\" name=\"password\" placeholder=\"Password\" value=\""+userpro.getPassword()+"\" required=\"disabled\" tabindex=\"4\" type=\"password\" ></td></tr>");

		out.println(
				"<tr><td><input id=\"address\" name=\"address\" value=\""+userpro.getAddress()+"\"placeholder=\"Address\" required=\"disabled\" tabindex=\"5\" type=\"text\" ></td><td><input id=\"mobile\" name=\"mobile\" placeholder=\"Mobile No.\" value=\""+userpro.getMobile()+"\" required=\"disabled\" tabindex=\"6\" type=\"text\" ></td><tr>");
	
		out.println("</table>");
		out.println("<span class=\"butalign\">");
		out.println(
				"<br> <input class=\"buttom\" name=\"submit\" id=\"edit\" tabindex=\"4\" value=\"Update\" type=\"submit\" disabled\">");
		out.println(
				"<input class=\"buttom1\" name=\"submit\" id=\"edit\" tabindex=\"4\" value=\"cancel\" type=\"button\" onclick=\"disable()\">");
		out.println("</span>");
		out.println("</form>");
		out.println("</div>");
		out.println(" </div>");
		out.println(" </div>");
		out.println("<div class=\"column side\">");
        out.println("</div>");
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
