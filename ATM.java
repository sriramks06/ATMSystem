import java.util.Scanner;

public class ATM {
    private BankAccount account;
    private int pin = 1234;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void start() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter PIN: ");
        int enteredPin = sc.nextInt();
        if (enteredPin != pin) {
            System.out.println("Invalid PIN! Access denied.");
            return;
        }

        while (true) {
            System.out.println("\n1. Check Balance\n2. Deposit\n3. Withdraw\n4. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> System.out.println("Balance: ₹" + account.getBalance());
                case 2 -> {
                    System.out.print("Enter amount to deposit: ");
                    double amount = sc.nextDouble();
                    account.deposit(amount);
                    System.out.println("Deposited ₹" + amount);
                }
                case 3 -> {
                    System.out.print("Enter amount to withdraw: ");
                    double amount = sc.nextDouble();
                    if (account.withdraw(amount))
                        System.out.println("Withdrawn ₹" + amount);
                    else
                        System.out.println("Insufficient balance!");
                }
                case 4 -> {
                    System.out.println("Thank you! Visit again.");
                    return;
                }
                default -> System.out.println("Invalid option!");
            }
        }
    }
}
