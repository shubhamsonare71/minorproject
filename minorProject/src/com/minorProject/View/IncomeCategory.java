package com.minorProject.View;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.minorProject.pojos.Income_Category;




@WebServlet("/IncomeCategory")
public class IncomeCategory extends HttpServlet {

	private static final long serialVersionUID = 1L;
    
	public IncomeCategory() {
        super();
    }
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		RequestDispatcher rd = null;
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"en\">");
		out.println("<head>");
		out.println("<script>");
		out.println("function del(inc_catid) {");
		out.println("document.getElementById(\"inc_catid\").value = inc_catid;");
		out.println("document.getElementById(\"operation\").value = 'remove';");
		out.println("document.InccategoriesForm.submit();");
		out.println("}");
		out.println("function mod(inc_catid,inc_catname,inc_catdetail) {");
		out.println("document.getElementById(\"inc_catid\").value = inc_catid;");
		out.println("document.getElementById(\"inc_catname\").value = inc_catname;");
		out.println("document.getElementById(\"inc_catdetail\").value = inc_catdetail;");
		out.println("document.getElementById(\"add\").value = 'Save!';");
		out.println("document.getElementById(\"operation\").value = 'edit';");
		out.println("}");
		out.println("</script>");
		out.println("<title>Income Category</title>");
		out.println("<meta charset=\"utf-8\">");
		out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
		out.println(
				"<link rel=\"stylesheet\" type=\"text/css\" href=\"/minorProject/resources/FS.css\" media=\"all\" />");
		out.println("</head>");
		out.println("<body>");
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
		out.println("<h2>Income Category</h2>");
		out.println(
				"<form id=\"InccategoriesForm\" name=\"InccategoriesForm\"  method=\"post\" action=\"InccatController\">");
		out.println("<p class=\"contact\">");
		out.println("<label for=\"name\">Name</label>");
		out.println("</p>");
		out.println(
				"<input id=\"inc_catname\" name=\"catname\" placeholder=\"Name \" required=\"\" tabindex=\"1\" type=\"text\" >");
		out.println("<p class=\"contact\">");
		out.println("<label for=\"phone\">Details</label>");
		out.println("</p>");
		out.println(
				"<textarea id=\"inc_catdetail\" rows=\"5\" cols=\"57\" name=\"catdetail\"  required=\"\" tabindex=\"2\" > </textarea><br>");
		out.println(
				"<br> <input class=\"buttom\" name=\"add\" id=\"add\" tabindex=\"3\" value=\"Add !\" type=\"submit\">");
		out.println("<input name=\"operation\" id=\"operation\"  value=\"create\" type=\"hidden\">");
		out.println("<input name=\"inc_catid\" id=\"inc_catid\"   type=\"hidden\">"); 
		out.println("</form>");
		out.println("<div  class=\"form\">");
		out.println("<br>");
		out.println("<table  width=\"90%\" border=\"1\" text-align=\"center\">");
		out.println(
				"<tr bgcolor=\"#006699\"><td align=\"center\"> Name </td><td align=\"center\"> Details</td><td align=\"center\"> &nbsp;</td><td align=\"center\"> &nbsp;</td></tr>");
		ArrayList<Income_Category> IncList = (ArrayList<Income_Category>) request.getAttribute("IncList");
		for (Income_Category Inc : IncList) {
			out.println("<tr bgcolor=\"#6699FF\">");
			out.println("<td>" + Inc.getInc_catname() + "</td>");
			out.println("<td>" + Inc.getInc_catdetail() + "</td>");
			out.println(
					"<td ><input  class=\"buttom\"  name=\"edit\" id=\"edit\" value=\"Edit!\" type=\"button\" "
					+ "onclick=\"mod('"+Inc.getInc_catid()+"','"+Inc.getInc_catname()+"','"+Inc.getInc_catdetail()+"');\"></td>");
			out.println(
					"<td ><input class=\"buttom\" name=\"delete\" id=\"delete\" value=\"Delete!\" type=\"button\" onclick=\"del('"+Inc.getInc_catid()+"');\" ></td>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("<br>");
		out.println(" </div>");
		out.println("</div>");
		out.println("<div class=\"column side\">");
        out.println(" </div>");
		out.println("</div>");
		out.println("<div class=\"footer\">");
		rd = request.getRequestDispatcher("Footer");
		rd.include(request, response);
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");

	 }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		             doGet(request, response);
	}

}
