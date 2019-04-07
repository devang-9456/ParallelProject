package com.cg.wallet.dao;

import java.util.List;

import com.cg.wallet.dto.Account;
import com.cg.wallet.dto.Transactions;
import com.cg.wallet.exception.NotFoundException;

public interface AccountDao {

	public void addAccount(Account acc);
	public void addTransaction(Transactions tr);
	public List<Account> showAllAccounts();
	public double showBalance(long accId) throws NotFoundException;
	public double deposit(long accId, double amount) throws NotFoundException;
	public double withdraw(long accId, double amount) throws NotFoundException;
	public boolean fundTransfer(long accId1, double amount, long accId2) throws NotFoundException;
	public List<Transactions> showTransactions(long accId) throws NotFoundException;
	public Account showMyAccountInfo(long accId) throws NotFoundException;
	public void decBalance(long accId, double amt);
	public void incBalance(long accId, double amt);
	public long getAccId();
	public int getTranSeq();
}
