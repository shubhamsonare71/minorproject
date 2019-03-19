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
import javax.servlet.http.HttpSession;

import com.minorProject.pojos.Expenses;
import com.minorProject.pojos.Expenses_Category;
import com.minorProject.pojos.Users;

@WebServlet("/ExpenseCategory")
public class ExpenseCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ExpenseCategory() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		RequestDispatcher rd = null;
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"en\">");
		out.println("<head>");
		out.println("<script>");
		out.println("function del(Exp_catid) {");
		out.println("document.getElementById(\"Exp_catid\").value = Exp_catid;");
		out.println("document.getElementById(\"operation\").value = 'remove';");
		out.println("document.ExpcategoriesForm.submit();");
		out.println("}");
		out.println("function mod(Exp_catid,Exp_catname,Exp_catdetail) {");
		out.println("document.getElementById(\"Exp_catid\").value = Exp_catid;");
		out.println("document.getElementById(\"categoryName\").value = Exp_catname;");
		out.println("document.getElementById(\"categoryDetails\").value = Exp_catdetail;");
		out.println("document.getElementById(\"add\").value = 'Save!';");
		out.println("document.getElementById(\"operation\").value = 'edit';");
		out.println("}");
		out.println("</script>");
		out.println("<title>Expense Category</title>");
		out.println("<meta charset=\"utf-8\">");
		out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
		out.println(
				"<link rel=\"stylesheet\" type=\"text/css\" href=\"/minorProject/resources/FS.css\" media=\"all\" />");
		out.println("</head>");
		out.println("<body>");
		
		
		
		out.println("<div class=\"header\">");
//		---------------------------------------------------------
		rd = request.getRequestDispatcher("Header");
		rd.include(request, response);

	
//		------------------------------------

		out.println("<div class=\"row\">");
		out.println(" <div class=\"column side\">");
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
		out.println("<h2>Expense Category</h2>");
		out.println(
				"<form id=\"ExpcategoriesForm\" name=\"ExpcategoriesForm\"  method=\"post\" action=\"ExpcatController\">");
		out.println("<p class=\"contact\">");
		out.println("<label for=\"name\">Name</label>");
		out.println("</p>");
		out.println(
				"<input id=\"categoryName\" name=\"Exp_catname\" placeholder=\"Name \" required=\"\" tabindex=\"1\" type=\"text\" >");
		out.println("<p class=\"contact\">");
		out.println("<label for=\"phone\">Details</label>");
		out.println("</p>");
		out.println(
				"<textarea id=\"categoryDetails\" rows=\"5\" cols=\"57\" name=\"Exp_catdetail\"  required=\"\" tabindex=\"2\" > </textarea><br>");
		
		out.println(
				"<br> <input class=\"buttom\" name=\"add\" id=\"add\" tabindex=\"3\" value=\"Add !\" type=\"submit\">");
		out.println("<input name=\"operation\" id=\"operation\"  value=\"create\" type=\"hidden\">");
		out.println("<input name=\"Exp_catid\" id=\"Exp_catid\"   type=\"hidden\">"); 
		out.println("</form>");
		out.println("<div  class=\"form\">");
		out.println("<br>");
		
		out.println("<table width=\"90%\" border=\"1\" >");
		out.println(
				"<tr bgcolor=\"#006699\"><td align=\"center\"> Name </td><td align=\"center\"> Details</td><td align=\"center\"> &nbsp;</td><td align=\"center\"> &nbsp;</td></tr>");
		ArrayList<Expenses_Category> ExpList = (ArrayList<Expenses_Category>) request.getAttribute("ExpList");
		for (Expenses_Category Exp : ExpList) {
			out.println("<tr  bgcolor=\"#6699FF\">");
			out.println("<td>" + Exp.getExp_catname() + "</td>");
			out.println("<td>" + Exp.getExp_catdetail() + "</td>");
			out.println(
					"<td ><input  class=\"buttom\"  name=\"edit\" id=\"edit\" value=\"Edit!\" type=\"button\" "
					+ "onclick=\"mod('"+Exp.getExp_catid()+"','"+Exp.getExp_catname()+"','"+Exp.getExp_catdetail()+"');\"></td>");
			out.println(
					"<td ><input class=\"buttom\" name=\"delete\" id=\"delete\" value=\"Delete!\" type=\"button\" onclick=\"del('"+Exp.getExp_catid()+"');\" ></td>");
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
