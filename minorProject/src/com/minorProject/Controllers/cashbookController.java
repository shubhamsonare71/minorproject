package com.minorProject.Controllers;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.minorProject.Daos.Cash_BookDao;
import com.minorProject.Daos.Expenses_CategoryDao;
import com.minorProject.pojos.Cash_Book;
import com.minorProject.pojos.Expenses_Category;
import com.minorProject.utilities.DateUtils;

@WebServlet("/cashbookController")
public class cashbookController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public cashbookController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
             	doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date today = Calendar.getInstance().getTime();
		String tod = df.format(today);
		String todf = new String (tod.substring(0, 8) + "01");
		String todt= new String (tod.substring(0, 8) + "31"); 
		
		String dt = request.getParameter("datef");
		
		if (dt == null) {
			dt = todf;
		}
		

		String td = request.getParameter("datet");
		
		if (td == null) {
			td =todt;
		}
		

		HttpSession session1 = request.getSession();
		  int uid = (int) session1.getAttribute("uid");
		 
		
		  Cash_BookDao cash = new Cash_BookDao();

		ArrayList<Cash_Book> cashList = cash.findAllByDateWise(dt, td, uid);
		double closing = cash.closingBalance(uid);
		request.setAttribute("closing", closing);
		request.setAttribute("cashList", cashList);
		RequestDispatcher rd = request.getRequestDispatcher("CashBook");
		rd.forward(request, response);
	}

}