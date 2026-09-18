import java.util.Scanner;

// Bank Account class
class Account {

    private double balance;

    Account(double balance) {
        this.balance = balance;
    }

    // Withdraw money
    public boolean withdraw(double amount) {

        if (amount <= 0) {
            return false;
        }

        if (amount > balance) {
            return false;
        }

        balance = balance - amount;
        return true;
    }

    // Deposit money
    public boolean deposit(double amount) {

        if (amount <= 0) {
            return false;
        }

        balance = balance + amount;
        return true;
    }

    // Check balance
    public double getBalance() {
        return balance;
    }
}


// ATM Machine class
public class AtmMachine {

    private Account account;

    // Connect ATM with Account
    AtmMachine(Account account) {
        this.account = account;
    }

    // Withdraw method
    public void withdraw(double amount) {

        if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful!");
            System.out.println("Withdrawn Amount: ₹" + amount);
            System.out.println("Remaining Balance: ₹" + account.getBalance());
        } else {
            System.out.println("Withdrawal failed!");
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    // Deposit method
    public void deposit(double amount) {

        if (account.deposit(amount)) {
            System.out.println("Deposit successful!");
            System.out.println("Deposited Amount: ₹" + amount);
            System.out.println("New Balance: ₹" + account.getBalance());
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    // Check balance method
    public void checkBalance() {
        System.out.println("Current Balance: ₹" + account.getBalance());
    }


    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Create bank account with initial balance
        Account account = new Account(10000);

        // Connect ATM with account
        AtmMachine atm = new AtmMachine(account);

        int choice;

        do {

            System.out.println("\n===== ATM MACHINE =====");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter amount to withdraw: ₹");
                    double withdrawAmount = sc.nextDouble();

                    atm.withdraw(withdrawAmount);
                    break;

                case 2:
                    System.out.print("Enter amount to deposit: ₹");
                    double depositAmount = sc.nextDouble();

                    atm.deposit(depositAmount);
                    break;

                case 3:
                    atm.checkBalance();
                    break;

                case 4:
                    System.out.println("Thank you for using the ATM!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 4);

        sc.close();
    }
}