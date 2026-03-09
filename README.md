📅 09 Mar 2026  

**🔹 UC14 – CSV Operations (OpenCSV Integration)** Branch: feature/uc14-ReadWriteCSV

🎯 Objective

- Enable reading and writing Address Book data in CSV (Comma Separated Values) format
- Support data portability with spreadsheet applications like Microsoft Excel

✅ Implementation

- Integrated the **OpenCSV** library into the project dependencies
- Implemented `StatefulBeanToCsv` to write the list of contact objects to a `.csv` file
- Developed a `CsvToBeanBuilder` logic to parse CSV files and populate the Address Book
- Verified that all contact attributes are correctly mapped to CSV columns during I/O operations

[Source Code](https://github.com/aniruddhayadu/AddressBookApp/tree/feature/uc14-ReadWriteCSV/src)

---
