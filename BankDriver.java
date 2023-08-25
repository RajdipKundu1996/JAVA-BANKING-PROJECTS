package banking.tyss;

import java.util.Scanner;

public class BankDriver {
	public static void main(String[] args) throws Exception {
		Scanner sc=new Scanner(System.in);
		BankBusinessLogicClass b=new BankBusinessLogicClass();
		boolean logout=true;
		while(logout)
		{
			Thread.sleep(1000);
			System.out.println("3");
			Thread.sleep(1000);
			System.out.println("2");
			Thread.sleep(1000);
			System.out.println("1");
			
		System.out.println("*****WELCOME TO BANKING APPLICATION****");
		
		Thread.sleep(1000);
		System.out.println("Displaying Options. Please Wait....");
		Thread.sleep(1000);
		System.out.println("......");
		Thread.sleep(1000);
		System.out.println("Enter Your Choice: ");
		Thread.sleep(1000);
		System.out.println("1.Create Account");
		Thread.sleep(1000);
		System.out.println("2.Delete Account");
		Thread.sleep(1000);
		System.out.println("3.Withdraw Money");
		Thread.sleep(1000);
		System.out.println("4.Deposit Money");
		Thread.sleep(1000);
		System.out.println("5.Check Balance");
		Thread.sleep(1000);
		System.out.println("6.Account Details");
		Thread.sleep(1000);
		System.out.println("7.Logout");
		Thread.sleep(1000);
		System.out.println("8.File Operations");
		Thread.sleep(1000);
		int options=sc.nextInt();
		switch(options)
		{
			case 1:
			{
				try {
					b.createAccount();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			break;
			
			case 2:
			{
				try {
					b.deleteAccount();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			break;
			
			case 3:
			{
				try {
					b.withdrawMoney();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			break;
			
			case 4:
			{
				try {
					b.depositMoney();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			break;
			
			case 5:
			{
				try {
					b.checkBalance();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			break;
			
			case 6:
			{
				try {
					b.accountDetails();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			break;
			
			case 7:
			{
				Thread.sleep(1000);
				System.out.println("Exiting.......");
				Thread.sleep(1000);
				System.out.println(".......");
				Thread.sleep(1000);
				logout=false;
				System.out.println("Thank You For Using This Application ");
			}
			break;
			
			case 8:
			{
				try {
					b.fileOperations();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			break;
			
			default:
			{
				Thread.sleep(1000);
				System.out.println("........");
				Thread.sleep(1000);
				System.out.println("Invalid Options. Please Try Again Later");
			}
			break;
		}
	}
}
}
