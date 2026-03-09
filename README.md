📅 09 Mar 2026  

**🔹 UC24 – Update Contact Entry in JSON Server (REST API)** Branch: feature/UC24-update-entry-jsonserver

🎯 Objective

- Implement the functionality to update existing contact details on the **JSON Server**
- Ensure synchronization between the application's local state and the REST API backend

✅ Implementation

- Developed the `updateContactOnJSONServer()` method using HTTP **PUT** requests
- Utilized **RestAssured** to target specific contact resources via their unique `id`
- Implemented logic to update fields like `Address`, `City`, or `Phone Number` dynamically
- Verified successful updates by checking for the `200 OK` HTTP status code
- Ensured the local `ArrayList` is updated only after receiving a successful response from the server

[Source Code](https://github.com/aniruddhayadu/AddressBookApp/tree/feature/UC24-update-entry-jsonserver/src)

---
