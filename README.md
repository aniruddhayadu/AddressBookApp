📅 09 Mar 2026  

**🔹 UC16 – Database Connectivity and Read Operation (JDBC)** Branch: feature/UC16-Read-Database

🎯 Objective

- Integrate the Address Book Application with a MySQL database
- Establish a connection using JDBC and retrieve contact records from the database

✅ Implementation

- Configured **JDBC (Java Database Connectivity)** to connect with a MySQL instance
- Developed a `AddressBookDBService` class to handle database interactions
- Implemented the `readData()` method to execute SQL SELECT queries
- Mapped database table rows to `Contact` objects to populate the application's memory
- Ensured proper management of database resources using `Connection`, `Statement`, and `ResultSet`

[Source Code](https://github.com/aniruddhayadu/AddressBookApp/tree/feature/UC16-Read-Database/src)

---
