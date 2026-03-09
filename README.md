📅 09 Mar 2026  

**🔹 UC22 – Database Normalization and Multi-Table Support** Branch: feature/UC22-database-normalization

🎯 Objective

- Optimize the database structure by implementing normalization (1NF, 2NF, 3NF)
- Separate contact details, addresses, and types into different tables to reduce redundancy

✅ Implementation

- Refactored the single `address_book` table into multiple related tables: `Contacts`, `Address`, and `Contact_Type`
- Established **Foreign Key** relationships to maintain data integrity across tables
- Updated the JDBC logic to perform **Joins** when retrieving complete contact information
- Implemented a transaction-based approach to ensure that when a contact is added, all related table entries are updated atomically
- Enhanced the system to support a single contact belonging to multiple Address Book types (e.g., Family and Friends)

[Source Code](https://github.com/aniruddhayadu/AddressBookApp/tree/feature/UC22-database-normalization/src)

---
