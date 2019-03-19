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
import com.minorProject.Daos.ExpensesDao;
import com.minorProject.Daos.IncomesDao;
import com.minorProject.pojos.Cash_Book;
import com.minorProject.pojos.Expenses;
import com.minorProject.pojos.Incomes;

@WebServlet("/DayBookController")
public class DayBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DayBookController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date today = Calendar.getInstance().getTime();
		String tod = df.format(today);
		String todf = new String(tod.substring(0, 8) + "01"); 
		String todt = new String(tod.substring(0, 8) + "31");

		
		
		String dt = request.getParameter("datef");
		System.out.println(dt);
		if (dt == null) {
			dt = todf;
		}
		

		String td = request.getParameter("datet");
		System.out.println(td);
		if (td == null) {
			td = todt;
		}
		

		HttpSession session1 = request.getSession();
		  int uid = (int) session1.getAttribute("uid");
		 
		  System.out.println(uid);
		 ExpensesDao Exp = new ExpensesDao();
		 IncomesDao Inc = new IncomesDao();
		ArrayList<Expenses> ExpList = Exp.findAllByDateWise(dt, td, uid);
		ArrayList<Incomes> IncList = Inc.findAllByDateWise(dt, td, uid);
		request.setAttribute("IncList", IncList);
		request.setAttribute("ExpList", ExpList);
		RequestDispatcher rd = request.getRequestDispatcher("DayBook");
		rd.forward(request, response);
	
	}

}
