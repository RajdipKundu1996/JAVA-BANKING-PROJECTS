package banking.tyss;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class BankBusinessLogicClass implements BankBusinessLogicInterface {
	
	Bank b;
	ArrayList<Bank>bank=new ArrayList();
	Scanner sc=new Scanner(System.in);
	private int otp;
	File f;
	
	// GETTER METHOD FOR OTP //
	public int getOTP()
	{
		return otp;
	}
	
	//SETTER METHOD FOR OTP //
	public void setOTP(int otp)
	{
		this.otp=otp;
	}
	
	public void generateOTP()
	{
		int max=10000;
		int min=1;
		int range=(max-min)+1;
		setOTP((int)(Math.random()*range)+max);
		System.out.println("OTP: "+getOTP());
	}
	
	@Override
	public void createAccount() throws Exception
	{
		Thread.sleep(1000);
		System.out.println(".......");
		Thread.sleep(1000);
		System.out.println(".......");
		Thread.sleep(1000);
		System.out.println("Enter Your Password: ");
		String inputPwd=sc.next();
		System.out.println("Enter Your Contact Number: ");
		long inputPhoneNo=sc.nextLong();
		System.out.println("Enter The Account Number: ");
		long inputAccountNo=sc.nextLong();
		System.out.println("Enter The IFSC: ");
		String inputIFSC=sc.next();
		System.out.println("Enter The Minimum Balance: ");
		double inputBalance=sc.nextDouble();
		System.out.println("Enter Your Name: ");
		String inputName=sc.nextLine();
		inputName=sc.nextLine();
		b=new Bank(inputName, inputPwd, inputPhoneNo, inputAccountNo, inputIFSC, inputBalance);
		bank.add(b);
		Thread.sleep(1000);
		System.out.println(".......");
		Thread.sleep(1000);
		System.out.println(".......");
		Thread.sleep(1000);
		System.out.println("Successfully Created Account "+b.userName);
		
	}
	
	@Override
	public void deleteAccount() throws Exception
	{
		Thread.sleep(1000);
		System.out.println("Wait For 3 Seconds");
		Thread.sleep(1000);
		System.out.println(".......");
		Thread.sleep(1000);
		System.out.println("Enter Account Number To Remove: ");
		long userInputtedAccountNo=sc.nextLong();
		for(Bank b:bank)
		{
			if(b.accNo==userInputtedAccountNo)
			{
				System.out.println("OTP Generating Please Wait...");
				Thread.sleep(1000);
				System.out.println("OTP Generating Please Wait...");
				Thread.sleep(1000);
				System.out.println("An OTP will Be Sent To The Regsitered Mobile Number: "+b.phoneNo);
				generateOTP();
				System.out.println("Enter The OTP You Recieved: ");
				int userInputOtp=sc.nextInt();
				if(userInputOtp==getOTP())
				{
					System.out.println("Removing Account From Datatbase Please Wait....");
					Thread.sleep(3000);
					bank.remove(b);
					System.out.println("Successfully Deactivated Account");
					return;
				}
				else
				{
					System.out.println("OTP Mismatch. Cannot Deactivate The Account");
					return;
				}
				
			}
		}
		Thread.sleep(2000);
		System.out.println("........");
		Thread.sleep(1000);
		System.out.println("No Such Account Found To Be Deleted: ");
	}
	
	@Override
	public void withdrawMoney() throws Exception
	{
		Thread.sleep(1000);
		System.out.println("Wait For 3 Seconds To Withdraw");
		Thread.sleep(1000);
		System.out.println(".......");
		Thread.sleep(1000);
		System.out.println("Enter Account Number To Withdraw: ");
		long userInputtedAccountNo=sc.nextLong();
		for(Bank b:bank)
		{
			if(b.accNo==userInputtedAccountNo)
			{
				Thread.sleep(1000);
				System.out.println("Getting Ready....");
				Thread.sleep(1000);
				System.out.println(".......");
				Thread.sleep(1000);
				System.out.println("Enter The Withdraw Amount: ");
				b.withdrawAmt=sc.nextDouble();
				if(b.withdrawAmt>b.balance)
				{
					Thread.sleep(2000);
					System.out.println(".......");
					Thread.sleep(1000);
					System.out.println("Insufficent Balance. Cannot Withdraw Money.");
					return;
				}
				else
				{
					Thread.sleep(2000);
					System.out.println("Withdrawing.......");
					Thread.sleep(1000);
					b.balance=b.balance-b.withdrawAmt;
					System.out.println("Successfully Withdrawn "+b.withdrawAmt+" Rupees ");
					return;
				}
				
			}
		}
		Thread.sleep(2000);
		System.out.println("........");
		Thread.sleep(1000);
		System.out.println("No Such Account Found To Withdraw Money: ");	
	}
	
	@Override
	public void depositMoney() throws Exception
	{
		Thread.sleep(1000);
		System.out.println("Wait For 3 Seconds To Deposit");
		Thread.sleep(1000);
		System.out.println(".......");
		Thread.sleep(1000);
		System.out.println("Enter Account Number To Deposit: ");
		long userInputtedAccountNo=sc.nextLong();
		for(Bank b:bank)
		{
			Thread.sleep(1000);
			System.out.println("Getting Ready....");
			Thread.sleep(1000);
			System.out.println(".......");
			Thread.sleep(1000);
			if(b.accNo==userInputtedAccountNo)
			{
				Thread.sleep(2000);
				System.out.println(".......");
				Thread.sleep(1000);
				System.out.println("Enter The Deposit Amount: ");
				b.depositAmt=sc.nextDouble();
				if(b.depositAmt>20000)
				{
					Thread.sleep(2000);
					System.out.println(".......");
					Thread.sleep(1000);
					System.out.println("Cannot Deposit Money Since Limit Exceeded (Limit Per Day:- 20000)");
					return;
				}
				else
				{
					Thread.sleep(2000);
					System.out.println("Depositing.......");
					Thread.sleep(1000);
					b.balance=b.balance+b.depositAmt;
					System.out.println("Successfully Deposited "+b.depositAmt+" Rupees ");
					return;
				}
				
			}
		}
		Thread.sleep(2000);
		System.out.println("........");
		Thread.sleep(1000);
		System.out.println("No Such Account Found To Deposit Money ");	
	}
	
	@Override
	public void checkBalance() throws Exception
	{
		Thread.sleep(1000);
		System.out.println("Wait For 3 Seconds To Fetch Balance");
		Thread.sleep(1000);
		System.out.println(".......");
		Thread.sleep(1000);
		System.out.println("Enter Account Number To Check Balance: ");
		long userInputtedAccountNo=sc.nextLong();
		for(Bank b:bank)
		{
			if(b.accNo==userInputtedAccountNo)
			{
				Thread.sleep(1000);
				System.out.println("Getting Ready....");
				Thread.sleep(1000);
				System.out.println(".......");
				Thread.sleep(1000);
				System.out.println("An OTP will Be Sent To The Regsitered Mobile Number: "+b.phoneNo);
				generateOTP();
				System.out.println("Enter The OTP You Recieved: ");
				int userInputOtp=sc.nextInt();
				if(userInputOtp==getOTP())
				{
					Thread.sleep(2000);
					System.out.println("Fetching Balance....");
					Thread.sleep(1000);
					System.out.println("Current Balance: "+b.balance);
					return;
				}
				else
				{
					Thread.sleep(2000);
					System.out.println(".........");
					System.out.println("OTP Mismatch. Cannot Check The Balance");
					return;
				}
				
			}
		}
		Thread.sleep(2000);
		System.out.println("........");
		Thread.sleep(1000);
		System.out.println("No Such Account Found To Check Balance :(");	
		
	}
	
	@Override
	public void accountDetails() throws Exception
	{
		Thread.sleep(1000);
		System.out.println("Wait For 3 Seconds To Fetch Account Details");
		Thread.sleep(1000);
		System.out.println(".......");
		Thread.sleep(1000);
		System.out.println("Enter Account Number To Fetch The Details: ");
		long userInputtedAccountNo=sc.nextLong();
		for(Bank b:bank)
		{
			if(b.accNo==userInputtedAccountNo)
			{
				Thread.sleep(1000);
				System.out.println("Getting Ready....");
				Thread.sleep(1000);
				System.out.println(".......");
				Thread.sleep(1000);
				System.out.println("An OTP will Be Sent To The Regsitered Mobile Number: "+b.phoneNo);
				generateOTP();
				System.out.println("Enter The OTP You Recieved: ");
				int userInputOtp=sc.nextInt();
				if(userInputOtp==getOTP())
				{
					Thread.sleep(2000);
					System.out.println("Fetching Account Details....");
					Thread.sleep(1000);
					System.out.println(b);
					return;
				}
				else
				{
					Thread.sleep(2000);
					System.out.println(".........");
					System.out.println("OTP Mismatch. Cannot Fetch The Account Details");
					return;
				}
				
			}
		}
		Thread.sleep(2000);
		System.out.println("........");
		Thread.sleep(1000);
		System.out.println("No Such Account Found To Fetch The Details :(");
	}
	
	@Override
	public void fileOperations() throws Exception
	{
		Thread.sleep(1000);
		System.out.println("Wait For 3 Seconds......");
		Thread.sleep(1000);
		System.out.println(".......");
		Thread.sleep(1000);
		System.out.println("Enter The Acccount Number To Peform File Operations: ");
		long userInputAccNo=sc.nextLong();
		for(Bank b:bank)
		{
			if(userInputAccNo==b.accNo)
			{
				Thread.sleep(1000);
				System.out.println("Getting Ready....");
				Thread.sleep(1000);
				System.out.println(".......");
				Thread.sleep(1000);
				System.out.println("Enter The Path To Save The File ( Give the File Name Also): ");
				String path=sc.next();
				f=new File(path);
				if(f.createNewFile())
				{
					Thread.sleep(2000);
					System.out.println("Creating File "+f.getName()+" "+b.userName);
					Thread.sleep(1000);
					System.out.println("Successfully Created "+f.getName());
				}
				
				boolean exit=true;
				while(exit)
				{
				System.out.println("Enter Your Options: ");
				System.out.println("A.) Flush Account Details");
				System.out.println("B.) Read Account Details");
				System.out.println("C.) Delete The Account File");
				System.out.println("D.) Exit");
				char options=sc.next().charAt(0);
				switch(options)
				{
					case 'A':
					{
						Thread.sleep(2000);
						System.out.println("Writing Contents Please Wait....");
						Thread.sleep(1000);
						FileWriter writer=new FileWriter(f.getAbsolutePath());
						writer.write("Name: "+b.userName+" Password: "+b.pwd+" Phone Number: "+b.phoneNo+" Account Number: "+b.accNo+" IFSC: "+b.ifsc+" Balance: "+b.balance);
						writer.close();
						System.out.println("Sucessfully Flushed Data Inside: "+f.getName());
					}
					break;
					
					case 'a':
					{
						Thread.sleep(2000);
						System.out.println("Writing Contents Please Wait....");
						Thread.sleep(1000);
						FileWriter writer=new FileWriter(f.getAbsolutePath());
						writer.write("Name: "+b.userName+" Password: "+b.pwd+" Phone Number: "+b.phoneNo+" Account Number: "+b.accNo+" IFSC: "+b.ifsc+" Balance: "+b.balance);
						writer.close();
						System.out.println("Sucessfully Flushed Data Inside: "+f.getName());
						
					}
					break;
					
					case 'B':
					{
						Thread.sleep(2000);
						System.out.println("Reading Contents Please Wait....");
						Thread.sleep(1000);
						Scanner reader=new Scanner(f);
						while(reader.hasNext())
						{
							String data=reader.nextLine();
							System.out.println(data);
						}
						
					}
					break;
					
					case 'b':
					{
						Thread.sleep(2000);
						System.out.println("Reading Contents Please Wait....");
						Thread.sleep(1000);
						Scanner reader=new Scanner(f);
						while(reader.hasNext())
						{
							String data=reader.nextLine();
							System.out.println(data);
						}
					
					}
					break;
					
					case 'C':
					{
						Thread.sleep(2000);
						System.out.println("Deleting File Please Wait....");
						Thread.sleep(1000);
						f.delete();
						System.out.println("Successfully Deleted The File");
						
					}
					break;
					
					case 'c':
					{
						Thread.sleep(2000);
						System.out.println("Deleting File Please Wait....");
						Thread.sleep(1000);
						f.delete();
						System.out.println("Successfully Deleted The File");
						
					}
					break;
					
					case 'D':
					{
						Thread.sleep(2000);
						System.out.println("Going Back To Main Menu....");
						Thread.sleep(1000);
						System.out.println("........");
						Thread.sleep(1000);
						exit=false;
					
					}
					break;
					
					case 'd':
					{
						Thread.sleep(2000);
						System.out.println("Going Back To Main Menu....");
						Thread.sleep(1000);
						System.out.println("........");
						Thread.sleep(1000);
						exit=false;
					
					}
					break;
				}
			}
		}
			else
			{
				Thread.sleep(2000);
				System.out.println("........");
				Thread.sleep(1000);
				System.out.println("No Such Account Found To Peform File Operations");
			}
		
	}
		

}
}
