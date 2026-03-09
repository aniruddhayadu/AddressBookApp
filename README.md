📅 06 Mar 2026  

**🔹 UC8 – Search Contacts by City or State** Branch: feature/uc8-SearchPerson

🎯 Objective

- Enable searching for persons across multiple Address Books based on City or State
- Leverage Java Streams for efficient cross-collection filtering

✅ Implementation

- Implemented search logic that iterates through all Address Books stored in the `HashMap`
- Used Java Streams to filter and collect contacts matching the user-specified City or State
- Provided a centralized search result regardless of which Address Book the contact belongs to
- Optimized data retrieval to ensure high performance even with a large number of Address Books

[Source Code](https://github.com/aniruddhayadu/AddressBookApp/tree/feature/uc8-SearchPerson/src)

---
