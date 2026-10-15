package banking.banking_management_system;

class InvalidAmountException extends Exception {
    public InvalidAmountException(String message) {
        super(message);
    }
}
 
class InsufficientFundsException extends Exception{
	public InsufficientFundsException(String message) {
		super (message);
	}
}
