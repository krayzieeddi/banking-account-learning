import java.util.Scanner;

public class Main {

	public static void main(String[] args) { // start of main method -----------------------------------------------
		
		BankAccount test = new BankAccount("bob", "1234");
		test.showMenu();
		
		
	} // main end

} // class main end

class BankAccount { // start of Bank Account class -----------------------------------------
		
	int balance;
	int prevTransaction;
	String custName;
	String custID;
	
	BankAccount( String custName, String custID) {
		
		this.custName = custName;
		this.custID = custID;
	}
	
	void deposit(int amount) { // start of deposit method -----------------------------------------
		
		if (amount > 0) {
			balance = balance + amount;
			prevTransaction = amount;
		} 
	} //  end of void deposit 
	
	void withdraw(int amount) { // start of withdraw method -----------------------------------------
		
		if (amount > 0) {
			balance = balance - amount;
			prevTransaction = -amount;
		}
	} // end of withdraw method 
	
	void getPrevTransaction() { // start of get previous transaction method ---------------------------
		
		if (prevTransaction > 0) {
			System.out.println("Previous Transaction");
			System.out.println("Deposited:" + prevTransaction);
		}
		else if (prevTransaction < 0) {
			System.out.println("Previous Transaction");
			System.out.println("Withdrawn" + Math.abs(prevTransaction));
		}
		else {
			System.out.println("No transaction occured");
		}
	} // end of get previous transaction method
	
	void showMenu() { // start of show menu method --------------------------------------------------------
		
		char option = '\0';
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Welcome " + custName);
		System.out.println("Your ID is " + custID);
		System.out.println("\n");
		System.out.println("a. Check Balance");
		System.out.println("b. Deposit");
		System.out.println("c. Withdraw");
		System.out.println("d. Previous Transaction");
		System.out.println("e. Exit");
		
		do {
			System.out.println("======================================================================================");
			System.out.println("Enter an option");
			System.out.println("======================================================================================");
			option = scan.next().charAt(0);
			System.out.println("\n");
			
			switch(option) { // start of the options execution -----------------------------------------------------------------
				case 'a':
					System.out.println("------------------------------------------");
					System.out.println("Balance = " + balance);
					System.out.println("-------------------------------------------");
					System.out.println("\n");
					break;
					
				case 'b':
					System.out.println("-----------------------------------------");
					System.out.println("Enter a amount to deposit: ");
					System.out.println("-----------------------------------------");
					int amount = scan.nextInt();
					deposit(amount);
					System.out.println("\n");
					break;
				
				case 'c':
					System.out.println("----------------------------------------");
					System.out.println("Enter an amount to withdraw: ");
					System.out.println("----------------------------------------");
					int amount2 = scan.nextInt();
					withdraw(amount2);
					System.out.println("\n");
					break;
					
				case 'd':
					System.out.println("----------------------------------------");
					getPrevTransaction();
					System.out.println("-----------------------------------------");
					System.out.println("\n");
					break;
					
				case 'e':
					System.out.println("*******************************************");
					break;
					
				default:
					System.out.println("Invalid option --- pleade enter again");
					break;
			} // end of switch case
		}
		while (option != 'e');
		
		System.out.println("Thank you for your services");
		
		scan.close();
		
	} // end of show menu method 
	
} // end of back Bank Account class