package banking.banking_management_system;
import java.sql.*;
import java.util.Scanner;

public class CustomerDAO {
	Scanner sc =new Scanner (System.in);
	void createAccount() throws Exception{
		Connection con = DBConnection.getConnection();
		PreparedStatement ps = con.prepareStatement("insert into customer(name,email , accountType,balance) values (?,?,?,?)");
		System.out.print(" Enter a CustomerName : ");
		ps.setString(1, sc.nextLine()); 
		System.out.print(" Enter a name of gmail : ");
		ps.setString(2, sc.next());
		System.out.print(" Enter a AccountType : ");
		ps.setString(3, sc.next());
		System.out.print(" Enter Balance : ");
		ps.setDouble(4, sc.nextDouble());	
		int result = ps.executeUpdate();
		String x = (result ==1 ) ? ("Insertion Completed"):("insertion Failed");
		System.out.println(x);
	}
	
	
	void search()  throws Exception{
		Connection con = DBConnection.getConnection();
		PreparedStatement ps = con.prepareStatement("SELECT * FROM CUSTOMER WHERE accountNumber = ? ");
		System.out.println("Enter Account number");
		ps.setInt(1, sc.nextInt());
		
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			Thread.sleep(50);
			System.out.println(rs.getInt(1) + "  "+rs.getString(2)+" "+rs.getString(3)+" "+ rs.getString(4)+" "+rs.getDouble(5) );
		}
		
	}
	
	void read()throws Exception{
		Connection con = DBConnection.getConnection();
		PreparedStatement ps = con.prepareStatement("SELECT * FROM CUSTOMER ");
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			Thread.sleep(50);
			System.out.println(rs.getInt(1) + "  "+rs.getString(2)+" "+rs.getString(3)+" "+ rs.getString(4)+" "+rs.getDouble(5) );
		}
		
	}
		
	
	void delete() throws Exception{
		Connection con = DBConnection.getConnection();
		con.setAutoCommit(false);
		PreparedStatement ps = con.prepareStatement("delete FROM CUSTOMER WHERE accountNumber = ? ");
		PreparedStatement ps1 = con.prepareStatement("delete FROM transactions WHERE accountNumber = ? ");
		
		System.out.println("Enter Account number to delete");
		int accountNumber =  sc.nextInt();
		ps.setInt(1, accountNumber);
		ps1.setInt(1, accountNumber);
		int result1 = ps1.executeUpdate();
		int result = ps.executeUpdate();
		if (result ==1 ) {
			con.commit();
			System.out.println("Data Deleted Succesfully......");
		}else { con.rollback();
		System.out.println("Failed deletion....");
		}
	}
	void update() throws Exception{
		Connection con = DBConnection.getConnection();
		PreparedStatement ps = con.prepareStatement("update customer set name = ?  where accountNumber = ?");
		System.out.print("Enter CustomerName to Update :  ");
		String b = sc.next();	
		ps.setString(1, b);
		System.out.println("AccountNumber to Update :");
		int a = sc.nextInt();
		ps.setInt(2,a);
		int result =ps.executeUpdate();
		String s = (result  == 1) ? "Data Updated Succesfully Completed........." : "Data was Not exist"; 
		System.out.println(s);
	
		
	}
	double getBalance(int accountNumber)throws Exception{
		Connection con = DBConnection.getConnection();
		PreparedStatement ps = con.prepareStatement
				("select balance from customer where accountNumber = ?");
		ps.setInt(1, accountNumber);
		ResultSet rs = ps.executeQuery();
		double balance = 0;
		if(rs.next()) {
		balance = rs.getDouble(1);
		return balance;
		}
		return balance;
	}
	   }

