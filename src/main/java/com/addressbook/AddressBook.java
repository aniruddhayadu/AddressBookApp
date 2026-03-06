package com.addressbook;

import java.util.ArrayList;

public class AddressBook {

    private ArrayList<Contact> contactList = new ArrayList<>();

    // UC7 - Prevent duplicate contact
    public void addContact(Contact contact) {

        for (Contact existingContact : contactList) {

            if (existingContact.getFirstName()
                    .equalsIgnoreCase(contact.getFirstName())) {

                System.out.println("Contact with this name already exists.");
                return;
            }
        }

        contactList.add(contact);
        System.out.println("Contact added successfully.");
    }

    // Display contacts
    public void displayContacts() {

        for (Contact contact : contactList) {
            System.out.println(contact);
        }
    }

    // Edit contact
    public void editContact(String firstName, Contact updatedContact) {

        for (int i = 0; i < contactList.size(); i++) {

            if (contactList.get(i).getFirstName()
                    .equalsIgnoreCase(firstName)) {

                contactList.set(i, updatedContact);
                System.out.println("Contact updated successfully.");
                return;
            }
        }

        System.out.println("Contact not found.");
    }

    // Delete contact
    public void deleteContact(String firstName) {

        boolean removed = contactList.removeIf(contact ->
                contact.getFirstName().equalsIgnoreCase(firstName));

        if (removed)
            System.out.println("Contact deleted successfully.");
        else
            System.out.println("Contact not found.");
    }
}