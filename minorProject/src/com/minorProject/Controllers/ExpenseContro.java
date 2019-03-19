package com.minorProject.Controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.minorProject.utilities.DateUtils;

import com.minorProject.Daos.*;
import com.minorProject.pojos.Bank_Book;
import com.minorProject.pojos.Cash_Book;
import com.minorProject.pojos.Expenses;
import com.minorProject.pojos.Expenses_Category;


@WebServlet("/ExpenseContro")
public class ExpenseContro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ExpenseContro() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                         
		String exp_ac = request.getParameter("exp_ac");
		if (exp_ac == null) {
			exp_ac = new String();
		}
		String payby = request.getParameter("payby");
		if (payby == null) {
			payby = new String();
		}
		String remark = request.getParameter("remark");
		if (remark == null) {
			remark = new String();
		}
		int exp_catid = 0;
		if (request.getParameter("exp_catid") != null && request.getParameter("exp_catid").trim().length() > 0)
			exp_catid = Integer.parseInt(request.getParameter("exp_catid"));
		
		double amount = 0;
		if (request.getParameter("amount") != null && request.getParameter("amount").trim().length() > 0)
			amount = Double.parseDouble(request.getParameter("amount"));

		java.util.Date tran_date = DateUtils.convertDate("11-12-2018");
		if (request.getParameter("date") != null && request.getParameter("date").trim().length() > 0)
			tran_date = DateUtils.convertDate(request.getParameter("date"));

		int uid;
		
		HttpSession session = request.getSession();
		uid = (int) session.getAttribute("uid");   
		
		
		
    	
    	ExpensesDao eDao = new ExpensesDao();
    	

		Expenses cat = new Expenses(exp_ac, uid, exp_catid, amount, tran_date, payby, remark);
		eDao.create(cat);
       
		Expenses_CategoryDao icd = new Expenses_CategoryDao();
		Expenses_Category ic = icd.find(exp_catid);
		System.out.println(exp_catid);
		String account = ic.getExp_catname();
		
		System.out.println(account);
		System.out.println(payby.trim());
		if(payby.trim().toLowerCase().equals("cash"))  {
			Cash_BookDao cbd = new Cash_BookDao();
			Cash_Book cb = new Cash_Book(account, tran_date, amount, uid, "pay");
			cbd.create(cb);
		} else  if (payby.trim().toLowerCase().equals("cheque")){
			Bank_BookDao cbd = new Bank_BookDao();
			Bank_Book cb = new Bank_Book(account, tran_date, amount,uid,"pay");
			cbd.create(cb);
		} else 
			System.out.println("Not able to fetch Payby");

		RequestDispatcher rd = request.getRequestDispatcher("Expense");
		rd.forward(request, response);

	    
	}

}
