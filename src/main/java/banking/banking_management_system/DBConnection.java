package banking.banking_management_system;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;

public class DBConnection {
		public static Connection getConnection()  throws SQLException{
			String Url ="jdbc:mysql://localhost:3306/bankservice";
			String UserName = "YOUR USERNAME HERE";
			String Password = "YOUR PASSWORD HERE";
			
			Connection con = DriverManager.getConnection(Url,UserName,Password);
			
			return con;
		}
}
