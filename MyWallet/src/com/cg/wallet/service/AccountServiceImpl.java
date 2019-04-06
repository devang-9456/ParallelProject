package com.cg.wallet.service;

import java.util.List;

import com.cg.wallet.dao.AccountDao;
import com.cg.wallet.dao.AccountDaoImpl;
import com.cg.wallet.dto.Account;
import com.cg.wallet.dto.Transactions;

public class AccountServiceImpl implements AccountService {

	private AccountDao dao = new AccountDaoImpl();
	
	@Override
	public void createAccount(Account acc) {
		dao.addAccount(acc);

	}

	@Override
	public void createTransaction(Transactions tr) {
		dao.addTransaction(tr);

	}

	@Override
	public List<Account> showAllAccounts() {
		// TODO Auto-generated method stub
		return dao.showAllAccounts();
	}

	@Override
	public double showBalance(long accId) {
		// TODO Auto-generated method stub
		return dao.showBalance(accId);
	}

	@Override
	public double deposit(long accId, double amount) {
		// TODO Auto-generated method stub
		return dao.deposit(accId, amount);
	}

	@Override
	public double withdraw(long accId, double amount) {
		// TODO Auto-generated method stub
		return dao.withdraw(accId, amount);
	}

	@Override
	public boolean fundTransfer(long accId1, double amount, long accId2) {
		// TODO Auto-generated method stub
		return dao.fundTransfer(accId1, amount, accId2);
	}

	@Override
	public List<Transactions> showTransactionByAccountId(long accId) {
		// TODO Auto-generated method stub
		return dao.showTransactions(accId);
	}

	@Override
	public Account showMyAccountInfo(long accId) {
		// TODO Auto-generated method stub
		return dao.showMyAccountInfo(accId);
	}

	@Override
	public long getAccId() {
		// TODO Auto-generated method stub
		return dao.getAccId();
	}

	@Override
	public int getTranSeq() {
		// TODO Auto-generated method stub
		return dao.getTranSeq();
	}

}
