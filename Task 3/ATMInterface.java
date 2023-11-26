import java.util.Scanner;

class BankAcc {
	public double balance;

	// Constructor for the BankAcc class 
	public BankAcc(double initialAmount) {
		this.balance = initialAmount;
	}

	// Methods to alter Back Balance based on the actions performed through ATM
	public void deposit(double amount) {
		if (amount > 0) {
			balance += amount;
			System.out.println("Deposited Successfully.");
			System.out.println("New Balance: " + balance);
		} else {
			System.out.println("Amount should be greater than Zero.");
		}
	}

	public void withdraw(double amount) {
		if (balance > 0 && amount > 0 && amount <= balance) {
			balance -= amount;
			System.out.println("Withdrawal Successful.");
			System.out.println("Balance :" + balance);
		} else {
			System.out.println("Insufficient Balance or Invalid amount for withdrawal");
		}
	}
	
	public double getBalance() {
		return balance;
	}
}

class ATM {
	public BankAcc account;
	public Scanner sc;

	// Constructor
	public ATM(BankAcc account) {
		this.account = account;
		this.sc = new Scanner(System.in);
	}

	// Method to Deposit through to ATM
	public void deposit() {
		System.out.println("Enter the amount to Deposit: ");
		double amount = sc.nextDouble();
		account.deposit(amount);
	}

	// Method to Withdraw through to ATM
	public void withdraw() {
		System.out.println("Enter the amount to Withdraw: ");
		double amount = sc.nextDouble();
		account.withdraw(amount);
	}

	// Method to Check Balance 
	public void checkbalance() {
		System.out.println("Current Balance: " + account.getBalance());
	}
	
	public void Menu() {
		System.out.println("1. Deposit");
		System.out.println("2. Withdraw");
		System.out.println("3. Check Balance");
		System.out.println("4. Exit");
	}

	public void start() {
		int choice;
		do {
			Menu();
			System.out.println("Enter your Choice");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				deposit();
				break;
			case 2:
				withdraw();
				break;
			case 3:
				checkbalance();
				break;
			case 4:
				System.out.println("Thank you... Visit Again!!!");
				break;
			default:
				System.out.println("Invalid Choice.");
				break;
			}
		} while (choice != 4);
	}
}

public class ATMInterface {
	public static void main(String[] args) {
		System.out.println("ATM");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your PIN: ");
		int pin = sc.nextInt();
		
		// Instantiating the BankAcc constructor and passing argument 
		BankAcc b = new BankAcc(20000.00);
		// Instantiating the ATM constructor and passing the instance of BankAcc Class as argument
		ATM atm = new ATM(b);
		// Calling Start method
		atm.start();
	}
}
