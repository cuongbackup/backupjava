package chapter5;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        ContactList list = new ContactList();
        List<Contact> contactsWithoutPhone = list.filterContact(contact -> contact.getPhone() == null);
        System.out.println("" + contactsWithoutPhone);
        List<Contact> contactsWithoutEmail = list.filterContact(contact -> contact.getEmail() == null);
        System.out.println("" + contactsWithoutEmail);
    }

}
