-- Banking Management System Database Setup

CREATE DATABASE IF NOT EXISTS bankservice;

USE bankservice;

-- Customer account details
CREATE TABLE IF NOT EXISTS customer (
    accountNumber INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(20) NOT NULL,
    email VARCHAR(30),
    accountType VARCHAR(30) NOT NULL,
    balance DOUBLE DEFAULT 0
);

-- Customer transaction history
CREATE TABLE IF NOT EXISTS transactions (
    transaction_ID INT PRIMARY KEY AUTO_INCREMENT,
    accountNumber INT,
    transactionType VARCHAR(20) NOT NULL,
    transactionDate DATE,
    FOREIGN KEY (accountNumber)
        REFERENCES customer(accountNumber)
);