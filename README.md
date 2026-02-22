# Bank Management System (Java Console Application)

## Overview

This project is a console-based banking system developed in Java.  
It simulates core banking operations including user authentication, balance management, transactions, and fixed deposit handling.

The system demonstrates practical implementation of:

- File handling using Java I/O  
- User authentication mechanisms  
- Data persistence using structured text storage  
- Transaction logic and financial operations  
- Console-based interactive application design  

This project was built for educational purposes to strengthen understanding of object-oriented programming and data management fundamentals.

---

## Key Features

### 1. User Authentication

- Login using username and password  
- Automatic account creation if credentials are not found  
- Menu-based navigation system  
- Hidden developer option (`23220`) for manual account creation  

Note: Authentication is file-based and not encrypted (educational use only).

---

### 2. Account Management

Users can:

- View current account balance  
- View fixed deposit balance  
- Deposit funds  
- Withdraw funds  
- Transfer money to fixed deposits  

Interest Logic:
- A 5% interest is automatically applied to the current balance when viewed  

This demonstrates financial calculation handling and data updating.

---

## Technologies Used

| Component        | Technology Used |
|------------------|----------------|
| Programming Language | Java |
| File Handling | Java I/O (`java.io`) |
| Data Structures | ArrayList |
| Input Handling | Scanner |
| Data Storage | Plain Text File (`userdata.txt`) |

---

## Project Architecture

The system follows a simple layered structure:

1. User Input Layer (Console interaction)  
2. Authentication Layer (Credential validation)  
3. Business Logic Layer (Banking operations)  
4. Data Persistence Layer (Text file storage)  

---

## Project Structure

```
BankManagementSystem/
│
├── BankManagementSystem.java
└── userdata.txt
```

### userdata.txt Format

Each user record follows this structure:

```
username,password,currentBalance,fixedDepositBalance
```

Example:

```
nishant123,pass@123,5000.0,15000.0
```

---

## How to Run

### Step 1: Compile

```
javac BankManagementSystem.java
```

### Step 2: Execute

```
java BankManagementSystem
```

Ensure that `userdata.txt` is located in the same directory as the `.java` file.

---

## Functional Workflow

1. User launches application  
2. System prompts for login credentials  
3. If user exists → login successful  
4. If user does not exist → new account is created  
5. User selects banking operations from menu  
6. Transactions are processed and saved to file  

All changes are persisted immediately in `userdata.txt`.

---

## Learning Outcomes

- Understanding of file-based data persistence  
- Implementation of authentication logic  
- Handling structured financial records  
- Console-based UI flow design  
- Application of object-oriented programming principles  

---

## Limitations

- Passwords are stored in plain text  
- No encryption or hashing mechanism  
- No concurrency handling  
- No database integration  
- Not suitable for real-world deployment  

This project is strictly for academic demonstration.

---

## Future Enhancements

- Implement password hashing (e.g., SHA-256)  
- Add encryption for sensitive data  
- Introduce GUI using JavaFX or Swing  
- Add admin role for account monitoring  
- Integrate relational database (MySQL or SQLite)  
- Implement transaction history logging  
- Add exception handling improvements  
- Introduce multi-threading support  

---

## Potential Extensions

- REST API integration for web-based access  
- Migration to Spring Boot backend  
- Dockerized deployment  
- Integration with JDBC  
- Account statement generation in PDF format  

---

## Author

Nishant Rajora    
Focused on building strong programming foundations and system design skills
