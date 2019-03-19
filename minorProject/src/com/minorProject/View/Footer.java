package com.minorProject.View;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Footer")
public class Footer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Footer() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("  <meta charset=\"utf-8\">");
		out.println(" <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">");
		out.println("<meta name=\"description\" content=\"\">");
		out.println("<meta name=\"author\" content=\"\">");
		out.println(" <title>Agency - Start Bootstrap Theme</title>");
		out.println("<link href=\"delete/vendor/bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\">");
		out.println(
				" <link href=\"delete/vendor/font-awesome/css/font-awesome.min.css\" rel=\"stylesheet\" type=\"text/css\">");
		out.println(
				"<link href=\"https://fonts.googleapis.com/css?family=Montserrat:400,700\" rel=\"stylesheet\" type=\"text/css\">\r\n"
						+ "");
		out.println(
				"<link href='https://fonts.googleapis.com/css?family=Kaushan+Script' rel='stylesheet' type='text/css'>");
		out.println(
				"<link href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css'>");
		out.println(
				"  <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700' rel='stylesheet' type='text/css'>\r\n"
						+ "");
		out.println("<link href=\"delete/css/agency.min.css\" rel=\"stylesheet\">");
		out.println("<footer>");
		out.println(" <div class=\"container\">");
		out.println(" <div class=\"row\">");
		out.println("<div class=\"col-md-4\">");
		out.println("<span class=\"copyright\" bgcolor=\"#111\">Copyright &copy; Your Website 2018</span>");
		out.println("</div>");
		out.println("<div class=\"col-md-4\">");
		out.println(" <ul class=\"list-inline social-buttons\">");
		out.println(" <li class=\"list-inline-item\">");
		out.println(" <a href=\"#\">");
		out.println("  <i class=\"fa fa-twitter\"></i>");
		out.println(" </a>");
		out.println("</li>");
		out.println("<li class=\"list-inline-item\">");
		out.println(" <a href=\"#\">");
		out.println("  <i class=\"fa fa-facebook\"></i>");
		out.println("</a>");
		out.println(" </li>");
		out.println(" <li class=\"list-inline-item\">");
		out.println("<a href=\"#\">");
		out.println("  <i class=\"fa fa-linkedin\"></i>");
		out.println("  </a>");
		out.println("  </li>");
		out.println("  </ul>");
		out.println("  </div>");
		out.println("   <div class=\"col-md-4\">");
		out.println("  <ul class=\"list-inline quicklinks\">");
		out.println("  <li class=\"list-inline-item\">");
		out.println("  <a href=\"#\" bgcolor=\"#333\">Privacy Policy</a>");
		out.println("   </li>");
		out.println("  <li class=\"list-inline-item\">");
		out.println("     <a href=\"#\">Terms of Use</a>");
		out.println("    </li>");
		out.println("    </ul>");
		out.println("    </div>");
		out.println("   </div>");
		out.println("  </div>");
		out.println("  </footer>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
