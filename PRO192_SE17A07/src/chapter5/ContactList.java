package chapter5;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ContactList {
    private List<Contact> contacts = new ArrayList<>();

    public ContactList() {
        contacts.add(new Contact("Mr.A", "a@y.c","555-1212"));
        contacts.add(new Contact("Mr.B", null,null));
        contacts.add(new Contact("Mr.A", "c@y.c",null));
    }
    
    public List<Contact> filterContact(Predicate<Contact> condition) {
        List<Contact> filterContact = new ArrayList<>();
        for (Contact contact: contacts) {
            if(condition.test(contact)) {
                filterContact.add(contact);
            }
        }
        return filterContact;
    }
}
