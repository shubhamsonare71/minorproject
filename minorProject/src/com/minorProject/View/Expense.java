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

import com.minorProject.Daos.Expenses_CategoryDao;
import com.minorProject.pojos.Expenses_Category;


@WebServlet("/Expense")
public class Expense extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public Expense() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd =null;
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"en\">");
		out.println("<head>");
		out.println("<title>CSS Website Layout</title>");
		out.println("<meta charset=\"utf-8\">");
		out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
		out.println(
				"<link rel=\"stylesheet\" type=\"text/css\" href=\"/minorProject/resources/FS.css\" media=\"all\" />");
		out.println("</head>");
		out.println("<body>");
		rd = request.getRequestDispatcher("Header");
		rd.include(request, response);        
		out.println("</div>");
		out.println("<div class=\"row\">");
		out.println("  <div class=\"column side\">");
		out.println("<h2>Masters</h2>");
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
		out.println("<h2>Expense</h2>");
		out.println(
				"<form id=\"ExpForm\" name=\"ExpForm\"  method=\"post\" action=\"ExpenseContro\" >");
		out.println("<p class=\"contact\">");
		out.println("<label for=\"name\">Expense*</label>");
		out.println("</p>");
		out.println(
				"<input id=\"exp_ac\" name=\"exp_ac\" placeholder=\"Name\" required=\"\" tabindex=\"1\" type=\"text\" >");
		
		out.println("<p class=\"contact\">");
		out.println("<label for=\"name\">Category*</label>");
		out.println("</p>");
		
		HttpSession session = request.getSession();
		int uid = (int) session.getAttribute("uid");
		Expenses_CategoryDao expDao = new Expenses_CategoryDao();
		ArrayList<Expenses_Category> expcatlist = expDao.findAll(uid);
		
		out.println("<select id=\"exp_catid\" name=\"exp_catid\" tabindex=\"2\" > ");
		for (Expenses_Category cat : expcatlist) {
			out.println("<option value=\"" + cat.getExp_catid() + "\">" + cat.getExp_catname() + "</option>");
		}
		out.println("</select><br>");
		
		out.println("<p class=\"contact\">");
		out.println("<label for=\"name\">Amount*</label>");
		out.println("</p>");
		out.println(
				"<input id=\"amount\" name=\"amount\" placeholder=\"Amount\" required=\"\" tabindex=\"3\" type=\"text\" >");
		
		out.println("<p class=\"contact\">");
		out.println("<label for=\"name\">PayBy*</label>");
		out.println("</p>");
		out.println("<select id=\"payby\" name=\"payby\" tabindex=\"4\" > ");
		out.println("	<option value=\"Cash\" > Cash </option>");
		out.println("	<option value=\"Cheque\" > Cheque </option>");
		out.println("</select></br></br>");
	
		out.println("<p class=\"contact\">");
		out.println("<label for=\"name\">Remark*</label>");
		out.println("</p>");
		out.println(
				"<input id=\"remark\" name=\"remark\" placeholder=\"Remark\" required=\"\" tabindex=\"5\" type=\"text\" >");
		
		out.println("<p class=\"contact\">");
		out.println("<label for=\"name\">Date*</label>");
		out.println("</p>");	
		out.println(
				"<input id=\"date\" name=\"date\"  required=\"\" tabindex=\"6\" type=\"date\" >");
	
		
		out.println("<input class=\"button\"  name=\"submit\" value=\"submit\" type=\"submit\">");
		out.println("<input class=\"button\"  name=\"cancel\" value=\"cancel\" type=\"submit\">");
		
		out.println("<input name=\"exp_id\" id=\"exp_id\"   type=\"hidden\">");
		out.println("</form>");
		out.println(" </div>");
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
