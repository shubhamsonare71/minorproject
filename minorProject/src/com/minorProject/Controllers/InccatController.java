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
import com.minorProject.Daos.Income_CategoryDao;
import com.minorProject.pojos.Expenses_Category;
import com.minorProject.pojos.Income_Category;

@WebServlet("/InccatController")

public class InccatController extends HttpServlet {

	private static final long serialVersionUID = 1L;
       
    public InccatController() {
    
    	super();
        
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int catid = 0;
		if (request.getParameter("inc_catid") != null && request.getParameter("inc_catid").trim().length()>0)
			catid = Integer.parseInt(request.getParameter("inc_catid"));
		String catname = request.getParameter("catname");
		if (catname == null) {
			catname = new String();
		}
		String catdetail = request.getParameter("catdetail");
		if (catdetail == null) {
			catdetail = new String();
		}
		String operation = request.getParameter("operation");
		if (operation == null) {
			operation = new String();
		}
		
		Income_CategoryDao IncDao = new Income_CategoryDao();
		HttpSession session = request.getSession();
		int uid = (int) session.getAttribute("uid");
		if (operation.equals("create")) {
			Income_Category Exp = new Income_Category(catid, catname, catdetail,uid);
			IncDao.create(Exp);
		} else if (operation.equals("edit")) {
			Income_Category Inc = new Income_Category(catid, catname, catdetail,uid);
			IncDao.edit(Inc);
		} else if (operation.equals("remove")) {
			IncDao.remove(catid);
		} 
       
		ArrayList<Income_Category> IncList = IncDao.findAll();
		request.setAttribute("IncList", IncList);
		RequestDispatcher rd = request.getRequestDispatcher("IncomeCategory");
		rd.forward(request, response);
	}

	}


