package banking.banking_management_system;
import java.util.Scanner;

public class Login_page {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		// TODO Auto-generated method stub
		System.out.println("-----LOGIN PAGE-----");
		System.out.println();
		System.out.println("use username:- user");
		System.out.print("ENTER USER NAME : ");
		String userName = sc.next();
		System.out.println();
		System.out.println("use password:- admin");
		System.out.print("ENTER PASSWORD : ");
		String password = sc.next();
		
		if (userName.equals("user") && password.equals("admin")) {
		    Menu m = new Menu();
		    m.mainMenu();
		} else {
		    System.out.println("Invalid username or password");
		}
		
		System.out.println();
		
		sc.close();
		
	}

}
