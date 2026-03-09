📅 09 Mar 2026  

**🔹 UC19 – Count Contacts by City and State (JDBC)** Branch: feature/UC19-CountContactsByCityAndState

🎯 Objective

- Fetch aggregated contact statistics directly from the database
- Use SQL functions to count persons belonging to each City or State

✅ Implementation

- Implemented `getContactCountByCityOrState()` method using SQL `GROUP BY` clause
- Optimized the counting process by offloading the calculation to the database engine
- Developed logic to map the result set into a `Map<String, Integer>` for easy display
- Verified that the database counts match the application's internal data structures

[Source Code](https://github.com/aniruddhayadu/AddressBookApp/tree/feature/UC19-CountContactsByCityAndState/src)

---
