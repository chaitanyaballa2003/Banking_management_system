package banking.banking_management_system;

public class Customer {
	private int accountNumber;
	private String customerName;
	private String email;
	private String accountType;
	private Double balance;
	
	Customer(){
		
	}
	Customer(int accountNumber ,String customerName ,String email, String accountType, Double balance){
		this.accountNumber =accountNumber;
		this.customerName = customerName;
		this.email = email;
		this.accountType = accountType;
		this.balance = balance;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Customer [accountNumber=" + accountNumber + ", customerName=" + customerName + ", email=" + email
				+ ", accountType=" + accountType + ", balance=" + balance + "]";
	}
		
}
