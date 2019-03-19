package com.minorProject.View;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.minorProject.pojos.Bank_Book;
import com.minorProject.pojos.Expenses;
import com.minorProject.pojos.Incomes;

@WebServlet("/BalanceSheet")

public class BalanceSheet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public BalanceSheet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = null;
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"en\">");
		out.println("<head>");
		out.println("<title>Balance Sheet</title>");
		out.println("<meta charset=\"utf-8\">");
		out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
		out.println(
				"<link rel=\"stylesheet\" type=\"text/css\" href=\"/minorProject/resources/FS.css\" media=\"all\" />");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"header\">");

		rd = request.getRequestDispatcher("Header");
		rd.include(request, response);

	
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
		out.println("<h2>BalanceSheet</h2>");
		out.println(
				"<form id=\"BalanceSheetForm\" name=\"BalanceSheetForm\"  method=\"post\" action=\"BalanceSheetController\" >");
		out.println("<table width=\"90%\" border=\"1\" align=\"center\" >");
		out.println("<th bgcolor=\"#006699\">");
		out.println("Balance Sheet");
		out.println("</th>");
		out.println("<th colspan = \"1\" bgcolor=\"#006699\">");
		out.println("Date From: <br> <input type = \"date\" style = \"color:black;\" required name = \"datef\"");
		out.println("</th>");
		out.println("<th colspan = \"1\" bgcolor=\"#006699\"> ");
		out.println("Date To: <br> <input type = \"date\" style = \"color:black;\" required name = \"datet\"");
		out.println("</th>");
		out.println("<th  bgcolor=\"#006699\">");
		out.println("<input type =\"submit\" value = \"Show\" name = \"Show\"  width=\"170%\">");
		out.println("</th>");
		out.println("	</form>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<th colspan = \"2\" bgcolor=\"#006699\" >");
		out.println("Incomes");
		out.println("</th>");
		out.println("<th colspan = \"2\" bgcolor=\"#006699\" >");
		out.println("Expenses");
		out.println("</th>");
		out.println("</tr>");
		out.println("<tr >");
		out.println("<th bgcolor=\"#006699\">");
		out.println("Incomes");
		out.println("</th>");
		out.println("<th bgcolor=\"#006699\">");
		out.println("Amount");
		out.println("</th>");
		out.println("<th bgcolor=\"#006699\">");
		out.println("Expenses");
		out.println("</th>");
		out.println("<th bgcolor=\"#006699\">");
		out.println("Amount");
		out.println("</th>");
		out.println("</tr>");

		ArrayList<Expenses> explist = (ArrayList<Expenses>) request.getAttribute("expList");
		ArrayList<Incomes> inclist = (ArrayList<Incomes>) request.getAttribute("incList");

		Iterator<Expenses> it = explist.iterator();
		Iterator<Incomes> itn = inclist.iterator();
		double incAmt = 0.0;
		double expAmt = 0.0;
		while (it.hasNext() || itn.hasNext()) {
			out.println("<tr class = \"balsheet\"  bgcolor=\"#6699FF\">");

			if (itn.hasNext()) {
				Incomes inc = itn.next();
				out.println("<td >" + inc.getInc_ac() + "</td>");
				out.println("<td >" + inc.getAmount() + "</td>");
				incAmt += inc.getAmount();
			} else {
				out.println("<td>&nbsp; </td>");
				out.println("<td>&nbsp; </td>");
			}

			if (it.hasNext()) {
				Expenses exp1 = it.next();
				out.println("<td>" + exp1.getExp_ac() + "</td>");
				out.println("<td>" + exp1.getAmount() + "</td>");
				expAmt += exp1.getAmount();
			} else {
				out.println("<td>&nbsp; </td>");
				out.println("<td>&nbsp; </td>");

			}

			out.println("</tr>");

		}
		out.println("<tr bgcolor=\"#6699FF\">");
		out.println("<th  colspan=\"1\" >");
		out.println("Total:");
		out.println("</th>");
		out.println("<th  colspan=\"1\" >");
		out.println("Rs. " + incAmt);
		out.println("</th>");
		out.println("<th  colspan=\"1\" >");
		out.println("Total:");
		out.println("</th>");
		out.println("<th  colspan=\"1\" >");
		out.println("Rs. " + expAmt);
		out.println("</th>");
		out.println("</tr>");
		out.println("<tr bgcolor=\"#6699FF\">");
		out.println("<th  colspan=\"3\">");
		out.println("Gross Profit:&nbsp;");
		out.println("</th>");
		out.println("<th  colspan=\"1\" >");
		out.println("Rs. " + (incAmt - expAmt));
		out.println("</th>");
		out.println("</tr>");
		out.println("</table>");
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
