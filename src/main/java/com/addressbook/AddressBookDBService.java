package com.addressbook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/*
 * UC16
 * JDBC service to retrieve contacts from MySQL
 */

public class AddressBookDBService {

	private static final String URL = "jdbc:mysql://localhost:3306/address_book_service";

	private static final String USER = "root";
	private static final String PASSWORD = "777282";

	private Connection getConnection() {

		Connection connection = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			connection = DriverManager.getConnection(URL, USER, PASSWORD);

		} catch (Exception e) {

			System.out.println("Database connection failed : " + e.getMessage());
		}

		return connection;
	}

	public List<Contact> readContactsFromDatabase() {

		List<Contact> contactList = new ArrayList<>();

		String query = "SELECT * FROM address_book";

		try (Connection connection = getConnection();
				Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery(query)) {

			while (rs.next()) {

				Contact contact = new Contact(rs.getString("first_name"), rs.getString("last_name"),
						rs.getString("address"), rs.getString("city"), rs.getString("state"), rs.getString("zip"),
						rs.getString("phone"), rs.getString("email"));

				contactList.add(contact);
			}

		} catch (Exception e) {

			System.out.println("Error reading database : " + e.getMessage());
		}

		return contactList;
	}

	// UC17 Update Contact in Database
	public boolean updateContactCity(String firstName, String city) {

		String query = "UPDATE address_book SET city = '" + city + "' WHERE first_name = '" + firstName + "'";

		try (Connection connection = getConnection(); Statement statement = connection.createStatement()) {

			int rowsAffected = statement.executeUpdate(query);

			return rowsAffected > 0;

		} catch (Exception e) {

			System.out.println("Error updating contact: " + e.getMessage());
		}

		return false;
	}

}
