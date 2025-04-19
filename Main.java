import java.util.Scanner;
import java.util.Random;

 class BankAccount {
    private String nameholder;
    private String acc_Number;
    private double balance;

    public BankAccount(String nameholder, String acc_Number) {
        this.nameholder = nameholder;
        this.acc_Number = acc_Number;
        this.balance = 0.0;
    }

    public String getnameHolder() {
        return nameholder;
    }

    public String getAcc_Number() {
        return acc_Number;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    public void displayAccountDetails() {
        System.out.println("----------ACCOUNT DETAIL----------");
        System.out.println("Account Holder: " + nameholder);
        System.out.println("Account Number: " + acc_Number);
        System.out.println("Available balance: LE. " + balance);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        System.out.println("*******WELCOME TO BANK OF HSBC*******");
        System.out.println("----------ACCOUNT CREATION----------");
        System.out.print("Enter your name: ");
        String name = input.nextLine();
        System.out.print("Enter your account number: ");
        String accNum = input.nextLine();

        BankAccount account = new BankAccount(name, accNum);
        System.out.println("Congratulations! Account created successfully......");

        System.out.print("Do you want to do any transactions?(y/n): ");
        char Transaction = input.next().charAt(0);

        while (Transaction == 'y'||Transaction=='Y') {
            System.out.println("Menu:");
            System.out.println("1. Account Detail");
            System.out.println("2. Check Balance");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Exit");
            System.out.println("*********************");
            System.out.print("Enter from 1 to 5: ");
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    account.displayAccountDetails();
                    break;
                case 2:
                    System.out.println("Available balance: LE. " + account.getBalance());
                    break;
                case 3:
                    System.out.print("How much you want to deposit(LE.): ");
                    double depositAmount = input.nextDouble();
                    account.deposit(depositAmount);
                    System.out.println("Current account balance: LE. " + account.getBalance());
                    break;
                case 4:
                    System.out.print("How much you want to withdraw(LE.): ");
                    double withdrawAmount = input.nextDouble();
                    if (account.withdraw(withdrawAmount)) {
                        System.out.println("LE. " + withdrawAmount + " withdrawal successful!");
                        System.out.println("Current account balance: LE. " + account.getBalance());
                    } else {
                        System.out.println("Insufficient fund!");
                        System.out.println("Your balance is LE. " + account.getBalance() + " only.");
                        System.out.println("Try with lesser amount than balance.");
                    }
                    break;
                case 5:
                int transactionNumber = 100000 + random.nextInt(900000);
                    System.out.println("printing receipt..............");
                    System.out.println("******************************************");
                    System.out.println("Transaction is now complete.");
                    System.out.println("Transaction number: " + transactionNumber);
                    System.out.println("Account holder: " + account.getnameHolder());
                    System.out.println("Account number: " + account.getAcc_Number());
                    System.out.println("Available balance: LE. " + account.getBalance());
                    System.out.println("Thanks for choosing us as your bank");
                    System.out.println("******************************************");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice! Please select between 1-5.");
            }

            System.out.print("\nDo you want to do another transaction?(y/n): ");
            Transaction = input.next().charAt(0);
        }

        System.out.println("Thanks for using HSBC. Goodbye!");
    }
}
