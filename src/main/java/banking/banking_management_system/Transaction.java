package banking.banking_management_system;

public class Transaction {
	private int transactionID;
	private String transactionType;
	private int accountNumber;
	private String transactionDate;
	
	Transaction(){
		
	}
	Transaction(int transactionID,String transactionType, int accountNumber, String transactionDate ){
		this.transactionID = transactionID;
		this.transactionType =transactionType;
		this.accountNumber = accountNumber;
		this.transactionDate = transactionDate;
	}
	public int getTransactionID() {
		return transactionID;
	}
	public void setTransactionID(int transactionID) {
		this.transactionID =transactionID; 
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType =transactionType; 
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}
	
	@Override
	public String toString() {
		return "Transaction [transactionID=" + transactionID + ", transactionType=" + transactionType
				+ ", accountNumber=" + accountNumber + ", transactionDate=" + transactionDate + "]";
	
	}
}
