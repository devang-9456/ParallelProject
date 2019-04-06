package com.cg.wallet.dto;

public class Transactions {

	private int transSeq;
	private long transId;
	private String tType;
	private double amount;
	private double balance;
	private String date;
	
	public Transactions() {
		// TODO Auto-generated constructor stub
	}

	public Transactions(int transSeq, long transId, String tType, double amount, double balance, String date) {
		super();
		this.transId = transId;
		this.transSeq = transSeq;
		this.tType = tType;
		this.amount = amount;
		this.balance=balance;
		this.date=date;
	}

	public long getTransId() {
		return transId;
	}

	public void setTransId(long transId) {
		this.transId = transId;
	}

	public int getTransSeq() {
		return transSeq;
	}

	public void setTransSeq(int transSeq) {
		this.transSeq = transSeq;
	}

	public String gettType() {
		return tType;
	}

	public void settType(String tType) {
		this.tType = tType;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Transactions [Transaction Sequence = " + transSeq + ", Transaction ID = " + transId
				+ ", Transaction Type = " + tType + ", \n\tAmount = " + amount + ", Balance = "
				+ balance + ", Transaction Date = " + date + "]\n";
	}
	
}
