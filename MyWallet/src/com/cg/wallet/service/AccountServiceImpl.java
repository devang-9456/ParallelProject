package com.cg.wallet.service;

import java.util.List;

import com.cg.wallet.dao.AccountDao;
import com.cg.wallet.dao.AccountDaoImpl;
import com.cg.wallet.dto.Account;
import com.cg.wallet.dto.Transactions;
import com.cg.wallet.exception.NotFoundException;

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
		try {
			return dao.showBalance(accId);
		} catch (NotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public double deposit(long accId, double amount) {
		// TODO Auto-generated method stub
		try {
			return dao.deposit(accId, amount);
		} catch (NotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return amount;
	}

	@Override
	public double withdraw(long accId, double amount) {
		// TODO Auto-generated method stub
		try {
			return dao.withdraw(accId, amount);
		} catch (NotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return amount;
	}

	@Override
	public boolean fundTransfer(long accId1, double amount, long accId2) {
		// TODO Auto-generated method stub
		try {
			return dao.fundTransfer(accId1, amount, accId2);
		} catch (NotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Transactions> showTransactionByAccountId(long accId) {
		// TODO Auto-generated method stub
		try {
			return dao.showTransactions(accId);
		} catch (NotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Account showMyAccountInfo(long accId) {
		// TODO Auto-generated method stub
		try {
			return dao.showMyAccountInfo(accId);
		} catch (NotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
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
