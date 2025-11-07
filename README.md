# 💰 Finance Management System (Java + MySQL)

A simple and efficient **Finance Management System** built using **Core Java**, **JDBC**, and **MySQL**.  
This project helps manage users and their expenses with CRUD operations, database integration, and a menu-driven console interface.

---

## 🚀 Features

- 👤 Add, View, and Delete Users  
- 💸 Add, View, Update, and Delete Expenses  
- 🧾 View All Users and Expenses  
- 🗃️ MySQL Database Integration  
- ⚙️ Utility-based Architecture (DBConnUtil, DBPropertyUtil, etc.)  
- 🧪 JUnit4 Test Cases for core functionalities

---

## 🏗️ Project Structure

Finance_Management_System/
├── src/
│ ├── com.finance.main/FinanceApp.java
│ ├── com.finance.dao/FinanceRepository.java
│ ├── com.finance.dao/FinanceRepositoryImplement.java
│ ├── com.finance.entity/User.java
│ ├── com.finance.entity/Expense.java
│ ├── com.finance.util/DBConnUtil.java
│ ├── com.finance.util/DBPropertyUtil.java
│ ├── com.finance.exception/CustomException.java
│ └── com.finance.test/(JUnit Test Classes)
│
├── db.properties
└── README.md

yaml
Copy code

---

## ⚙️ Database Configuration

Create a database in MySQL:

```sql
CREATE DATABASE finance_db;
USE finance_db;
Then configure your credentials in db.properties:

properties

driver=com.mysql.cj.jdbc.Driver
url=jdbc:mysql://localhost:3306/finance_db
username=root
password=yourpassword

🧩 How to Run
Open the project in Eclipse or any IDE.

Make sure you have MySQL Connector/J added to the project’s classpath.

Place the db.properties file under src/ or mark resources/ as a source folder.

Run the main class:

com.finance.main.FinanceApp

🧠 Technologies Used
Component	Technology
Language	Java (JDK 21)
Database	MySQL
Testing	JUnit 4
IDE	Eclipse IDE
Design Pattern	DAO Pattern
Build Tool	Manual (no Maven/Gradle)

🧪 Example Console Output

===== Finance Management System =====
1. Add User
2. Add Expense
3. Delete User
4. Delete Expense
5. Update Expense
6. View All Expenses
7. View All User
8. Exit
Enter choice:




