package com.minorProject.Daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.minorProject.pojos.Expenses;
import com.minorProject.pojos.Expenses;
import com.minorProject.utilities.ConnectionPool;
import com.minorProject.utilities.DateUtils;

public class ExpensesDao {
	public void create(Expenses exp) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "insert into expenses (exp_ac, userid, exp_catid, amount, tran_date, payby, remark) values(?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, exp.getExp_ac());
			ps.setInt(2, exp.getUserid());
			ps.setInt(3, exp.getExp_catid());
			ps.setDouble(4, exp.getAmount());
			java.sql.Date dt = new java.sql.Date(exp.getTran_date().getTime());
			System.out.println(dt);
			ps.setDate(5, dt);
			ps.setString(6, exp.getPayby());
			ps.setString(7, exp.getRemark());
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public void edit(Expenses exp) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "update expenses set exp_ac = ?, userid = ?, exp_catid = ?, amount = ?, tran_date = ?, payby = ?, remark =? where exp_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, exp.getExp_ac());
			ps.setInt(2, exp.getUserid());
			ps.setInt(3, exp.getExp_catid());
			ps.setDouble(4, exp.getAmount());
			java.sql.Date dt = new java.sql.Date(exp.getTran_date().getTime());
			ps.setDate(5, dt);
			ps.setString(6, exp.getPayby());
			ps.setString(7, exp.getRemark());
			ps.setInt(8, exp.getExp_id());
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public void remove(int exp_id) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "delete from expenses where exp_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, exp_id);
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public Expenses find(int exp_id) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		Expenses exp = new Expenses();
		try {
			String sql = "select * from expenses where exp_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, exp_id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				exp.setExp_id(rs.getInt("exp_id"));
				exp.setExp_ac(rs.getString("exp_ac"));
				exp.setUserid(rs.getInt("userid"));
				exp.setExp_catid(rs.getInt("exp_catid"));
				exp.setAmount(rs.getDouble("amount"));
				java.sql.Date dt = rs.getDate("tran_date");
				exp.setTran_date(new java.util.Date(dt.getTime()));
				exp.setPayby(rs.getString("payby"));
				exp.setRemark(rs.getString("remark"));
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return exp;
	}

	public ArrayList<Expenses> findAll() {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<Expenses> listexp = new ArrayList<Expenses>();
		try {
			String sql = "select * from expenses";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Expenses exp = new Expenses();
				exp.setExp_id(rs.getInt("exp_id"));
				exp.setExp_ac(rs.getString("exp_ac"));
				exp.setUserid(rs.getInt("userid"));
				exp.setExp_catid(rs.getInt("exp_catid"));
				exp.setAmount(rs.getDouble("amount"));
				java.sql.Date dt = rs.getDate("tran_date");
				exp.setTran_date(new java.util.Date(dt.getTime()));
				exp.setPayby(rs.getString("payby"));
				exp.setRemark(rs.getString("remark"));
				listexp.add(exp);
			}
		} catch (SQLException sq) {
			System.out.println("unable to find the record." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return listexp;
	}
     
	public ArrayList<Expenses> findAll(int userid) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<Expenses> listexp = new ArrayList<Expenses>();
		try {
			String sql = "select * from expenses where userid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Expenses exp = new Expenses();
				exp.setExp_id(rs.getInt("exp_id"));
				exp.setExp_ac(rs.getString("exp_ac"));
				exp.setUserid(userid);
				exp.setUserid(rs.getInt("userid"));
				exp.setExp_catid(rs.getInt("exp_catid"));
				exp.setAmount(rs.getDouble("amount"));
				java.sql.Date dt = rs.getDate("tran_date");
				exp.setTran_date(new java.util.Date(dt.getTime()));
				exp.setPayby(rs.getString("payby"));
				exp.setRemark(rs.getString("remark"));
				listexp.add(exp);
			}
		} catch (SQLException sq) {
			System.out.println("unable to find the record." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return listexp;
	}
	  public ArrayList<Expenses> findAllByDateWise(String sDate, String eDate, int userid){
			ConnectionPool pool = ConnectionPool.getInstance();
			pool.initialize();
			Connection conn = pool.getConnection();
			ArrayList<Expenses> listexp = new ArrayList<Expenses>();
			try {
				String sql = "select * from expenses where tran_date between ? and ? and userid=?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, sDate);
				ps.setString(2, eDate);
				ps.setInt(3, userid);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					Expenses exp = new Expenses();
					exp.setExp_id(rs.getInt("exp_id"));
					exp.setExp_ac(rs.getString("exp_ac"));
					exp.setUserid(userid);
					exp.setUserid(rs.getInt("userid"));
					exp.setExp_catid(rs.getInt("exp_catid"));
					exp.setAmount(rs.getDouble("amount"));
					java.sql.Date dt = rs.getDate("tran_date");
					exp.setTran_date(new java.util.Date(dt.getTime()));
					exp.setPayby(rs.getString("payby"));
					exp.setRemark(rs.getString("remark"));
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
		
		  java.util.Date dt = DateUtils.convertDate("2018-04-28"); ExpensesDao dc = new
		  ExpensesDao(); Expenses obj = new Expenses("Party", 1 , 1, 500 ,dt, "Cash", "Birthday Party");
		  dc.create(obj);
		 

		
		 /* java.util.Date dt = DateUtils.convertDate("19-04-2018");
		  Expenses exp = new  Expenses(1, "Electricity",  123344  , 2134, 1024 ,dt, "Cash", "NetBill");
		  ExpensesDao cd = new ExpensesDao();
		  cd.edit(exp);*/
		 

//	 ExpensesDao cd = new ExpensesDao();
//	 cd.remove(2);

//		 ExpensesDao cd = new ExpensesDao();
//		 System.out.println(cd.find(2));

		
		  /*ExpensesDao cd = new ExpensesDao();
		  ArrayList<Expenses> al = cd.findAll();
		      for (Expenses exp : al) {
		    	  System.out.println(exp); }*/
		 
		     /* ExpensesDao cd = new ExpensesDao();
			  ArrayList<Expenses> al = cd.findAll(123344);
			      for (Expenses exp : al) {
			    	  System.out.println(exp); }*/
               
//			     ExpensesDao cd = new ExpensesDao();
//				  ArrayList<Expenses> al = cd. findAllByDateWise("2018-10-12", "2018-10-12",123344);
//				      for (Expenses exp : al) {
//				    	  System.out.println(exp); 
//				    	  }
			      
	}
}
