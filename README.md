📅 09 Mar 2026  

**🔹 UC21 – Add Multiple Contacts with Multithreading** Branch: feature/UC21-add-multiple-contacts-multithreading

🎯 Objective

- Improve performance when adding a large number of contacts to the database
- Utilize Multithreading to perform concurrent database insertions

✅ Implementation

- Implemented `addMultipleContactsToDB()` using a list of contact objects
- Utilized Java's **Multithreading** capabilities by creating a separate thread for each contact insertion
- Monitored the status of each thread to ensure all contacts are successfully added before proceeding
- Measured and compared execution time, demonstrating significant performance gains over sequential insertion
- Ensured thread-safe operations while updating the local `ArrayList` synchronized with the database

[Source Code](https://github.com/aniruddhayadu/AddressBookApp/tree/feature/UC21-add-multiple-contacts-multithreading/src)

---
