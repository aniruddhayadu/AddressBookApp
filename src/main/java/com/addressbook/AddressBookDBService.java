package com.addressbook;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/*
 * JDBC service to retrieve and update contacts in MySQL
 */
public class AddressBookDBService {

	private static final String URL = "jdbc:mysql://localhost:3306/address_book_service";
	private static final String USER = "root";
	private static final String PASSWORD = "777282";

	// Method to establish database connection
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

	// UC16: Retrieve all contacts from Database
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

	// UC17: Update Contact City in Database
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

	// UC18: Retrieve contacts by date range
	public List<Contact> getContactsByDateRange(String startDate, String endDate) {
		List<Contact> contacts = new ArrayList<>();
		String query = "SELECT * FROM address_book WHERE date_added BETWEEN ? AND ?";

		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(query)) {

			statement.setString(1, startDate);
			statement.setString(2, endDate);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				Contact contact = new Contact(rs.getString("first_name"), rs.getString("last_name"),
						rs.getString("address"), rs.getString("city"), rs.getString("state"), rs.getString("zip"),
						rs.getString("phone"), rs.getString("email"));
				contacts.add(contact);
			}

		} catch (Exception e) {
			System.out.println("Error retrieving contacts: " + e.getMessage());
		}
		return contacts;
	}

	// UC19: Get count of contacts by City from DB
	public int getCountOfContactsByCity(String city) {
		int count = 0;
		String query = "SELECT COUNT(*) AS count FROM address_book WHERE city = ?";

		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setString(1, city);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				count = rs.getInt("count");
			}
		} catch (Exception e) {
			System.out.println("Error counting by city: " + e.getMessage());
		}
		return count;
	}

	// UC19: Get count of contacts by State from DB
	public int getCountOfContactsByState(String state) {
		int count = 0;
		String query = "SELECT COUNT(*) AS count FROM address_book WHERE state = ?";

		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setString(1, state);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				count = rs.getInt("count");
			}
		} catch (Exception e) {
			System.out.println("Error counting by state: " + e.getMessage());
		}
		return count;
	}
}