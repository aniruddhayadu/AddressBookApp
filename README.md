📅 05 Mar 2026  

**🔹 UC7 – Avoid Duplicate Entries in Address Book** Branch: feature/uc7-EnsureNoDuplicate

🎯 Objective

- Ensure no two contacts with the same name exist in a single Address Book
- Apply Java Streams for efficient searching and validation

✅ Implementation

- Overrode `equals()` and `hashCode()` methods in the `Contact` class for accurate object comparison
- Used `Stream.anyMatch()` to check if a contact with the same first and last name already exists before adding
- Implemented case-insensitive name comparison to improve robustness
- Provided error messages to the user when a duplicate entry attempt is detected, preventing redundant data

[Source Code](https://github.com/aniruddhayadu/AddressBookApp/tree/feature/uc7-EnsureNoDuplicate/src)

---
