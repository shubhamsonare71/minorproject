package com.minorProject.pojos;

import java.io.InputStream;

import com.mysql.jdbc.Blob;

public class Users {
                      private int uid;
                      private String username;
                      private String password;
                      private String name;
                      private String address;
                      private String mobile;
                      private String email;
                      private InputStream img;
					
                      public Users() {
						super();
					}
					
                      public Users(String username, String password, String name, String address, String mobile,
							String email) {
						super();
						this.username = username;
						this.password = password;
						this.name = name;
						this.address = address;
						this.mobile = mobile;
						this.email = email;
			    }
					public Users(int uid, String username, String password, String name, String address, String mobile,
							String email,InputStream img) {
						super();
						this.uid = uid;
						this.username = username;
						this.password = password;
						this.name = name;
						this.address = address;
						this.mobile = mobile;
						this.email = email;
						this.img = img;
					}
					
					public Users(int uid, String username, String password, String name, String address, String mobile,
							String email) {
						super();
						this.uid = uid;
						this.username = username;
						this.password = password;
						this.name = name;
						this.address = address;
						this.mobile = mobile;
						this.email = email;
					}
					public InputStream getImg() {
						return img;
					}
					public void setImg(InputStream img) {
						this.img = img;
					}
					public int getUid() {
						return uid;
					}
					public Users(String username, String password, String name, String address, String mobile,
							String email, InputStream img) {
						super();
						this.username = username;
						this.password = password;
						this.name = name;
						this.address = address;
						this.mobile = mobile;
						this.email = email;
						this.img = img;
					}
					public void setUid(int uid) {
						this.uid = uid;
					}
					public String getUsername() {
						return username;
					}
					public void setUsername(String username) {
						this.username = username;
					}
					public String getPassword() {
						return password;
					}
					public void setPassword(String password) {
						this.password = password;
					}
					public String getName() {
						return name;
					}
					public void setName(String name) {
						this.name = name;
					}
					public String getAddress() {
						return address;
					}
					public void setAddress(String address) {
						this.address = address;
					}
					public String getMobile() {
						return mobile;
					}
					public void setMobile(String mobile) {
						this.mobile = mobile;
					}
					public String getEmail() {
						return email;
					}
					public void setEmail(String email) {
						this.email = email;
					}
			
					
					
					@Override
					public String toString() {
						return "Users [uid=" + uid + ", username=" + username + ", password=" + password + ", name="
								+ name + ", address=" + address + ", mobile=" + mobile + ", email=" + email + "]";
					}
                      
}
