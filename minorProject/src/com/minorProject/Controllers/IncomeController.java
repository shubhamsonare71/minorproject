package com.minorProject.Controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.minorProject.Daos.Bank_BookDao;
import com.minorProject.Daos.Cash_BookDao;
import com.minorProject.Daos.ExpensesDao;
import com.minorProject.Daos.Expenses_CategoryDao;
import com.minorProject.Daos.Income_CategoryDao;
import com.minorProject.Daos.IncomesDao;
import com.minorProject.pojos.Bank_Book;
import com.minorProject.pojos.Cash_Book;
import com.minorProject.pojos.Expenses;
import com.minorProject.pojos.Expenses_Category;
import com.minorProject.pojos.Income_Category;
import com.minorProject.pojos.Incomes;
import com.minorProject.utilities.DateUtils;


@WebServlet("/IncomeController")
public class IncomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public IncomeController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String inc_ac = request.getParameter("income");
		if (inc_ac == null) {
			inc_ac = new String();
		}
		String recieve = request.getParameter("receivby");
		if (recieve == null) {
			recieve= new String();
		}
		String remark = request.getParameter("Remark");
		if (remark == null) {
			remark = new String();
		}
		int inc_catid = 0;
		if (request.getParameter("inc_catid") != null && request.getParameter("inc_catid").trim().length() > 0)
			inc_catid = Integer.parseInt(request.getParameter("inc_catid"));
		
		double amount = 0;
		if (request.getParameter("Amount") != null && request.getParameter("Amount").trim().length() > 0)
			amount = Double.parseDouble(request.getParameter("Amount"));

		java.util.Date tran_date = DateUtils.convertDate("22-11-2018");
		if (request.getParameter("Date") != null && request.getParameter("Date").trim().length() > 0)
			tran_date = DateUtils.convertDate(request.getParameter("Date"));

		int uid;
		HttpSession session = request.getSession();
		uid = (int) session.getAttribute("uid");   
		
		
		
    	
    	IncomesDao IDao = new IncomesDao();
    	

		Incomes inc = new Incomes(inc_ac, uid, inc_catid, amount, tran_date, recieve, remark);
		IDao.create(inc);
       
		Income_CategoryDao icd = new Income_CategoryDao();
		Income_Category ic = icd.find(inc_catid);
		System.out.println(inc_catid);
		String account = ic.getInc_catname();
		
		System.out.println(account);
		System.out.println(recieve.trim());
		if(recieve.trim().toLowerCase().equals("cash"))  {
			Cash_BookDao cbd = new Cash_BookDao();
			Cash_Book cb = new Cash_Book(account, tran_date, amount, uid, "recieve");
			cbd.create(cb);
		} else  if (recieve.trim().toLowerCase().equals("cheque")){
			Bank_BookDao cbd = new Bank_BookDao();
			Bank_Book cb = new Bank_Book(account, tran_date, amount,uid,"recieve");
			cbd.create(cb);
		} else 
			System.out.println("Not able to fetch Payby");

		RequestDispatcher rd = request.getRequestDispatcher("Expense");
		rd.forward(request, response);
	}

}
