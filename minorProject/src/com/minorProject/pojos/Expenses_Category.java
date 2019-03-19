package com.minorProject.pojos;

public class Expenses_Category {
               private int exp_catid;
               private String  exp_catname;
               private String exp_catdetail;
               private int userid;
			public Expenses_Category() {
				super();
			}
			public Expenses_Category(String exp_catname, String exp_catdetail, int userid) {
				super();
				this.exp_catname = exp_catname;
				this.exp_catdetail = exp_catdetail;
				this.userid = userid;
			}
			public Expenses_Category(int exp_catid, String exp_catname, String exp_catdetail, int userid) {
				super();
				this.exp_catid = exp_catid;
				this.exp_catname = exp_catname;
				this.exp_catdetail = exp_catdetail;
				this.userid = userid;
			}
			public int getExp_catid() {
				return exp_catid;
			}
			public void setExp_catid(int exp_catid) {
				this.exp_catid = exp_catid;
			}
			public String getExp_catname() {
				return exp_catname;
			}
			public void setExp_catname(String exp_catname) {
				this.exp_catname = exp_catname;
			}
			public String getExp_catdetail() {
				return exp_catdetail;
			}
			public void setExp_catdetail(String exp_catdetail) {
				this.exp_catdetail = exp_catdetail;
			}
			public int getUserid() {
				return userid;
			}
			public void setUserid(int userid) {
				this.userid = userid;
			}
			@Override
			public String toString() {
				return "Expenses_Category [exp_catid=" + exp_catid + ", exp_catname=" + exp_catname + ", exp_catdetail="
						+ exp_catdetail + ", userid=" + userid + "]";
			}
               
               
			
}
