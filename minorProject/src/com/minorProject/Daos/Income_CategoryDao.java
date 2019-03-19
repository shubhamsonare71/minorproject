package com.minorProject.Daos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.minorProject.pojos.Cash_Book;
import com.minorProject.pojos.Expenses_Category;
import com.minorProject.pojos.Income_Category;
import com.minorProject.utilities.ConnectionPool;

public class Income_CategoryDao {
	public void create(Income_Category inc) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "insert into income_category (inc_catname, inc_catdetail, userid) values(?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, inc.getInc_catname());
			ps.setString(2, inc.getInc_catdetail());
			ps.setInt(3, inc.getUserid());
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public void edit(Income_Category inc) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "update income_category set inc_catname = ?, inc_catdetail = ?, userid = ?  where inc_catid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, inc.getInc_catname());
			ps.setString(2, inc.getInc_catdetail());
			ps.setInt(3, inc.getUserid());
			ps.setInt(4, inc.getInc_catid());
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public void remove(int inc_catid) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "delete from income_category where inc_catid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, inc_catid);
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public Income_Category find(int inc_catid) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		Income_Category inc = new Income_Category();
		try {
			String sql = "select * from income_category where inc_catid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, inc_catid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				inc.setInc_catid(inc_catid);
				inc.setInc_catname(rs.getString("inc_catname"));
				inc.setInc_catdetail(rs.getString("inc_catdetail"));
				inc.setUserid(rs.getInt("userid"));
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return inc;
	}

	public ArrayList<Income_Category> findAll() {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<Income_Category> listinc = new ArrayList<Income_Category>();
		try {
			String sql = "select * from Income_category";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Income_Category inc = new Income_Category();
				inc.setInc_catid(rs.getInt("inc_catid"));
				inc.setInc_catname(rs.getString("inc_catname"));
				inc.setInc_catdetail(rs.getString("inc_catdetail"));
				listinc.add(inc);
			}
		} catch (SQLException sq) {
			System.out.println("unable to find the record." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return listinc;
	}
	public ArrayList<Income_Category> findAll(int userid) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<Income_Category> listinc = new ArrayList<Income_Category>();
		try {
			String sql = "select * from Income_category where userid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, userid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Income_Category inc = new Income_Category();
				inc.setInc_catid(rs.getInt("inc_catid"));
				inc.setInc_catname(rs.getString("inc_catname"));
				inc.setInc_catdetail(rs.getString("inc_catdetail"));
				inc.setUserid(userid);
				listinc.add(inc);
			}
		} catch (SQLException sq) {
			System.out.println("unable to find the record." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return listinc;
	}
	public static void main(String args[]) {
		 
 		  /*  Income_CategoryDao dc = new Income_CategoryDao(); 
 		    Income_Category obj = new Income_Category("Indirect expense",  "which is come after giving service", 2122); 
 		    dc.create(obj);*/
 		  

    	 
//  		     Income_Category inc = new Income_Category(1,"Direct Expense",  "Direct Expense", 255501);
//  		     Income_CategoryDao cd = new Income_CategoryDao(); 
//  		     cd.edit(inc);
  		 

  		
//          	    income_CategoryDao cd = new Income_CategoryDao();
//  		        cd.remove(2);
  		 

  		
//                Income_CategoryDao cd = new Income_CategoryDao();
//   		        System.out.println(cd.find(1));
  		 
          
 /*                  Income_CategoryDao cd = new Income_CategoryDao();
      		        ArrayList<Income_Category> al = cd.findAll();
    		        for (Income_Category inc : al) {
  			                     System.out.println(inc);
          			}*/
    
 		         Income_CategoryDao cd = new Income_CategoryDao();
		        ArrayList<Income_Category> al = cd.findAll(2122);
	            for (Income_Category inc : al) {
		                     System.out.println(inc);	
	}
	
}
}
