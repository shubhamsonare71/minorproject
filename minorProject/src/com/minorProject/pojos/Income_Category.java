package com.minorProject.pojos;

public class Income_Category {
                 private int inc_catid;
                 private String inc_catname;
                 private String inc_catdetail;
                 private int  userid;
				public Income_Category() {
					super();
				}
				public Income_Category(String inc_catname, String inc_catdetail, int userid) {
					super();
					this.inc_catname = inc_catname;
					this.inc_catdetail = inc_catdetail;
					this.userid = userid;
				}
				public Income_Category(int inc_catid, String inc_catname, String inc_catdetail, int userid) {
					super();
					this.inc_catid = inc_catid;
					this.inc_catname = inc_catname;
					this.inc_catdetail = inc_catdetail;
					this.userid = userid;
				}
				public int getInc_catid() {
					return inc_catid;
				}
				public void setInc_catid(int inc_catid) {
					this.inc_catid = inc_catid;
				}
				public String getInc_catname() {
					return inc_catname;
				}
				public void setInc_catname(String inc_catname) {
					this.inc_catname = inc_catname;
				}
				public String getInc_catdetail() {
					return inc_catdetail;
				}
				public void setInc_catdetail(String inc_catdetail) {
					this.inc_catdetail = inc_catdetail;
				}
				public int getUserid() {
					return userid;
				}
				public void setUserid(int userid) {
					this.userid = userid;
				}
				@Override
				public String toString() {
					return "Income_Category [inc_catid=" + inc_catid + ", inc_catname=" + inc_catname
							+ ", inc_catdetail=" + inc_catdetail + ", userid=" + userid + "]";
				}
                 
                 
                 
}
