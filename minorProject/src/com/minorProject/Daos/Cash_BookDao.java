package com.minorProject.Daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.minorProject.pojos.Bank_Book;
import com.minorProject.pojos.Cash_Book;
import com.minorProject.utilities.ConnectionPool;
import com.minorProject.utilities.DateUtils;

public class Cash_BookDao {

	public void create(Cash_Book cashbook) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "insert into cash_book (account,tran_date,amount,userid,operation) values(?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, cashbook.getAccount());
			java.sql.Date dt = new java.sql.Date(cashbook.getTran_date().getTime());
			ps.setDate(2, dt);
			System.out.println(dt);
			ps.setDouble(3, cashbook.getAmount());
			ps.setInt(4, cashbook.getUserid());
			ps.setString(5, cashbook.getOperation());
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public void edit(Cash_Book cashbook) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "update cash_book set account = ?, tran_date = ?,amount = ?, userid = ?, operation =? where acid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, cashbook.getAccount());
			java.sql.Date dt = new java.sql.Date(cashbook.getTran_date().getTime());
			ps.setDate(2, dt);
			ps.setDouble(3, cashbook.getAmount());
			ps.setInt(4, cashbook.getUserid());
			ps.setString(5, cashbook.getOperation());
			ps.setInt(6, cashbook.getAcid());
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public void remove(int acid) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "delete from cash_book where acid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, acid);
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public Cash_Book find(int acid) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		Cash_Book cashbook = new Cash_Book();
		try {
			String sql = "select * from cash_book where acid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, acid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				cashbook.setAcid(acid);
				cashbook.setAccount(rs.getString("account"));
				java.sql.Date dt = rs.getDate("tran_date");
				cashbook.setTran_date(new java.util.Date(dt.getTime()));
				cashbook.setAmount(rs.getInt("amount"));
				cashbook.setUserid(rs.getInt("userid"));
				cashbook.setOperation(rs.getString("operation"));
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return cashbook;
	}

	public ArrayList<Cash_Book> findAll() {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<Cash_Book> listcashbook = new ArrayList<Cash_Book>();
		try {
			String sql = "select * from cash_book";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Cash_Book cashbook = new Cash_Book();
				cashbook.setAcid(rs.getInt("acid"));
				cashbook.setAccount(rs.getString("account"));
				java.sql.Date dt = rs.getDate("tran_date");
				cashbook.setTran_date(new java.util.Date(dt.getTime()));
				cashbook.setAmount(rs.getDouble("amount"));
				cashbook.setUserid(rs.getInt("userid"));
				cashbook.setOperation(rs.getString("operation"));
				listcashbook.add(cashbook);
			}
		} catch (SQLException sq) {
			System.out.println("unable to find the record." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return listcashbook;
	}
	
	  public ArrayList<Cash_Book> findAllByDateWise(String sDate, String eDate, int userid){
			ConnectionPool pool = ConnectionPool.getInstance();
			pool.initialize();
			Connection conn = pool.getConnection();
			ArrayList<Cash_Book> listcashbook = new ArrayList<Cash_Book>();
			try {
				String sql = "select * from cash_book where tran_date between ? and ? and userid=?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, sDate);
				ps.setString(2, eDate);
				ps.setInt(3, userid);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					Cash_Book cashbook = new Cash_Book();
					cashbook.setAcid(rs.getInt("acid"));
					cashbook.setAccount(rs.getString("account"));
					java.sql.Date dt = rs.getDate("tran_date");
					cashbook.setTran_date(new java.util.Date(dt.getTime()));
					cashbook.setAmount(rs.getDouble("amount"));
					cashbook.setUserid(userid);
					cashbook.setOperation(rs.getString("operation"));
					listcashbook.add(cashbook);
				}
			} catch (SQLException sq) {
				System.out.println("unable to find the record." + sq);
			} finally {
				pool.putConnection(conn);
			}
			return listcashbook;
}
	  public double closingBalance(int userid) {
			ConnectionPool pool = ConnectionPool.getInstance();
			pool.initialize();
			Connection conn = pool.getConnection();
			double closing =0.0;
			try {
				String sql = "select (SELECT sum(amount) as total_payment FROM cash_book b where userid = ? and operation "
						+ "='recieve') - (SELECT sum(amount) as total_receivied FROM cash_book b where userid = ? and "
						+ "operation='pay') as 'Closing_Balance' from dual";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, userid);
				ps.setInt(2, userid);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					closing = rs.getDouble("Closing_Balance");
				}
				
			} catch (SQLException sq) {
				System.out.println("Unable to find all rows." + sq);
			} finally {
				pool.putConnection(conn);
			}
			return closing;
		}

	public static void main(String args[]) {
	     java.util.Date dt = DateUtils.convertDate("12-4-2018");
 		  Cash_BookDao dc = new Cash_BookDao(); 
 		  Cash_Book obj = new Cash_Book("RBI232024", dt, 360000, 1, "recieve"); 
 		  dc.create(obj);
 		  

    	/*  java.util.Date dt = DateUtils.convertDate("10-12-2011");
  		  Cash_Book bankbook = new Cash_Book(3,"ICICI232024", dt, 100000, 22, "Indirect");
  		  Cash_BookDao cd = new Cash_BookDao(); 
  		  cd.edit(bankbook);*/
  		 

  		
//      	 Cash_BookDao cd = new Cash_BookDao();
//  		 cd.remove(1);
  		 

  		
//              Cash_BookDao cd = new Cash_BookDao();
//   		     System.out.println(cd.find(3));
  		 
         
//		        Cash_BookDao cd = new Cash_BookDao();
//  		        ArrayList<Cash_Book> al = cd.findAll();
//  		        for (Cash_Book cashbook : al) {
//  			                     System.out.println(cashbook);
//  			}
    
// 		 Cash_BookDao cd = new Cash_BookDao();
//   	    ArrayList<Cash_Book> al = cd.findAllByDateWise("2018-12-16","2018-12-31", 1);
//   		for (Cash_Book bankbook : al) {
//   			System.out.println(bankbook);

 		  Cash_BookDao cd = new Cash_BookDao();
         System.out.println(cd.closingBalance(40));


        }
	}
	
	
