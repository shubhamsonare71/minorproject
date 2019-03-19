package com.minorProject.Daos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.minorProject.pojos.Incomes;
import com.minorProject.pojos.Incomes;
import com.minorProject.pojos.Incomes;
import com.minorProject.utilities.ConnectionPool;
import com.minorProject.utilities.DateUtils;
public class IncomesDao {
	public void create(Incomes inc) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "insert into incomes (inc_ac, userid, inc_catid, amount, tran_date, recievby, remark) values(?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, inc.getInc_ac());
			ps.setInt(2, inc.getUserid());
			ps.setInt(3, inc.getInc_catid());
			ps.setDouble(4, inc.getAmount());
			java.sql.Date dt = new java.sql.Date(inc.getTran_date().getTime());
			ps.setDate(5, dt);
			ps.setString(6, inc.getReceivby());
			ps.setString(7, inc.getRemark());
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public void edit(Incomes inc) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "update incomes set inc_ac = ?, userid = ?, inc_catid = ?, amount = ?, tran_date = ?, recievby = ?, remark =? where inc_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, inc.getInc_ac());
			ps.setInt(2, inc.getUserid());
			ps.setInt(3, inc.getInc_catid());
			ps.setDouble(4, inc.getAmount());
			java.sql.Date dt = new java.sql.Date(inc.getTran_date().getTime());
			ps.setDate(5, dt);
			ps.setString(6, inc.getReceivby());
			ps.setString(7, inc.getRemark());
			ps.setInt(8, inc.getInc_id());
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public void remove(int inc_id) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "delete from incenses where inc_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, inc_id);
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public Incomes find(int inc_id) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		Incomes inc = new Incomes();
		try {
			String sql = "select * from incenses where inc_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, inc_id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				inc.setInc_id(rs.getInt("inc_id"));
				inc.setInc_ac(rs.getString("inc_ac"));
				inc.setUserid(rs.getInt("userid"));
				inc.setInc_catid(rs.getInt("inc_catid"));
				inc.setAmount(rs.getDouble("amount"));
				java.sql.Date dt = rs.getDate("tran_date");
				inc.setTran_date(new java.util.Date(dt.getTime()));
				inc.setReceivby(rs.getString("recievby"));
				inc.setRemark(rs.getString("remark"));
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return inc;
	}

	public ArrayList<Incomes> findAll() {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<Incomes> listinc = new ArrayList<Incomes>();
		try {
			String sql = "select * from incomes";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Incomes inc = new Incomes();
				inc.setInc_id(rs.getInt("inc_id"));
				inc.setInc_ac(rs.getString("inc_ac"));
				inc.setUserid(rs.getInt("userid"));
				inc.setInc_catid(rs.getInt("inc_catid"));
				inc.setAmount(rs.getDouble("amount"));
				java.sql.Date dt = rs.getDate("tran_date");
				inc.setTran_date(new java.util.Date(dt.getTime()));
				inc.setReceivby(rs.getString("recievby"));
				inc.setRemark(rs.getString("remark"));
				listinc.add(inc);
			}
		} catch (SQLException sq) {
			System.out.println("unable to find the record." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return listinc;
	}
	public ArrayList<Incomes> findAll(int userid) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<Incomes> listinc = new ArrayList<Incomes>();
		try {
			String sql = "select * from incomes where userid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Incomes inc = new Incomes();
				inc.setInc_id(rs.getInt("inc_id"));
				inc.setInc_ac(rs.getString("inc_ac"));
				inc.setUserid(userid);
				inc.setUserid(rs.getInt("userid"));
				inc.setInc_catid(rs.getInt("inc_catid"));
				inc.setAmount(rs.getDouble("amount"));
				java.sql.Date dt = rs.getDate("tran_date");
				inc.setTran_date(new java.util.Date(dt.getTime()));
				inc.setReceivby(rs.getString("recievby"));
				inc.setRemark(rs.getString("remark"));
				listinc.add(inc);
			}
		} catch (SQLException sq) {
			System.out.println("unable to find the record." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return listinc;
	}
	  public ArrayList<Incomes> findAllByDateWise(String sDate, String eDate, int userid){
			ConnectionPool pool = ConnectionPool.getInstance();
			pool.initialize();
			Connection conn = pool.getConnection();
			ArrayList<Incomes> listinc = new ArrayList<Incomes>();
			try {
				String sql = "select * from incomes where tran_date between ? and ? and userid=?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, sDate);
				ps.setString(2, eDate);
				ps.setInt(3, userid);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					Incomes inc = new Incomes();
					inc.setInc_id(rs.getInt("inc_id"));
					inc.setInc_ac(rs.getString("inc_ac"));
					inc.setUserid(userid);
					inc.setUserid(rs.getInt("userid"));
					inc.setInc_catid(rs.getInt("inc_catid"));
					inc.setAmount(rs.getDouble("amount"));
					java.sql.Date dt = rs.getDate("tran_date");
					inc.setTran_date(new java.util.Date(dt.getTime()));
					inc.setReceivby(rs.getString("recievby"));
					inc.setRemark(rs.getString("remark"));
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
		
		  java.util.Date dt = DateUtils.convertDate("2018-04-28");
		  IncomesDao dc = new IncomesDao();
		  Incomes obj = new Incomes("Music Classes", 1  ,1, 2000 ,dt, "Cash", "Guitar");
		  dc.create(obj);
		 

		
		/*  java.util.Date dt = DateUtils.convertDate("10-12-2011");
		  Incomes inc = new  Incomes(1, "Electricity",  123344  , 2134, 1024 ,dt, "Cash", "NetBill");
		  IncomesDao cd = new IncomesDao();
		  cd.edit(inc);*/
		 

//		 IncomesDao cd = new IncomesDao();
//		 cd.remove(2);

//		 IncomesDao cd = new IncomesDao();
//		 System.out.println(cd.find(3));

		
	/*	  IncomesDao cd = new IncomesDao();
		  ArrayList<Incomes> al = cd.findAll();
		      for (Incomes inc : al) {
		    	  System.out.println(inc); }*/
		 
//		 IncomesDao cd = new IncomesDao();
//		  ArrayList<Incomes> al = cd.findAll(123344);
//		      for (Incomes inc : al) {
//		    	  System.out.println(inc); }
	}
}
