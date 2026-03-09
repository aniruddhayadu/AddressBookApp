📅 09 Mar 2026  

**🔹 UC25 – Delete Contact Entry from JSON Server (REST API)** Branch: feature/UC25-delete-entry-jsonserver

🎯 Objective

- Implement the functionality to delete a contact record from the **JSON Server**
- Ensure the application's local memory stays in sync with the REST API backend after a deletion

✅ Implementation

- Developed the `deleteContactFromJSONServer()` method using HTTP **DELETE** requests
- Utilized **RestAssured** to target specific contact resources via their unique `id` or `firstName`
- Implemented logic to remove the contact from the local `ArrayList` only after receiving a `200 OK` or `204 No Content` status code from the server
- Verified that the record is permanently removed from the `db.json` file
- Added error handling to manage cases where the contact to be deleted does not exist

[Source Code](https://github.com/aniruddhayadu/AddressBookApp/tree/feature/UC25-delete-entry-jsonserver/src)

---
