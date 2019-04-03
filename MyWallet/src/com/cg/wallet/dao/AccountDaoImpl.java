package com.cg.wallet.dao;

import java.time.format.DateTimeFormatter;
import java.util.List;

import com.cg.wallet.dto.Account;
import com.cg.wallet.dto.Transactions;
import com.cg.wallet.util.StaticDB;

public class AccountDaoImpl implements AccountDao {

	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	
	@Override
	public void addAccount(Account acc) {
		StaticDB.getAccountEntries().put(acc.getaccNo(), acc);
		System.out.println(acc.getaccNo()+"  Account added.");
	}

	@Override
	public void addTransaction(Transactions tr) {
		StaticDB.getTransactionEntries().put(tr.getTransId(), tr);
		System.out.println("Transaction added");
	}

	@Override
	public double showBalance(long accId) {
		return StaticDB.getAccountEntries().get(accId).getBalance();
	}

	@Override
	public double deposit(long accId, double amount) {
		incBalance(accId, amount);
		long tid;
		tid=accId*10+1;
		int tseq=StaticDB.getTransactionEntries().get(tid).getTransSeq()+1;
		
		return 0;
	}

	@Override
	public double withdraw(long accId, double amount) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean fundTransfer(long accId1, double amount, long accId2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Transactions> showTransactions(long accId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account showMyAccountInfo(long accId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void decBalance(long accId, double amt) {
		double balance = StaticDB.getAccountEntries().get(accId).getBalance()-amt;
		StaticDB.getAccountEntries().get(accId).setBalance(balance);
	}

	@Override
	public void incBalance(long accId, double amt) {
		double balance = StaticDB.getAccountEntries().get(accId).getBalance()+amt;
		StaticDB.getAccountEntries().get(accId).setBalance(balance);
	}

	@Override
	public List<Account> showAllAccounts() {
		// TODO Auto-generated method stub
		return null;
	}

}
