package com.minorProject.Daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.minorProject.pojos.Cash_Book;
import com.minorProject.pojos.Expenses_Category;
import com.minorProject.utilities.ConnectionPool;
import com.minorProject.utilities.DateUtils;

public class Expenses_CategoryDao {
	public void create(Expenses_Category exp) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "insert into expenses_category (exp_catname, exp_catdetail, userid) values(?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, exp.getExp_catname());
			ps.setString(2, exp.getExp_catdetail());
			ps.setInt(3, exp.getUserid());
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public void edit(Expenses_Category exp) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "update expenses_category set exp_catname = ?, exp_catdetail = ?, userid = ?  where exp_catid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, exp.getExp_catname());
			ps.setString(2, exp.getExp_catdetail());
			ps.setInt(3, exp.getUserid());
			ps.setInt(4, exp.getExp_catid());
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public void remove(int exp_catid) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "delete from expenses_category where exp_catid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, exp_catid);
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public Expenses_Category find(int exp_catid) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		Expenses_Category exp = new Expenses_Category();
		try {
			String sql = "select * from expenses_category where exp_catid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, exp_catid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				exp.setExp_catid(exp_catid);
				exp.setExp_catname(rs.getString("exp_catname"));
				exp.setExp_catdetail(rs.getString("exp_catdetail"));
				exp.setUserid(rs.getInt("userid"));
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return exp;
	}

	public ArrayList<Expenses_Category> findAll() {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<Expenses_Category> listexp = new ArrayList<Expenses_Category>();
		try {
			String sql = "select * from expenses_category";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Expenses_Category exp = new Expenses_Category();
				exp.setExp_catid(rs.getInt("exp_catid"));
				exp.setExp_catname(rs.getString("exp_catname"));
				exp.setExp_catdetail(rs.getString("exp_catdetail"));
				listexp.add(exp);
			}
		} catch (SQLException sq) {
			System.out.println("unable to find the record." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return listexp;
	}

	public  ArrayList<Expenses_Category> findAll(int userid) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<Expenses_Category> listexp = new ArrayList<Expenses_Category>();
		try {
			String sql = "select * from expenses_category where userid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Expenses_Category exp = new Expenses_Category();
				exp.setExp_catid(rs.getInt("exp_catid"));
				exp.setExp_catname(rs.getString("exp_catname"));
				exp.setExp_catdetail(rs.getString("exp_catdetail"));
				exp.setUserid(rs.getInt("userid"));
				listexp.add(exp);
			}
		} catch (SQLException sq) {
			System.out.println("unable to find the record." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return listexp;
	}

	public static void main(String args[]) {
		 
 		 /*   Expenses_CategoryDao dc = new Expenses_CategoryDao(); 
 		    Expenses_Category obj = new Expenses_Category("Indirect expense",  "Indirect expense", 2122); 
 		    dc.create(obj);*/
 		  

    	 
//  		     Expenses_Category exp = new Expenses_Category(1,"Direct Expense",  "Direct Expense", 255501);
//  		     Expenses_CategoryDao cd = new Expenses_CategoryDao(); 
//  		     cd.edit(exp);
  		 

  		
//          	    Expenses_CategoryDao cd = new Expenses_CategoryDao();
//  		        cd.remove(2);
  		 

  		
//                Expenses_CategoryDao cd = new Expenses_CategoryDao();
//   		        System.out.println(cd.find(1));
  		 
          
                  /*  Expenses_CategoryDao cd = new Expenses_CategoryDao();
      		        ArrayList<Expenses_Category> al = cd.findAll();
    		        for (Expenses_Category exp : al) {
  			                     System.out.println(exp);*/
  			                  
  			           Expenses_CategoryDao cd = new Expenses_CategoryDao();
  			      	   ArrayList<Expenses_Category> al = cd.findAll(255501);
  			    	   for (Expenses_Category exp : al) {
  			  			        System.out.println(exp);
          			}
       }
}
