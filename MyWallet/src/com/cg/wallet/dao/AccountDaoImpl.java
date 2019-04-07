package com.cg.wallet.dao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.cg.wallet.dto.Account;
import com.cg.wallet.dto.Transactions;
import com.cg.wallet.exception.NotFoundException;
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
		StaticDB.getTransactionEntries().put(tr.getTransSeq(), tr);
		System.out.println("Transaction added");
	}

	@Override
	public double showBalance(long accId) throws NotFoundException {

		Account account = StaticDB.getAccountEntries().get(accId);
		if(account == null) {
			throw new NotFoundException("Account doesn't exist.");
		}
		double balance=account.getBalance();
		return balance;
	}

	@Override
	public double deposit(long accId, double amount) throws NotFoundException {
		Account account = StaticDB.getAccountEntries().get(accId);
		if(account == null) {
			throw new NotFoundException("Account doesn't exist.");
		}
		incBalance(accId, amount);
		long tId=accId*10+1;
		LocalDateTime now = LocalDateTime.now(); 
		Transactions ts=new Transactions(++StaticDB.tSeq, tId, "Deposit", amount, StaticDB.getAccountEntries().get(accId).getBalance(), dtf.format(now));
		addTransaction(ts);
		return StaticDB.getAccountEntries().get(accId).getBalance();
	}

	@Override
	public double withdraw(long accId, double amount) throws NotFoundException {
		Account account = StaticDB.getAccountEntries().get(accId);
		if(account == null) {
			throw new NotFoundException("Account doesn't exist.");
		}
		double bal = StaticDB.getAccountEntries().get(accId).getBalance();
		if(bal>=amount){
		decBalance(accId,amount);
		long tId=accId*10+1;
		LocalDateTime now = LocalDateTime.now();
		Transactions ts=new Transactions(++StaticDB.tSeq, tId, "Withdraw", amount, StaticDB.getAccountEntries().get(accId).getBalance(), dtf.format(now));
		addTransaction(ts);
		return StaticDB.getAccountEntries().get(accId).getBalance();
		}else{
			System.out.println("Invalid withdrawal amount. Insufficient balance.");
			return StaticDB.getAccountEntries().get(accId).getBalance();
		}
	}

	@Override
	public boolean fundTransfer(long accId1, double amount, long accId2) throws NotFoundException {
		Account account1 = StaticDB.getAccountEntries().get(accId1);
		Account account2 = StaticDB.getAccountEntries().get(accId2);
		if(account1 == null||account2 == null) {
			throw new NotFoundException("Account doesn't exist.");
		}
		double bal = StaticDB.getAccountEntries().get(accId1).getBalance();
		if(bal>=amount){
			decBalance(accId1, amount);
			incBalance(accId2, amount);
			long tId1 = accId1*10+1;
			long tId2 = accId2*10+1;
			LocalDateTime now = LocalDateTime.now();
			Transactions ts1 = new Transactions(++StaticDB.tSeq, tId1,"Transfer",amount,StaticDB.getAccountEntries().get(accId1).getBalance(),dtf.format(now));
			addTransaction(ts1);
			Transactions ts2 = new Transactions(++StaticDB.tSeq, tId2,"Transfer",amount,StaticDB.getAccountEntries().get(accId2).getBalance(),dtf.format(now));
			addTransaction(ts2);
			return true;
		}
		return false;
	}

	@Override
	public List<Transactions> showTransactions(long accId) throws NotFoundException {
		Account account = StaticDB.getAccountEntries().get(accId);
		if(account == null) {
			throw new NotFoundException("Account doesn't exist.");
		}
		List<Transactions> tranList= new ArrayList<Transactions>(StaticDB.getTransactionEntries().values());
		List<Transactions> sortTranList=new ArrayList<Transactions>();
		long tId=accId*10+1;
		for(Transactions ts:tranList){
			if(ts.getTransId()==tId){
				sortTranList.add(ts);
			}
		}
		return sortTranList;
	}

	@Override
	public Account showMyAccountInfo(long accId) throws NotFoundException {
		Account account = StaticDB.getAccountEntries().get(accId);
		if(account == null) {
			throw new NotFoundException("Account doesn't exist.");
		}
		return StaticDB.getAccountEntries().get(accId);
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
		List<Account> tranList= new ArrayList<Account>(StaticDB.getAccountEntries().values());
		return tranList;
	}

	@Override
	public long getAccId() {
		// TODO Auto-generated method stub
		return ++StaticDB.accId;
	}

	@Override
	public int getTranSeq() {
		// TODO Auto-generated method stub
		return ++StaticDB.tSeq;
	}

}
