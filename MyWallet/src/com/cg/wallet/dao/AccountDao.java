package com.cg.wallet.dao;

import java.util.List;

import com.cg.wallet.dto.Account;
import com.cg.wallet.dto.Transactions;

public interface AccountDao {

	public void addAccount(Account acc);
	public void addTransaction(Transactions tr);
	public List<Account> showAllAccounts();
	public double showBalance(long accId);
	public double deposit(long accId, double amount);
	public double withdraw(long accId, double amount);
	public boolean fundTransfer(long accId1, double amount, long accId2);
	public List<Transactions> showTransactions(long accId);
	public Account showMyAccountInfo(long accId);
	public void decBalance(long accId, double amt);
	public void incBalance(long accId, double amt);
}
