💳 Bank Management System (Java Console Application)
A console-based banking system written in Java that allows users to securely log in, manage their accounts, perform transactions, and track their fixed deposits. This project demonstrates basic file handling, user authentication, and data manipulation using Java.

🧰 Features
🔐 User Authentication
Secure login using username and password

Automatic account creation if login fails

Hidden feature: Enter 23220 in the menu after login to manually create a new account

🧾 Account Management
View:

Current account balance

Fixed deposit balance

Deposit and withdraw funds

Transfer money to fixed deposits

💰 5% interest automatically applied to current balance upon viewing

🧑‍💻 Technologies Used
Feature	Technology
Language	Java
File Handling	Java I/O (java.io)
Data Storage	Plain Text (userdata.txt)
Utilities	ArrayList, Scanner

📁 Project Structure
cpp
Copy
Edit
├── BankManagementSystem.java    // Main Java program
└── userdata.txt                 // User data: username,password,currentBalance,fixedDeposit
📄 Sample userdata.txt Format
css
Copy
Edit
username,password,currentBalance,fixedDepositBalance
nishant123,pass@123,5000.0,15000.0
▶️ How to Run
🔧 Compile
bash
Copy
Edit
javac BankManagementSystem.java
🚀 Execute
bash
Copy
Edit
java BankManagementSystem
🧑‍💻 User Interaction
Follow on-screen instructions to log in or create an account

Choose from menu options to perform banking operations

Note: Ensure userdata.txt is in the same directory as your .java file.

⚠️ Disclaimer
This project is for educational purposes only

User data is stored without encryption

Not intended for real-world banking use

🌱 Future Enhancements
🔐 Encrypt passwords and sensitive data

🖥️ Add a GUI using JavaFX or Swing

🛠️ Implement Admin login for managing user accounts

🗄️ Switch from text file to MySQL or SQLite database

