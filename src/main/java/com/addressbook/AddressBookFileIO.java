package com.addressbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class AddressBookFileIO {

	public void writeData(List<Contact> contacts) {
		try {
			FileWriter fileWriter = new FileWriter("addressbook.txt");
			PrintWriter printWriter = new PrintWriter(fileWriter);

			for (Contact contact : contacts) {
				printWriter.println(contact.getFirstName() + "," + contact.getLastName() + "," + contact.getCity() + ","
						+ contact.getState() + "," + contact.getPhoneNumber());
			}

			printWriter.close();
			System.out.println("Contacts successfully written to file.");

		} catch (IOException e) {
			System.out.println("Error writing to file");
		}
	}

	public void readData() {
		try {
			File file = new File("addressbook.txt");
			Scanner scanner = new Scanner(file);

			while (scanner.hasNextLine()) {
				System.out.println(scanner.nextLine());
			}

			scanner.close();

		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
	}
}