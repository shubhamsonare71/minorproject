package com.minorProject.View;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/OnlyforlogReg")
public class OnlyforlogReg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public OnlyforlogReg() {
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

        out.println("<body id=\"page-top\">");
 
        out.println("<header class=\"masthead\">");
        out.println("<nav class=\"navbar navbar-expand-lg navbar-dark fixed-top\" id=\"mainNav\">");
        out.println("<div class=\"container\">");
      
        out.println("<button class=\"navbar-toggler navbar-toggler-right\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarResponsive\" aria-controls=\"navbarResponsive\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">");
//        Menu
        out.println(" <i class=\"fa fa-bars\"></i>");
        out.println("</button>");
        out.println("<div class=\"collapse navbar-collapse\" id=\"navbarResponsive\">");
        out.println(" <ul class=\"navbar-nav text-uppercase ml-auto\">");
        out.println("<li class=\"nav-item\">");
        out.println("<a class=\"nav-link js-scroll-trigger\" href=\"#services\">Home</a>");
        out.println("</li>");
        out.println("<li class=\"nav-item\">");
        out.println("<a class=\"nav-link js-scroll-trigger\" href=\"#services\">About</a>");
        out.println("</li>");
        out.println("<li class=\"nav-item\">");
        out.println("<a class=\"nav-link js-scroll-trigger\" href=\"#about\">Contact</a>");
        out.println("</li>");
        out.println(" </ul>");
        out.println(" </div>");
        out.println("</div>");
        out.println("</nav>");
        
        out.println("<div class=\"container\">");
        out.println(" <div class=\"intro-text\">");
        out.println("<div class=\"intro-lead-in\">Welcome To Our New Account Managing site!</div>");
        out.println("<div class=\"intro-heading text-uppercase\">It's Nice To Meet You</div>");
      
        out.println("</div>");
        out.println("</div>");
        out.println("</header>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
