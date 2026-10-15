package banking.banking_management_system;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.Date;
import java.util.Scanner;

public class Deposit {
	Scanner sc = new Scanner(System.in);
	void deposit() throws Exception {
	System.out.print("Enter Account Number  : ");
	int accountNumber =sc.nextInt();
		
	System.out.print("Enter Amount to Deposit  : ");
	double depositAmount = sc.nextDouble();
	if (depositAmount <= 0) {
	    throw new InvalidAmountException(
	        "Deposit amount must be greater than zero"
	    );
	}
	
	
	CustomerDAO cd = new CustomerDAO();
	double currentBalance = cd.getBalance(accountNumber);

	Double updatedBalance = currentBalance + depositAmount; 
	
	Connection con = DBConnection.getConnection();
	PreparedStatement  ps = con.prepareStatement
			("update customer set balance = ? where accountNumber = ?");	
	con.setAutoCommit(false);
	ps.setInt(2, accountNumber);
	ps.setDouble(1, updatedBalance);
	
	
	PreparedStatement  ps1 = con.prepareStatement
			("insert into transactions(accountNumber,transactionType,transactionDate) values (?,?,?)");	
	ps1.setInt(1 , accountNumber);
	
	ps1.setString(2, "Deposit");
	
	Date date = new Date(System.currentTimeMillis());
	ps1.setDate(3, date);
	int result=0,result1 = 0;
	
	try {
	result =ps.executeUpdate();
	result1 =ps1.executeUpdate();
		if (result  == 1  && result1 == 1) {
		con.commit();
		}
		else {
			con.rollback();
		}
		}
		catch(Exception e) {
			e.printStackTrace();
			con.rollback();
		}
	String s = (result  == 1  && result1 == 1) ? "Amount deposited Succesfully Completed........." : "Amount deposit failed.........."; 
	System.out.println(s);
	
	}
	
	void withdraw() throws Exception {
		System.out.print("Enter Account Number  : ");
		int accountNumber = sc.nextInt();
		
		System.out.print("Enter Withdrawal Amount  : ");
		double withdrawalAmount = sc.nextDouble();
		
		
		CustomerDAO cd = new CustomerDAO();
		
		double accountBalance = cd.getBalance(accountNumber);
		
		
		if (withdrawalAmount <= 0) {
			throw new InvalidAmountException(
					"Withdrawal amount must be greater than zero"
					);
		}
		
	
		if (withdrawalAmount > accountBalance) {
			throw new InsufficientFundsException(
					"Insufficient balance"
					);
		}
		
		Connection con  = DBConnection.getConnection();
		con.setAutoCommit(false);
		 
			try {
				
			
			PreparedStatement ps = con.prepareStatement
					("update customer set balance = ? where accountNumber = ?");
			double  updatedAccountBalance = accountBalance - withdrawalAmount;
			ps.setDouble(1, updatedAccountBalance);
			ps.setInt(2, accountNumber);
			
			
			PreparedStatement ps1 = con.prepareStatement
					("Insert into transactions(accountNumber,transactionType,transactionDate) values (? , ? , ?)"); 
			ps1.setInt(1, accountNumber);
			ps1.setString(2, "withdraw");
			Date date = new Date(System.currentTimeMillis());
			ps1.setDate(3, date);
			int result=0,result1 = 0;
			
			
			
			result =ps.executeUpdate();
			result1 =ps1.executeUpdate();
				if (result  == 1  && result1 == 1) {
				con.commit();
				System.out.println("Amount Withdrawl Succesfully....");
				}
				else {
					System.out.println("Amount Withdrawl Failed....");
					con.rollback();
				}
			}
			catch(Exception e) {
				e.printStackTrace();
				con.rollback();
		}	
	}
	
}
