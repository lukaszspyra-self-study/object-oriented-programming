package com.udacity.contactsmanager;

public class Main {
    public static void main(String[] args) {
        ContactsManager myContactsManager = new ContactsManager();

        Contact contact1 = new Contact();
        contact1.name = "Kasia";
        contact1.phoneNumber = "0048744777999";
        myContactsManager.addContact(contact1);

        Contact contact2 = new Contact();
        contact2.name = "Basia";
        contact2.phoneNumber = "0048777777777";
        myContactsManager.addContact(contact2);

        Contact contact3 = new Contact();
        contact3.name = "Tomek";
        contact3.phoneNumber = "0048999999999";
        myContactsManager.addContact(contact3);

        Contact contact4 = new Contact();
        contact4.name = "Krzysiek";
        contact4.phoneNumber = "0048888888888";
        contact4.email = "malpka@email.com";
        myContactsManager.addContact(contact4);

        System.out.println(myContactsManager.searchContact("Kasia").phoneNumber);
    }
}
