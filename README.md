📅 09 Mar 2026  

**🔹 UC18 – Retrieve Contacts by Date Range (JDBC)** Branch: feature/UC18-retrieve-contacts-by-date-range

🎯 Objective

- Fetch contact records from the database that were added within a specific time period
- Enable data filtering based on temporal attributes for better reporting

✅ Implementation

- Modified the database schema to include a `date_added` column for each contact
- Implemented the `getContactsByDateRange()` method using SQL `BETWEEN` clause
- Used **PreparedStatement** to pass start and end dates securely to the SQL query
- Integrated Java `LocalDate` to handle date parsing and comparison within the application
- Verified that only records falling within the specified range are returned and displayed

[Source Code](https://github.com/aniruddhayadu/AddressBookApp/tree/feature/UC18-retrieve-contacts-by-date-range/src)

---
