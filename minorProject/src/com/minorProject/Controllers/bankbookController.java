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

import com.minorProject.Daos.Bank_BookDao;
import com.minorProject.Daos.Cash_BookDao;
import com.minorProject.pojos.Bank_Book;
import com.minorProject.pojos.Cash_Book;

@WebServlet("/bankbookController")
public class bankbookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public bankbookController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date today = Calendar.getInstance().getTime();
		String tod = df.format(today);
		System.out.println(tod);
		String todf = new String(tod.substring(0, 8) + "01"); 
		String todt = new String(tod.substring(0, 8) + "31");

		
		
		String dt = request.getParameter("datef");
		System.out.print(dt);
		if (dt == null) {
			dt = todf;
		}
		
        System.out.println("hello");
		String td = request.getParameter("datet");
		System.out.print(td);
		if (td == null) {
			td = todt;
		}
		

	HttpSession session1 = request.getSession();
		  int uid = (int) session1.getAttribute("uid");
		 
		
		 Bank_BookDao bank = new Bank_BookDao();

		ArrayList<Bank_Book> bankList = bank.findAllByDateWise(dt, td, uid);
		double closing = bank.closingBalance(uid);
		double Exp = bank.ExpBalance(uid);
		request.setAttribute("ExpBal", Exp);
		request.setAttribute("closing", closing);
		request.setAttribute("bankList", bankList);
		RequestDispatcher rd = request.getRequestDispatcher("BankBook");
		rd.forward(request, response);
	}
	
}


