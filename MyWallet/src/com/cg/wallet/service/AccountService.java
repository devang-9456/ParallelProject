package com.cg.wallet.service;

import java.util.List;

import com.cg.wallet.dto.Account;
import com.cg.wallet.dto.Transactions;

public interface AccountService {

	public void createAccount(Account acc);
	public void createTransaction(Transactions tr);
	public List<Account> showAllAccounts();
	public double showBalance(long accId);
	public double deposit(long accId, double amount);
	public double withdraw(long accId, double amount);
	public boolean fundTransfer(long accId1, double amount, long accId2);
	public List<Transactions> showTransactionByAccountId(long accId);
	public Account showMyAccountInfo(long accId);
	public long getAccId();
	public int getTranSeq();
}
