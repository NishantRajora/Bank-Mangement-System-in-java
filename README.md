# Bank Management System (Console-based Java Project)

## Overview

This is a simple console-based Bank Management System built using Java. The system provides basic banking operations such as user authentication, balance inquiry, withdrawal, deposit, and transferring money to a fixed deposit. User data is stored in a local text file (`userdata.txt`).

## Features

* User Authentication

  * Login with username & password
  * Create a new account if credentials are invalid
* Account Management

  * View account info (balance + fixed deposit)
  * Deposit money
  * Withdraw money
  * Transfer money to fixed deposit
* Interest Calculation

  * Automatically adds 5% interest on balance when viewing

## Technologies Used

* Language: Java
* File Handling: Java I/O (`java.io`)
* Data Storage: Plain text file (`userdata.txt`)
* Utilities: Java Collections (`ArrayList`, `Scanner`)

## File Structure

```
├── BankManagementSystem.java    // Main Java program
└── userdata.txt                 // Stores user info in format: username,password,currentBalance,fixedDeposit
```

## Format of `userdata.txt`

Each line represents one user:

```
username,password,currentBalance,fixedDepositBalance
```

Example:

```
john123,pass@123,5000.0,15000.0
```

## How to Run

1. Compile the program:

   ```
   javac BankManagementSystem.java
   ```

2. Run the program:

   ```
   java BankManagementSystem
   ```

3. Follow the prompts on the terminal to:

   * Login or create a new account
   * Perform banking operations

## Notes

* The `userdata.txt` file must be in the same directory as the `.java` file.
* Data is not encrypted, and this program is for educational/demo purposes only, not for real-world banking use.
* Hidden feature: Input `23220` as an option in the menu to create a new account after login.

## Possible Enhancements

* Add encryption for user credentials
* GUI integration with JavaFX or Swing
* Admin login to manage accounts
* Store data using databases (like MySQL)

## Author

**Monika Nahadiya**
B.Tech in Data Science\\
