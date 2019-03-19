package com.minorProject.Controllers;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.minorProject.Daos.ExpensesDao;
import com.minorProject.Daos.Expenses_CategoryDao;
import com.minorProject.pojos.Expenses;
import com.minorProject.pojos.Expenses_Category;
import com.minorProject.utilities.DateUtils;

@WebServlet("/ExpenseController")

public class ExpenseController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public ExpenseController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int exp_id = 0;
		if (request.getParameter("exp_id") != null && request.getParameter("exp_id").trim().length() > 0)
			exp_id = Integer.parseInt(request.getParameter("Exp_catid"));

		String expense = request.getParameter("Expense");
		if (expense == null) {
			expense = new String();
		}

		String category = request.getParameter("category");
		if(category == null) {
			category = new String();
		}
		
		double amount = 0;
		if (request.getParameter("Amount") != null && request.getParameter("Amount").trim().length() > 0)
			amount = Double.parseDouble(request.getParameter("Amount"));

		String pay =request.getParameter("PayBy");
		if(pay == null) {
			 pay = new String();
		}
		
		String remark = request.getParameter("Remark");
		if (remark == null) {
			remark = new String();
            
//			Date dt = new Date();
//			String date = request.getParameter("Date");
//			if (date == null) {
//				java.util.Date dt = DateUtils.convertDate(date);
			}
			ExpensesDao ExpDao = new ExpensesDao();
			HttpSession session = request.getSession();
			int uid = (int) session.getAttribute("uid");
			int exp_catid = (int) session.getAttribute("exp_catid");
			java.util.Date dt = DateUtils.convertDate("20/12/2015");
			Expenses Exp = new Expenses(exp_id,expense,uid,exp_catid,amount,dt,pay,remark);
			ExpDao.create(Exp);

		}

	}


