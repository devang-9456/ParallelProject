package com.cg.wallet.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import com.cg.wallet.dto.Account;
import com.cg.wallet.dto.Transactions;

public class StaticDB {
	
	private static Map<Long,Account> accountEntries=new HashMap<Long,Account>();
	private static Map<Integer,Transactions> transactionEntries=new HashMap<Integer,Transactions>();
	public static Integer tSeq=4;
	public static long accId=104;
	public static DateTimeFormatter datef = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	public static LocalDateTime now = LocalDateTime.now();

	static{
		transactionEntries.put((Integer) 1, new Transactions(1,(long) 1011,"Deposit",12000.0,12000.0,datef.format(now)));
		transactionEntries.put((Integer) 2, new Transactions(2,(long) 1021,"Deposit",10000.0,10000.0,datef.format(now)));
		transactionEntries.put((Integer) 3, new Transactions(3,(long) 1031,"Deposit",23000.0,23000.0,datef.format(now)));
		transactionEntries.put((Integer) 4, new Transactions(4,(long) 1041,"Deposit",10000.0,10000.0,datef.format(now)));
		accountEntries.put((long) 101, new Account((long) 101,"Devang Sinha",12000.0));
		accountEntries.put((long) 102, new Account((long) 102,"Aniket Pal",10000.0));
		accountEntries.put((long) 103, new Account((long) 103,"Umang Gupta",23000.0));
		accountEntries.put((long) 104, new Account((long) 104,"Suresh Verma",10000.0));
	}
	
	public static Map<Long,Account> getAccountEntries(){
		return accountEntries;
	}
	
	public static Map<Integer,Transactions> getTransactionEntries(){
		return transactionEntries;
	}
}
