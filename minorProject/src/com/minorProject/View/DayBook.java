package com.minorProject.View;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.minorProject.pojos.Expenses;
import com.minorProject.pojos.Incomes;

@WebServlet("/DayBook")
public class DayBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DayBook() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
		out.println("<div class=\"header\">");
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
		out.println("<h2>Day Book</h2>");
		out.println("<form id=\"daybookForm\" name=\"daybookForm\"  method=\"post\" action=\"DayBookController\" >");
		out.println("<table width=\"150%\" border=\"1\" align=\"center\" color=\"aqua blue\">");
		out.println(
				"<tr bgcolor=\"#006699\"><td align=\"center\"> Day Book </td><td align=\"center\"> Date From:<input type=\"date\"  name=\"datef\"> </td><td align=\"center\"> Date To:<input type=\"date\"  name=\"datet\"> </td><td align=\"center\" width=\"50%\"><input type=\"submit\" name=\"Show\" value=\"Show\"></td><td align=\"center\"> &nbsp;</td><td align=\"center\"> &nbsp;</td></tr>");
		out.println(
				"<tr bgcolor=\"#006699\"> <td align=\"center\"> S.No </td><td align=\"center\"> Account Name </td><td align=\"center\"> Date</td><td align=\"center\">Amount</td><td align=\"center\"> Pay/recieve</td><td align=\"center\"> Remark </td></tr>");
		out.println("<tr bgcolor=\"#006699\"><td align=\"center\" width=\"50%\" bgcolor=\"orange\">Expense</td><td align=\"center\"> &nbsp;</td><td align=\"center\"> &nbsp;</td><td align=\"center\"> &nbsp;</td><td align=\"center\"> &nbsp;</td><td align=\"center\"> &nbsp;</td></tr>");
		int a = 1;
		
		ArrayList<Expenses> explist = (ArrayList<Expenses>) request.getAttribute("ExpList");
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		for (Expenses cash : explist) {
			System.out.println("Hello");
			out.println("<tr bgcolor=\"#6699FF\">");
			out.println("<td>" + a++ + "</td>");
			out.println("<td>" + cash.getExp_ac() + "</td>");
			out.println("<td>" + df.format(cash.getTran_date()) + "</td>");
			out.println("<td>" + cash.getAmount() + "</td>");
			out.println("<td>" + cash.getPayby() + "</td>");
			out.println("<td>" + cash.getRemark() + "</td>");
			out.println("</tr>");
		}
		out.println("<tr bgcolor=\"#006699\"><td align=\"center\" width=\"50%\" bgcolor=\"orange\">Income</td><td align=\"center\"> &nbsp;</td><td align=\"center\"> &nbsp;</td><td align=\"center\"> &nbsp;</td><td align=\"center\"> &nbsp;</td><td align=\"center\"> &nbsp;</td></tr>");
         int b=1;
		ArrayList<Incomes> inclist = (ArrayList<Incomes>) request.getAttribute("IncList");
		for (Incomes cash : inclist) {
			System.out.println("Hello");
			out.println("<tr bgcolor=\"#0395E3\">");
			out.println("<td>" + b++ + "</td>");
			out.println("<td>" + cash.getInc_ac() + "</td>");
			out.println("<td>" +df.format( cash.getTran_date()) + "</td>");
			out.println("<td>" + cash.getAmount() + "</td>");
			out.println("<td>" + cash.getReceivby() + "</td>");
			out.println("<td>" + cash.getRemark() + "</td>");
			out.println("</tr>");
		}

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
