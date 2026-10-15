package banking.banking_management_system;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import java.sql.Date;

public class TransactionDAO {
	Scanner sc = new Scanner (System.in);
	
	void insertTransaction() throws Exception{
		PreparedStatement ps = DBConnection.getConnection().prepareStatement
				("INSERT INTO transactions(accountNumber, transactionType, transactionDate) VALUES (?, ?, ?)");
		
		System.out.print("Enter Account Number :");
		ps.setInt(1, sc.nextInt());
		
		System.out.print("Enter Transacction Type : ");
		ps.setString(2 , sc.next());

		Date date = new Date(System.currentTimeMillis());
		ps.setDate(3, date);
		int result = ps.executeUpdate();
		
		String s= (result == 1)? "Transaction Updated....." : "transaction Declined........";
		System.out.println(s);
		
	}
	
	void readTransaction()throws Exception{
		PreparedStatement ps = DBConnection.getConnection().prepareStatement("select * from transactions");
		
	 ResultSet rs = ps.executeQuery();
	 
	 while (rs.next()) {
		 System.out.println(rs.getInt(1) +"  "+rs.getInt(2)+"  "+  rs.getString(3)+ "  "+ rs.getDate(4));
	 }
	 
	}
}

	