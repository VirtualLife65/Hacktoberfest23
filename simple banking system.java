import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Account {
    private int accountNumber;
    private double balance;

    public Account(int accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds to withdraw " + amount);
        }
    }

    @Override
    public String toString() {
        return "Account Number: " + accountNumber + ", Balance: $" + balance;
    }
}

class Customer {
    private int customerID;
    private String name;
    private List<Account> accounts;

    public Customer(int customerID, String name) {
        this.customerID = customerID;
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public int getCustomerID() {
        return customerID;
    }

    public String getName() {
        return name;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    @Override
    public String toString() {
        return "Customer ID: " + customerID + ", Name: " + name;
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        Customer customer1 = new Customer(1, "Alice");
        Customer customer2 = new Customer(2, "Bob");

        Account account1 = new Account(101, 1000.0);
        Account account2 = new Account(102, 2000.0);
        Account account3 = new Account(103, 500.0);

        customer1.addAccount(account1);
        customer1.addAccount(account2);
        customer2.addAccount(account3);

        System.out.println("Welcome to the Banking System!");
        displayCustomerInfo(customer1);
        displayCustomerInfo(customer2);
    }

    public static void displayCustomerInfo(Customer customer) {
        System.out.println("\nCustomer Information:");
        System.out.println(customer);

        List<Account> accounts = customer.getAccounts();
        if (!accounts.isEmpty()) {
            System.out.println("Accounts:");
            for (Account account : accounts) {
                System.out.println(account);
            }
        } else {
            System.out.println("No accounts associated with this customer.");
        }

        // Simulate random transactions
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            int accountIndex = random.nextInt(accounts.size());
            Account selectedAccount = accounts.get(accountIndex);
            double transactionAmount = 100 + random.nextDouble() * 500;
            if (random.nextBoolean()) {
                selectedAccount.deposit(transactionAmount);
                System.out.println(customer.getName() + " deposited $" + transactionAmount + " into Account " + selectedAccount.getAccountNumber());
            } else {
                selectedAccount.withdraw(transactionAmount);
                System.out.println(customer.getName() + " withdrew $" + transactionAmount + " from Account " + selectedAccount.getAccountNumber());
            }
        }
    }
}
