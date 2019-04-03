package com.cg.wallet.dto;

public class Account {
	
	private long accNo;
	private String accHolderName;
	private double balance;
	private Transactions tr;
	
	public Account() {
		// TODO Auto-generated constructor stub
	}

	public Account(long accNo, String accHolderName, double balance,
			Transactions tr) {
		super();
		this.accNo = accNo;
		this.accHolderName = accHolderName;
		this.balance = balance;
		this.tr = tr;
	}

	public long getaccNo() {
		return accNo;
	}

	public void setaccNo(long accNo) {
		this.accNo = accNo;
	}

	public String getAccHolderName() {
		return accHolderName;
	}

	public void setAccHolderName(String accHolderName) {
		this.accHolderName = accHolderName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Transactions getTr() {
		return tr;
	}

	public void setTr(Transactions tr) {
		this.tr = tr;
	}
	
}
