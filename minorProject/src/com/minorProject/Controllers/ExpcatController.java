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

import com.minorProject.Daos.Expenses_CategoryDao;
import com.minorProject.pojos.Expenses_Category;


@WebServlet("/ExpcatController")

public class ExpcatController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public ExpcatController() {
    
		super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	            doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	       System.out.println("expcatcontroller");
		int catid = 0;
		if (request.getParameter("Exp_catid") != null && request.getParameter("Exp_catid").trim().length()>0)
			catid = Integer.parseInt(request.getParameter("Exp_catid"));
		HttpSession session = request.getSession();
		session.setAttribute("exp_catid", catid);
		String Exp_catname = request.getParameter("Exp_catname");
		if (Exp_catname == null) {
			Exp_catname = new String();
		}
		String Exp_catdetail = request.getParameter("Exp_catdetail");
		if (Exp_catdetail == null) {
			Exp_catdetail = new String();
		}
		String operation = request.getParameter("operation");
		if (operation == null) {
			operation = new String();
		}
		
		Expenses_CategoryDao ExpDao = new Expenses_CategoryDao();
		HttpSession session1 = request.getSession();
		int uid = (int) session1.getAttribute("uid");
		System.out.println(uid);
		if (operation.equals("create")) {
			Expenses_Category Exp = new Expenses_Category(catid, Exp_catname, Exp_catdetail,uid);
			ExpDao.create(Exp);
		} else if (operation.equals("edit")) {
			Expenses_Category cat = new Expenses_Category(catid, Exp_catname, Exp_catdetail,uid);
			ExpDao.edit(cat);
		} else if (operation.equals("remove")) {
			ExpDao.remove(catid);
		} 
        
		ArrayList<Expenses_Category> ExpList = ExpDao.findAll(uid);
		request.setAttribute("ExpList", ExpList);
		RequestDispatcher rd = request.getRequestDispatcher("ExpenseCategory");
		rd.forward(request, response);
       }

	}


