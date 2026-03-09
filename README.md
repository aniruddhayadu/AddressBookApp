📅 08 Mar 2026  

**🔹 UC13 – File I/O (Read and Write to Text File)** Branch: feature/uc13-ReadWriteFileIO

🎯 Objective

- Implement data persistence by saving Address Book data to a local text file
- Read data back from the file when the application restarts to maintain continuity

✅ Implementation

- Used Java `File` and `BufferedWriter` for writing contact data to a `.txt` file
- Implemented `BufferedReader` to load contacts back into the `ArrayList` from the disk
- Ensured proper formatting of data for consistent file storage and retrieval
- Handled `IOException` and verified file existence during application startup

[Source Code](https://github.com/aniruddhayadu/AddressBookApp/tree/feature/uc13-ReadWriteFileIO/src)

---
