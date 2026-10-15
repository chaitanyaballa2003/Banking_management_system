package banking.banking_management_system;

import java.util.Scanner;

public class Menu {
	
	void mainMenu() throws Exception {
	CustomerDAO cd = new CustomerDAO();

	Deposit d = new Deposit();
	Scanner sc = new Scanner(System.in);
	
	boolean m =true;
	String a= "Exiting......";
	String b = "Invalid Input......";
	while (m) {
		System.out.println();
		System.out.println("------MENU-----");
		System.out.println(" 1 - Create Account.");
		System.out.println(" 2 - View Account. ");
		System.out.println(" 3 - Search Account. ");
		System.out.println(" 4 - Deposit.");
		System.out.println(" 5 - Withdraw.");
		System.out.println(" 6 - DeleteAccount.");
		System.out.println(" 7 - Exit.");
		System.out.println();
		
	System.out.print("Choose a Number :- ");
	int s = sc.nextInt();
	
	switch(s) {
	case 1 : cd.createAccount();
			break;
	case 2 : cd.read();
			break;
	case 3 : cd.search();
			break;
	case 4: try{d.deposit();}
				catch(InvalidAmountException e){
					System.out.println(e.getMessage());
				}
			break;
	case 5 : try{d.withdraw();}
			catch (InvalidAmountException | InsufficientFundsException e) {
				System.out.println(e.getMessage());
			}
			break;
	case 6 : cd.delete();
			break;
	case 7 : {
		for (int i =0;i<a.length();i++) {
			Thread.sleep(100);
			System.out.print(a.charAt(i));
			}
			m =false;
			}
			break;
	default : {
		for (int i =0;i<b.length();i++) {
			Thread.sleep(100);
			System.out.print(b.charAt(i));
				}
			}
		}	
	}
	sc.close();
	}
}