package com.cg.wallet.dto;

public class Transactions {

	private long transId;
	private int transSeq;
	private String tType;
	private double amount;
	private String date;
	
	public Transactions() {
		// TODO Auto-generated constructor stub
	}

	public Transactions(long transId, int transSeq, String tType, double amount, String date) {
		super();
		this.transId = transId;
		this.transSeq = transSeq;
		this.tType = tType;
		this.amount = amount;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
}
