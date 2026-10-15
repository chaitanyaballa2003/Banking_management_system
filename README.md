# Banking Management System

## About the Project
The Banking Management System is a console-based Java application developed using Core Java, JDBC, Maven, and MySQL. It allows users to manage customer bank accounts and perform basic banking operations through a menu-driven interface.

## Features
- User Login
- Create a Bank Account
- View All Customer Accounts
- Search Account by Account Number
- Deposit Money
- Withdraw Money
- Delete Account
- Update Customer Details
- Store Transaction History
- Custom Exception Handling
- JDBC Database Connectivity

## Technologies Used
- **Programming Language:** Java
- **Database:** MySQL
- **Database Connectivity:** JDBC
- **Build and Dependency Management:** Maven
- **IDE:** Eclipse
- **Version Control:** Git and GitHub

## Project Structure
```text
Banking_management_system/
├── src/
│   ├── main/java/banking/banking_management_system/
│   │   ├── App.java
│   │   ├── Customer.java
│   │   ├── CustomerDAO.java
│   │   ├── DBConnection.java
│   │   ├── Deposit.java
│   │   ├── InvalidAmountException.java
│   │   ├── Login_page.java
│   │   ├── Menu.java
│   │   ├── Transaction.java
│   │   └── TransactionDAO.java
│   └── test/
├── pom.xml
└── README.md
```

## Database Setup
1. Install MySQL Server and start the MySQL service.
2. Create a database named `bankservice`.
3. Create the `customer` and `transactions` tables using the SQL setup script.
4. Configure the database URL, username, and password in `DBConnection.java`.
5. Make sure the MySQL Connector/J dependency is available through Maven.

## How to Run
1. Clone or download this repository.
2. Import the project into Eclipse as an existing Maven project.
3. Configure your MySQL database credentials.
4. Allow Maven to download the required dependencies.
5. Run `Login_page.java` to start the application.

## Login Details
For the current learning version:
- **Username:** `user`
- **Password:** `admin`

These are hardcoded demo credentials and should be changed before using the application beyond local practice.

## Learning Outcomes
- Practised Java classes, objects, and OOP concepts.
- Implemented JDBC connectivity with MySQL.
- Used `PreparedStatement` and `ResultSet`.
- Performed CRUD operations.
- Practised database transactions using commit and rollback.
- Implemented custom exceptions.
- Used Maven and GitHub for project management and version control.

## Author
Chaitanya Balla

## Future Improvements
- Secure login using database-stored credentials and password hashing.
- Improved input validation and exception handling.
- Better JDBC resource management.
- Transaction reports and account statement generation.
