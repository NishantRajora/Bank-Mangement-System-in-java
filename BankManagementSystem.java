import java.io.*;
import java.util.*;

class BankManagementSystem {
    private static final String USER_DATA_FILE = "userdata.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean loggedIn = false;
        String username, password;

        // Authentication
        do {
            System.out.print("Enter username - ");
            username = scanner.nextLine();
            System.out.print("Enter password - ");
            password = scanner.nextLine();
            loggedIn = authenticateUser(username, password);
            if (!loggedIn) {
                System.out.println("Invalid username or password.");
                System.out.println("Do you want to create a new account? (yes/no)");
                String choice = scanner.nextLine();
                if (choice.equalsIgnoreCase("yes")) {
                    addAccount(scanner);
                }
            }
        } while (!loggedIn);

        displayAccountInfo(username);

        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("+----------------------------------+");
            System.out.println("| Option |          Description     |");
            System.out.println("+----------------------------------+");
            System.out.println("|   1    |       View Balance       |");
            System.out.println("|   2    |      Withdraw Money      |");
            System.out.println("|   3    |       Deposit Money      |");
            System.out.println("|   4    | Transfer Money to FD     |");
            System.out.println("|   5    |           Exit           |");
            System.out.println("+----------------------------------+");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    viewBalance(username);
                    break;
                case 2:
                    withdrawMoney(username, scanner);
                    break;
                case 3:
                    depositMoney(username, scanner);
                    break;
                case 4:
                    transferToFixedDeposit(username, scanner);
                    break;
                case 5:
                    System.exit(0);
                    break;
                case 23220:
                    addAccount(scanner);
                    break;
                default:
                    System.out.println("Invalid choice. Please select again.");
                    
            }
        }
    }

    // Authentication
    private static boolean authenticateUser(String username, String password) {
        try (Scanner fileScanner = new Scanner(new File(USER_DATA_FILE))) {
            while (fileScanner.hasNextLine()) {
                String[] userData = fileScanner.nextLine().split(",");
                if (userData[0].equals(username) && userData[1].equals(password))
                    return true;
            }
        } catch (FileNotFoundException e) {
            System.out.println("User data file not found.");
        }
        return false;
    }

    // Acc Information
    private static void displayAccountInfo(String username) {
        try (Scanner fileScanner = new Scanner(new File(USER_DATA_FILE))) {
            while (fileScanner.hasNextLine()) {
                String[] userData = fileScanner.nextLine().split(",");
                if (userData[0].equals(username)) {
                    double currentBalance = Double.parseDouble(userData[2]);
                    double fixedDepositBalance = Double.parseDouble(userData[3]);
                    System.out.println("Current Balance:  " + currentBalance);
                    System.out.println("Fixed Deposit Balance:  " + fixedDepositBalance);
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("User data file not found.");
        }
    }

    // Balance
    private static void viewBalance(String username) {
        try (Scanner fileScanner = new Scanner(new File(USER_DATA_FILE))) {
            while (fileScanner.hasNextLine()) {
                String[] userData = fileScanner.nextLine().split(",");
                if (userData[0].equals(username)) {
                    double currentBalance = Double.parseDouble(userData[2]);
                    double fixedDepositBalance = Double.parseDouble(userData[3]);
                    
                    // Compute interest on current balance
                    double interestRate = 0.05; //interest rate5%
                    double interest = currentBalance * interestRate;
                    currentBalance += interest;
                    
                    System.out.println("Current Balance:  " + currentBalance);
                    System.out.println("Fixed Deposit Balance:  " + fixedDepositBalance);
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("User data file not found.");
        }
    }

    // Withdraw
    private static void withdrawMoney(String username, Scanner scanner) {

        try {
            System.out.print("Enter the amount to withdraw: ");
            double amount = scanner.nextDouble();
            

            if (amount < 0) {
                System.out.println("Invalid amount. Please enter a non-negative value.");
                return;
            }
    
            List<String> lines = new ArrayList<>();
            try (Scanner fileScanner = new Scanner(new File(USER_DATA_FILE))) {
                while (fileScanner.hasNextLine()) {
                    String[] userData = fileScanner.nextLine().split(",");
                    if (userData[0].equals(username)) {
                        double currentBalance = Double.parseDouble(userData[2]);
                        if (currentBalance >= amount) {
                            currentBalance -= amount;
                            userData[2] = String.valueOf(currentBalance);
                            System.out.println("Withdrawal successful. Updated balance:  " + currentBalance);
                        } else {
                            System.out.println("Insufficient funds.");
                            return;
                        }
                    }
                    lines.add(String.join(",", userData));
                }
            }
    
            try (PrintWriter writer = new PrintWriter(new FileWriter(USER_DATA_FILE))) {
                for (String line : lines) {
                    writer.println(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error processing withdrawal.");
        }
    }

    // Deposit Money
    private static void depositMoney(String username, Scanner scanner) {

        try {
            System.out.print("Enter the amount to deposit: ");
            double amount = scanner.nextDouble();
            
            if (amount < 0) {
                System.out.println("Invalid amount. Please enter a non-negative value.");
                return;
            }
    
            List<String> lines = new ArrayList<>();
            try (Scanner fileScanner = new Scanner(new File(USER_DATA_FILE))) {
                while (fileScanner.hasNextLine()) {
                    String[] userData = fileScanner.nextLine().split(",");
                    if (userData[0].equals(username)) {
                        double currentBalance = Double.parseDouble(userData[2]);
                        currentBalance += amount;
                        userData[2] = String.valueOf(currentBalance);
                        System.out.println("Deposit successful. Updated balance:  " + currentBalance);
                    }
                    lines.add(String.join(",", userData));
                }
            }
    
            try (PrintWriter writer = new PrintWriter(new FileWriter(USER_DATA_FILE))) {
                for (String line : lines) {
                    writer.println(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error processing deposit.");
        }
    }

    // Transfer Money to Fixed Deposit
    private static void transferToFixedDeposit(String username, Scanner scanner) {
        try {
            System.out.print("Enter the amount to transfer to Fixed Deposit: ");
            double amount = scanner.nextDouble();
            
            if (amount < 0) {
                System.out.println("Invalid amount. Please enter a non-negative value.");
                return;
            }
    
            List<String> lines = new ArrayList<>();
            try (Scanner fileScanner = new Scanner(new File(USER_DATA_FILE))) {
                while (fileScanner.hasNextLine()) {
                    String[] userData = fileScanner.nextLine().split(",");
                    if (userData[0].equals(username)) {
                        double currentBalance = Double.parseDouble(userData[2]);
                        double fixedDepositBalance = Double.parseDouble(userData[3]);
                        if (currentBalance >= amount) {
                            currentBalance -= amount;
                            fixedDepositBalance += amount;
                            userData[2] = String.valueOf(currentBalance);
                            userData[3] = String.valueOf(fixedDepositBalance);
                            System.out.println("Transfer to Fixed Deposit successful.");
                            System.out.println("Updated Current Balance:  " + currentBalance);
                            System.out.println("Updated Fixed Deposit Balance:  " + fixedDepositBalance);
                        } else {
                            System.out.println("Insufficient funds.");
                            return;
                        }
                    }
                    lines.add(String.join(",", userData));
                }
            }
    
            try (PrintWriter writer = new PrintWriter(new FileWriter(USER_DATA_FILE))) {
                for (String line : lines) {
                    writer.println(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error processing transfer to Fixed Deposit.");
        }
    }

    // Add Account
    private static void addAccount(Scanner scanner) {
        try {
            System.out.print("Enter new username: ");
            String newUsername = scanner.nextLine();

            // if username already exists
            try (Scanner fileScanner = new Scanner(new File(USER_DATA_FILE))) {
                while (fileScanner.hasNextLine()) {
                    String[] userData = fileScanner.nextLine().split(",");
                    if (userData[0].equals(newUsername)) {
                        System.out.println("Username already exists. Please choose a different username.");
                        return;
                    }
                }
            }

            System.out.print("Enter new password: ");
            String newPassword = scanner.nextLine();
            System.out.print("Enter initial balance: ");
            double initialBalance = scanner.nextDouble();
            System.out.print("Enter initial fixed deposit balance: ");
            double initialFixedDepositBalance = scanner.nextDouble();

            // Append new account information to user data file
            try (PrintWriter writer = new PrintWriter(new FileWriter(USER_DATA_FILE, true))) {
                writer.println(newUsername + "," + newPassword + "," + initialBalance + "," + initialFixedDepositBalance);
                System.out.println("Account created successfully.");
            }
        } catch (IOException e) {
            System.out.println("Error adding account.");
        }
    }
}
