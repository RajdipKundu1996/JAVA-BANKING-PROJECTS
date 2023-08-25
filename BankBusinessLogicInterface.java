package banking.tyss;

public interface BankBusinessLogicInterface {
	public void createAccount() throws Exception;
	public void deleteAccount() throws Exception;
	public void withdrawMoney() throws Exception;
	public void depositMoney() throws Exception;
	public void checkBalance() throws Exception;
	public void accountDetails() throws Exception;
	public void fileOperations() throws Exception;

}
