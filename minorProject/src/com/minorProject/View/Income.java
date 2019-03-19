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
import com.minorProject.Daos.Income_CategoryDao;
import com.minorProject.pojos.Expenses_Category;
import com.minorProject.pojos.Income_Category;

/**
 * Servlet implementation class Income
 */
@WebServlet("/Income")
public class Income extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Income() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = null;
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
		out.println("<h2>Income</h2>");
		out.println("<form id=\"IncomeForm\" name=\"IncomeForm\"  method=\"post\" action=\"IncomeController \" >");
		out.println("<p class=\"contact\">");
		out.println("<label for=\"income\">Income</label>");
		out.println("</p>");
		out.println(
				"<input id=\"income\" name=\"income\" placeholder=\"I \" required=\"\" tabindex=\"1\" type=\"text\" >");
	   
		out.println("<p class=\"contact\">");
		out.println("<label for=\"categories\">Categories</label>");
		out.println("</p>");
		
		HttpSession session = request.getSession();
		int uid = (int) session.getAttribute("uid");
		Income_CategoryDao incDao = new Income_CategoryDao();
		ArrayList<Income_Category> inclist = incDao.findAll(uid);
		
		out.println("<select id=\"inc_catid\" name=\"inc_catid\" tabindex=\"2\" > ");
		for (Income_Category inc : inclist) {
			out.println("<option value=\"" + inc.getInc_catid() + "\">" + inc.getInc_catname() + "</option>");
		}
		out.println("</select><br>");
		
		
		out.println("<p class=\"contact\">");
		out.println("<label for=\"amount\">Amount</label>");
		out.println("</p>");
		out.println(
				"<input id=\"amount\" name=\"Amount\" placeholder=\"Amount \" required=\"\" tabindex=\"1\" type=\"text\" >");
		
		out.println("<p class=\"contact\">");
		out.println("<label for=\"receivby\">Receivby</label>");
		out.println("</p>");
		
		out.println("<select id=\"receivby\" name=\"receivby\"  tabindex=\"5\" > ");
		out.println("<option value=\"Cash\"> Cash </option>");
		out.println("<option value=\"Cheque\"> Cheque </option>");
		out.println("</select></br></br>");
    
		out.println("<p class=\"contact\">");
		out.println("<label for=\"remark\">Remark</label>");
		out.println("</p>");
		out.println(
				"<input id=\"remark\" name=\"Remark\" placeholder=\"Remark \" required=\"\" tabindex=\"1\" type=\"text\" >");
		
		out.println("<p class=\"contact\">");
		out.println("<label for=\"date\">Date</label>");
		out.println("</p>"); 
		
		out.println("<input type=\"date\" name=\"Date\">");
		out.println("<span class=\"sp\">");
		out.println("<input class=\"button\"  name=\"submit\" value=\"submit\" type=\"submit\">" );
		out.println("<input class=\"button\"  name=\"cancel\" value=\"cancel\" type=\"submit\">" );
		out.println("</span>");
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
