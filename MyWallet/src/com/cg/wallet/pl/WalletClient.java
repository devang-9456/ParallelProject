package com.cg.wallet.pl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.cg.wallet.dto.Account;
import com.cg.wallet.dto.Transactions;
import com.cg.wallet.service.AccountService;
import com.cg.wallet.service.AccountServiceImpl;

public class WalletClient {

	public static void main(String[] args) {
		AccountService service = new AccountServiceImpl();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		int choice = 0;
		try(Scanner sc=new Scanner(System.in)){
			do{
				System.out.println("Welcome to Wallet Application!");
				System.out.println("Please choose a Transaction: ");
				System.out.println("1. Create Account.\n2. Display All Accounts.\n3. Check Balance\n4. Deposit\n5. Withdraw\n6. Fund Transfer\n"
						+ "7. Transactions In Account.\n8. Account Info.\n9. Exit.");
				choice=sc.nextInt();
				switch(choice){
				case 1: System.out.println("Please enter the following details to create an Account in our wallet: ");
						long accId=service.getAccId();
						System.out.println("Enter your name.");
						System.out.println("First name: ");
						String fName=sc.next();
						System.out.println("Last Name: ");
						String lName=sc.next();
						String name=fName+" "+lName;
						System.out.println("Enter starting balance: ");
						double bal=sc.nextDouble();
						int tranSeq1=service.getTranSeq();
						long tranId=accId*10+1;
						LocalDateTime now = LocalDateTime.now();
						Account acc1=new Account(accId, name, bal);
						Transactions ts1=new Transactions(tranSeq1, tranId, "Deposit", bal, bal, dtf.format(now));
						service.createAccount(acc1);
						service.createTransaction(ts1);
						break;
						
				case 2: System.out.println("Account List:\n");
						List<Account> accList=service.showAllAccounts();
						for(Account ac:accList){
							System.out.println(ac);
						}
						break;
						
				case 3: System.out.println("Please enter your account number to check balance:");
						long acc2=sc.nextLong();
						System.out.println("Your current balance is: " + service.showBalance(acc2));
						break;
						
				case 4: System.out.println("Please enter the account number to which amount is to be deposited: ");
						long accD=sc.nextLong();
						System.out.println("Please enter the amount to be deposited: ");
						double deposit=sc.nextDouble();
						System.out.println("New Balance after deposit is : " + service.deposit(accD, deposit));
						break;
						
				case 5: System.out.println("Please enter the account number from which amount is to be withdrawn: ");
						long accW=sc.nextLong();
						System.out.println("Please enter the amount to be withdrawn: ");
						double withD=sc.nextDouble();
						System.out.println("New Balance after withdrawal is : " + service.withdraw(accW, withD));
						break;
						
				case 6: System.out.println("Please enter the account from which funds needs to be transfered: ");
						long acc3=sc.nextLong();
						System.out.println("Please enter the amount to be transfered: ");
						double fAmount=sc.nextDouble();
						System.out.println("Please enter the account in which funds needs to be transfered");
						long acc4=sc.nextLong();
						System.out.println("Funds Transfer successfull? " + service.fundTransfer(acc3, fAmount, acc4));
						break;
						
				case 7: System.out.println("Enter the account number whose transactions you want displayed: ");
						long accTran=sc.nextLong();
						List<Transactions> tranList=null;
						tranList = service.showTransactionByAccountId(accTran);
						System.out.println("Following are the transactions for "+accTran+" account: ");
						for(Transactions tc:tranList){
							System.out.println(tc);
						}
						break;
						
				case 8: System.out.println("Enter your account number: ");
						long accID=sc.nextLong();
						System.out.println(service.showMyAccountInfo(accID));
						break;
						
				case 9: System.exit(0);
				
				default: System.out.println("INVALID CHOICE!!!");
				}
			}while(choice!=0);
		}

	}

}
