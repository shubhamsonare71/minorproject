package com.minorProject.View;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Contact")
public class Contact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Contact() {
        super();
      
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		                 out.println("<section id=\"contact\">");
		                 out.println("<div class=\"container\">");
		                 out.println("<div class=\"row\">");
		                 out.println("<div class=\"col-lg-12 text-center\">");
		                 out.println(" <h2 class=\"section-heading text-uppercase\">Contact Us</h2>");
		                 out.println("<h3 class=\"section-subheading text-muted\">Lorem ipsum dolor sit amet consectetur.</h3>");
		                 out.println("</div>");
		                 out.println("</div>");
		                 out.println("<div class=\"row\">");
		                 out.println("<div class=\"col-lg-12\">");
		                 out.println("<form id=\"contactForm\" name=\"sentMessage\" action=\"SendMail\" method=\"Post\">");
		                 System.out.println("Form started");
		                 out.println(" <div class=\"row\">");
		                 out.println("<div class=\"col-md-6\">");
		                 out.println(" <div class=\"form-group\">");
		                 out.println("<input class=\"form-control\" id=\"name\" type=\"text\" placeholder=\"Your Name *\" required data-validation-required-message=\"Please enter your name.\">");
		                 out.println("  <p class=\"help-block text-danger\"></p>");
		                 out.println(" </div>");
		                 out.println(" <div class=\"form-group\">");
		                 out.println("<input class=\"form-control\" id=\"email\" type=\"email\" placeholder=\"Your Email *\" required data-validation-required-message=\"Please enter your email address.\">");
		                 out.println("<p class=\"help-block text-danger\"></p>");
		                 out.println(" </div>");
		                 out.println("<div class=\"form-group\">");
		                 out.println(" <input class=\"form-control\" id=\"phone\" type=\"tel\" placeholder=\"Your Phone *\" required data-validation-required-message=\"Please enter your phone number.\">");
		                 out.println("<p class=\"help-block text-danger\"></p>");
		                 out.println(" </div>");
		                 out.println(" </div>");
		                 out.println(" <div class=\"col-md-6\">");
		                 out.println(" <div class=\"form-group\">");
		                 out.println("<textarea class=\"form-control\" id=\"message\" placeholder=\"Your Message *\" required data-validation-required-message=\"Please enter a message.\"></textarea>");
		                 out.println("<p class=\"help-block text-danger\"></p>");
		                 out.println(" </div>");
		                 out.println(" </div>");
		                 out.println("<div class=\"clearfix\"></div>");
		                 out.println("<div class=\"col-lg-12 text-center\">");
		                 out.println(" <div id=\"success\"></div>");
		                 
		                 out.println("<button id=\"sendMessageButton\" class=\"btn btn-primary btn-xl text-uppercase\" type=\"submit\">Send Message</button>");
		                 
		                 out.println("</div>");
		                 out.println("</div>");
		                 out.println("</form>");
		                 out.println("</div>");
		                 out.println("</div>");
		                 out.println("</div>");
		                 out.println("</section>");
		                
		                 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
