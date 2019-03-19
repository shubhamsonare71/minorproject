package com.minorProject.Daos;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.minorProject.pojos.Users;
import com.minorProject.utilities.ConnectionPool;
import com.minorProject.utilities.DateUtils;

public class UserDao {
	public void create(Users user) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "insert into users (username, password, name, address, mobile, email) values(?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getName());
			ps.setString(4, user.getAddress());
			ps.setString(5, user.getMobile());
			ps.setString(6, user.getEmail());

			
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public void edit(Users user) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "update users set username = ?, password = ?, name = ?, address = ?, mobile = ?, email = ? where uid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getName());
			ps.setString(4, user.getAddress());
			ps.setString(5, user.getMobile());
			ps.setString(6, user.getEmail());
			ps.setInt(7, user.getUid());
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public void remove(int uid) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "delete from users where uid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, uid);
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public Users find(int uid) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		Users user = new Users();
		try {
			String sql = "select * from users where uid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, uid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user.setUid(uid);
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setAddress(rs.getString("address"));
				user.setMobile(rs.getString("mobile"));
				user.setEmail(rs.getString("email"));
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return user;
	}

	public ArrayList<Users> findAll() {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<Users> listuser = new ArrayList<Users>();
		try {
			String sql = "select * from users";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Users user = new Users();
				user.setUid(rs.getInt("uid"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setAddress(rs.getString("address"));
				user.setMobile(rs.getString("mobile"));
				user.setEmail(rs.getString("email"));
				listuser.add(user);
			}
		} catch (SQLException sq) {
			System.out.println("unable to find the record." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return listuser;
	}
	public static int  checkAvailablity(String uname) {
		int id = -1;
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "select uid from users where username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, uname);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				id = rs.getInt("uid");
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return id;
			
		}
	
	public static int  checkAvailablity(String uname,String pass) {
		int id = -1;
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "select uid from users where username = ? and password=? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, uname);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				id = rs.getInt("uid");
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return id;
			
		}
	   
	public static Users authenticate(String un, String pwd) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		Users user = new Users();
		try {
			String sql = "select * from users where username = ? and password = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, un);
			ps.setString(2, pwd);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user.setUid(rs.getInt("uid"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setAddress(rs.getString("address"));
				user.setMobile(rs.getString("mobile"));
				user.setEmail(rs.getString("email"));
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return user;
	}
	    public static void main(String args[]) {

		
//		    UserDao dc = new UserDao();
//		       Users obj = new Users("#shubham_joshi", "545212", "Shubham joshi", "Harshwardhan nagar, Bhopal", "9584821284", "shubhamjoshi16@gmail.com");
//		       dc.create(obj);
		 

		
		  /*Users user = new Users(2, "@Shubhamjoshi", "Gymislife","shubham joshi","Harshwardhan nagar,Bhopal", "9584842187", "sj248@gmail.com");
		  UserDao cd = new UserDao();
		   cd.edit(user);*/
		 

		
//		      UserDao cd = new UserDao();
//		      cd.remove(224);
		 

		
//		  UserDao cd = new UserDao(); 
//		  System.out.println(cd.find(1));
		 

/*		UserDao cd = new UserDao();
		ArrayList<Users> al = cd.findAll();
		for (Users user : al) {
			System.out.println(user);
		}*/
 
		  UserDao cd = new UserDao(); 
	      System.out.println(cd.authenticate("@shubhamjoshi","Gymislife"));
			
//		  UserDao cd = new UserDao(); 
//		  System.out.println(cd.checkAvailablity("_shubham_sonare","nevergiveup"));	
	}

	public static boolean changePass(String newpass,String Email) {
		ConnectionPool pool = ConnectionPool.getInstance();
     	pool.initialize();
       Connection conn = pool.getConnection();
       try {
	               String sql = "update users set  password = ? where email = ?";
 	               PreparedStatement ps = conn.prepareStatement(sql);
 	               ps.setString(1, newpass);
 	               ps.setString(2, Email);
 	               int count = ps.executeUpdate();
 	               if(count!=0) {
 	            	     return true;
 	               }
 	              
       }
       catch(SQLException e) {
    	   e.printStackTrace();
       }
		return false;
	}
	
}
