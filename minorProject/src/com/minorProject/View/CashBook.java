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

import com.minorProject.pojos.Cash_Book;
import com.minorProject.pojos.Expenses_Category;

@WebServlet("/CashBook")
public class CashBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CashBook() {
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
		out.println("<h2>Cash_Book</h2>");
		out.println(
				"<form id=\"CashbookForm\" name=\"CashbookForm\"  method=\"post\" action=\"cashbookController\" >");
		out.println("<table width=\"90%\" border=\"1\" align=\"center\" color=\"aqua blue\">");
		out.println(
				"<tr bgcolor=\"#006699\"><td align=\"center\"> Cash book </td><td align=\"center\"> Date From:<input type=\"date\"  name=\"datef\"> </td><td align=\"center\"> Date To:<input type=\"date\"  name=\"datet\"> </td><td align=\"center\"><input type=\"submit\" name=\"Show\" value=\"Show\"></td></tr>");
		out.println(
				"<tr bgcolor=\"#006699\"><td align=\"center\"> S.No </td><td align=\"center\"> Date</td><td align=\"center\">Amount</td><td align=\"center\"> Pay/recieve</td></tr>");
		int a = 1;
		ArrayList<Cash_Book> cashlist = (ArrayList<Cash_Book>) request.getAttribute("cashList");
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		for (Cash_Book cash : cashlist) {
			System.out.println("Hello");
			out.println("<tr bgcolor=\"#6699FF\">");
			out.println("<td>" + a++ + "</td>");
            out.println("<td>" +df.format( cash.getTran_date()) + "</td>");
			out.println("<td>" + cash.getAmount() + "</td>");
			out.println("<td>" + cash.getOperation() + "</td>");
			out.println("</tr>");
		}
		   double closing = (double)request.getAttribute("closing");
		   out.println(
				"<tr><td align=\"center\"> &nbsp;</td><td align=\"center\">Closing Balance </td><td align=\"center\"> &nbsp;</td><td align=\"center\">"+ closing+"</td>");
		
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
		       doGet(request,response);
       }
}
