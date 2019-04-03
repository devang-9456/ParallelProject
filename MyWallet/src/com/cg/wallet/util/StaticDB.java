package com.cg.wallet.util;

import java.util.HashMap;
import java.util.Map;

import com.cg.wallet.dto.Account;
import com.cg.wallet.dto.Transactions;

public class StaticDB {
	
	private static Map<Long,Account> accountEntries=new HashMap<Long,Account>();
	private static Map<Long,Transactions> transactionEntries=new HashMap<Long,Transactions>();

	static{
		transactionEntries.put((long) 1011, new Transactions(1011,1,"Deposit",12000.0,"30/03/2019"));
		transactionEntries.put((long) 1021, new Transactions(1021,1,"Deposit",10000.0,"30/03/2019"));
		transactionEntries.put((long) 1031, new Transactions(1031,1,"Deposit",23000.0,"30/03/2019"));
		transactionEntries.put((long) 1041, new Transactions(1041,1,"Deposit",10000.0,"30/03/2019"));
		accountEntries.put((long) 101, new Account(101,"Devang Sinha",12000.0,new Transactions(1011,1,"Deposit",12000.0,"30/03/2019")));
		accountEntries.put((long) 102, new Account(102,"Aniket Pal",10000.0,new Transactions(1021,1,"Deposit",10000.0,"30/03/2019")));
		accountEntries.put((long) 103, new Account(103,"Umang Gupta",23000.0,new Transactions(1031,1,"Deposit",23000.0,"30/03/2019")));
		accountEntries.put((long) 104, new Account(104,"Suresh Verma",10000.0,new Transactions(1041,1,"Deposit",10000.0,"30/03/2019")));
	}
	
	public static Map<Long,Account> getAccountEntries(){
		return accountEntries;
	}
	
	public static Map<Long,Transactions> getTransactionEntries(){
		return transactionEntries;
	}
}
