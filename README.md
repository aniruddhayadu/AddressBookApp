📅 09 Mar 2026  

**🔹 UC20 – Add New Contact to Database (JDBC)** Branch: feature/UC20-add-contact-to-database

🎯 Objective

- Implement the functionality to insert a new contact directly into the MySQL database
- Maintain synchronization between the database and the local application memory

✅ Implementation

- Developed the `addNewContactToDB()` method using SQL **INSERT** statements
- Used **PreparedStatement** to securely handle user input and prevent SQL injection
- Implemented a transaction-like approach to ensure the contact is added to both the `ArrayList` and the database table simultaneously
- Added error handling to rollback or notify the user if the database insertion fails
- Verified the auto-increment ID generation and successful record persistence

[Source Code](https://github.com/aniruddhayadu/AddressBookApp/tree/feature/UC20-add-contact-to-database/src)

---
