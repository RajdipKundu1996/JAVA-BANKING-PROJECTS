package banking.tyss;

import java.util.Objects;

public class Bank extends User {
	long accNo;
	String ifsc;
	double balance;
	double withdrawAmt;
	double depositAmt;
	
	Bank(String userName,String pwd,long phoneNo,long accNo,String ifsc,double balance)
	{
		super(userName,pwd,phoneNo);
		this.accNo=accNo;
		this.ifsc=ifsc;
		this.balance=balance;
		
	}

	
	@Override
	public String toString() {
		return "Bank [accNo=" + accNo + ", ifsc=" + ifsc + ", balance=" + balance + ", withdrawAmt=" + withdrawAmt
				+ ", depositAmt=" + depositAmt + ", userName=" + userName + ", pwd=" + pwd + ", phoneNo=" + phoneNo
				+ "]";
	}


	@Override
	public int hashCode()
	{
		return Objects.hash(userName,pwd,phoneNo,accNo,ifsc,balance,withdrawAmt,depositAmt);
	}
	
	
	
	
}
