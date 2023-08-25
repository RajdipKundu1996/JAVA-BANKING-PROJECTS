package banking.tyss;

import java.util.Objects;

public class User {
	String userName;
	String pwd;
	long phoneNo;
	
	User(String userName, String pwd, long phoneNo) {
		
		this.userName = userName;
		this.pwd = pwd;
		this.phoneNo = phoneNo;
	}
	
	@Override
	public int hashCode()
	{
		return Objects.hash(userName,pwd,phoneNo);
	}

}
