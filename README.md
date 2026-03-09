📅 09 Mar 2026  

**🔹 UC23 – JSON Server Integration (REST API)** Branch: feature/UC23-add-multiple-entries-jsonserver

🎯 Objective

- Integrate the Address Book Application with **JSON Server** to simulate a REST API
- Implement CRUD operations (Create, Read, Update, Delete) using HTTP requests

✅ Implementation

- Configured a `db.json` file to act as the backend data store for the application
- Utilized **RestAssured** and **HttpClient** to send GET, POST, PUT, and DELETE requests
- Implemented logic to add multiple contacts to the JSON Server and verified successful synchronization
- Ensured the application can retrieve the latest contact list from the REST endpoint on startup
- Verified status codes (200 OK, 201 Created) to ensure data integrity during API interactions

[Source Code](https://github.com/aniruddhayadu/AddressBookApp/tree/feature/UC23-add-multiple-entries-jsonserver/src)

---
