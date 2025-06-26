Bank Management System
Introduction
The Bank Management System is a console application developed in Java that enables users to manage their banking activities efficiently. It supports user authentication, account management, and various financial transactions, with data stored in a local text file named userdata.txt.

Key Features
User Authentication:

Log in using a username and password.
Create a new account if the login fails.
Account Management:

View current balance and fixed deposit balance.
Deposit funds into the account.
Withdraw funds from the account.
Transfer funds to a fixed deposit account.
Interest Calculation: Automatically applies a 5% interest to the current balance when viewed.

Technologies
Programming Language: Java
File Handling: Java I/O (java.io)
Data Storage: Plain text file (userdata.txt)
Utilities: Java Collections (ArrayList, Scanner)
Project Structure

Run
Copy code
├── BankManagementSystem.java    // Main application code
└── userdata.txt                 // User data storage in the format: username,password,currentBalance,fixedDeposit
Example of userdata.txt
Each line in the file represents a user in the following format:


Run
Copy code
username,password,currentBalance,fixedDepositBalance
Sample Entry:


Run
Copy code
nishant123,pass@123,5000.0,15000.0
Instructions to Run
Compile the Program:

bash

Run
Copy code
javac BankManagementSystem.java
Execute the Program:

bash

Run
Copy code
java BankManagementSystem
User Interaction:

Follow the prompts to log in or create a new account.
Perform banking operations as guided by the menu.
Important Considerations
The userdata.txt file must be in the same directory as the Java file.
This application is for educational purposes only; it does not encrypt user data and should not be used for real banking.
Hidden Feature: Enter 23220 in the menu to create a new account after logging in.

Future Enhancements
Add encryption for user credentials to improve security.
Develop a graphical user interface (GUI) using JavaFX or Swing.
Implement an admin login feature for account management.
Transition to a database system (e.g., MySQL) for data storage.
