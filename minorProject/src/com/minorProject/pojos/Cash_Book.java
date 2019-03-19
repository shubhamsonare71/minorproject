package com.minorProject.pojos;

import java.util.Date;

public class Cash_Book {
    private int acid;
    private String account;
    private Date tran_date;
    private double amount;
    private int userid;
    private String operation;
	
    public Cash_Book(int acid, String account, Date tran_date, double amount, int userid, String operation) {
		super();
		this.acid = acid;
		this.account = account;
		this.tran_date = tran_date;
		this.amount = amount;
		this.userid = userid;
		this.operation = operation;
	}
	public Cash_Book(String account, Date tran_date, double amount, int userid, String operation) {
		super();
		this.account = account;
		this.tran_date = tran_date;
		this.amount = amount;
		this.userid = userid;
		this.operation = operation;
	}
	public Cash_Book() {
		super();
	}
	public int getAcid() {
		return acid;
	}
	public void setAcid(int acid) {
		this.acid = acid;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public Date getTran_date() {
		return tran_date;
	}
	public void setTran_date(Date tran_date) {
		this.tran_date = tran_date;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	@Override
	public String toString() {
		return "Cash_Book [acid=" + acid + ", account=" + account + ", tran_date=" + tran_date + ", amount=" + amount
				+ ", userid=" + userid + ", operation=" + operation + "]";
	}
	
}
