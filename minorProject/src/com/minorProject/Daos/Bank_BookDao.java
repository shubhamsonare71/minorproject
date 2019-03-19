package com.minorProject.Daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.minorProject.pojos.Bank_Book;
import com.minorProject.utilities.ConnectionPool;
import com.minorProject.utilities.DateUtils;

public class Bank_BookDao {
	public void create(Bank_Book bankbook) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "insert into bank_book (account,tran_date,amount,userid,operation) values(?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, bankbook.getAccount());
			java.sql.Date dt = new java.sql.Date(bankbook.getTran_date().getTime());
			ps.setDate(2, dt);
			ps.setDouble(3, bankbook.getAmount());
			ps.setInt(4, bankbook.getUserid());
			ps.setString(5, bankbook.getOperation());
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public void edit(Bank_Book bankbook) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "update bank_book set account = ?, tran_date = ?,amount = ?, userid = ?, operation =? where acid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, bankbook.getAccount());
			java.sql.Date dt = new java.sql.Date(bankbook.getTran_date().getTime());
			ps.setDate(2, dt);
			ps.setDouble(3, bankbook.getAmount());
			ps.setInt(4, bankbook.getUserid());
			ps.setString(5, bankbook.getOperation());
			ps.setInt(6, bankbook.getAcid());
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
			String sql = "delete from bank_book where acid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, acid);
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public Bank_Book find(int acid) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		Bank_Book bankbook = new Bank_Book();
		try {
			String sql = "select * from bank_book where acid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, acid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				bankbook.setAcid(acid);
				bankbook.setAccount(rs.getString("account"));
				java.sql.Date dt = rs.getDate("tran_date");
				bankbook.setTran_date(new java.util.Date(dt.getTime()));
				bankbook.setUserid(rs.getInt("userid"));
				bankbook.setOperation(rs.getString("operation"));
				}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return bankbook;
	}

	public ArrayList<Bank_Book> findAll() {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<Bank_Book> listbankbook = new ArrayList<Bank_Book>();
		try {
			String sql = "select * from bank_book";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Bank_Book bankbook = new Bank_Book();
				bankbook.setAcid(rs.getInt("acid"));
				bankbook.setAccount(rs.getString("account"));
				java.sql.Date dt = rs.getDate("tran_date");
				bankbook.setTran_date(new java.util.Date(dt.getTime()));
				bankbook.setAmount(rs.getDouble("amount"));
				bankbook.setUserid(rs.getInt("userid"));
				bankbook.setOperation(rs.getString("operation"));
				listbankbook.add(bankbook);
			}
		} catch (SQLException sq) {
			System.out.println("unable to find the record." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return listbankbook;
	}
	   public ArrayList<Bank_Book> findAllByDateWise(String sDate, String eDate, int userid){
			ConnectionPool pool = ConnectionPool.getInstance();
			pool.initialize();
			Connection conn = pool.getConnection();
			ArrayList<Bank_Book> listbankbook = new ArrayList<Bank_Book>();
			try {
				String sql = "select * from bank_book where tran_date between ? and ? and userid=?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, sDate);
				ps.setString(2, eDate);
				ps.setInt(3, userid);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					Bank_Book bankbook = new Bank_Book();
					bankbook.setAcid(rs.getInt("acid"));
					bankbook.setAccount(rs.getString("account"));
					java.sql.Date dt = rs.getDate("tran_date");
					bankbook.setTran_date(new java.util.Date(dt.getTime()));
					bankbook.setAmount(rs.getDouble("amount"));
					bankbook.setUserid(userid);
					bankbook.setOperation(rs.getString("operation"));
					listbankbook.add(bankbook);
				}
			} catch (SQLException sq) {
				System.out.println("unable to find the record." + sq);
			} finally {
				pool.putConnection(conn);
			}
			return listbankbook;
}
	   
	   
	   public double closingBalance(int userid) {
			ConnectionPool pool = ConnectionPool.getInstance();
			pool.initialize();
			Connection conn = pool.getConnection();
			double closing =0.0;
			try {
				String sql = "select (SELECT sum(amount) as total_payment FROM bank_book b where userid = ? and operation "
						+ "='recieve') - (SELECT sum(amount) as total_receivied FROM bank_book b where userid = ? and "
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
	   
	   public double ExpBalance(int userid) {
			ConnectionPool pool = ConnectionPool.getInstance();
			pool.initialize();
			Connection conn = pool.getConnection();
			double Exp =0.0;
			try {
				String sql = "select (SELECT sum(amount) as total_payment FROM bank_book b where userid = ? and operation "
						+ "='pay')as Exp";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, userid);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					Exp = rs.getDouble("Exp");
				}
				
			} catch (SQLException sq) {
				System.out.println("Unable to find all rows." + sq);
			} finally {
				pool.putConnection(conn);
			}
			return Exp;
		}
	   
       public static void main(String args[]) {
//    	  java.util.Date dt = DateUtils.convertDate("20-2-2017");
//  		  Bank_BookDao dc = new Bank_BookDao(); 
//  		  Bank_Book obj = new Bank_Book("SBI232024", dt, 140000, 1, "recieve"); 
//  		  dc.create(obj);
       
  		 

//    	  java.util.Date dt = DateUtils.convertDate("10-12-2011");
//  		  Bank_Book bankbook = new Bank_Book(28,"RBI232024", dt, 40000, 1, "receive");
//  		  Bank_BookDao cd = new Bank_BookDao(); 
//  		  cd.edit(bankbook);
  		 

  		
//  		 Bank_BookDao cd = new Bank_BookDao();
//  		 cd.remove(12);
  		 

  		
//  		    Bank_BookDao cd = new Bank_BookDao();
//  		    System.out.println(cd.find(10));
  		 

  		/*Bank_BookDao cd = new Bank_BookDao();
  		ArrayList<Bank_Book> al = cd.findAll();
  		for (Bank_Book bankbook : al) {
  			System.out.println(bankbook);
  			}*/
//  		Bank_BookDao cd = new Bank_BookDao();
//  	    ArrayList<Bank_Book> al = cd.findAllByDateWise("2010-12-11","2017-02-19", 42);
//  		for (Bank_Book bankbook : al) {
//  			System.out.println(bankbook);
//
//       }
		
  		  Bank_BookDao cd = new Bank_BookDao();
          System.out.println(cd.closingBalance(40));
 
}
}