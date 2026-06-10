package ContactManagement.service;

import ContactManagement.entity.Contact;

import java.util.List;

public interface ContactService {

    // Get all contacts
    List<Contact> getContacts();


    // Get contact by Id
    Contact getContact(Long id);


    // Create contact
    Contact createContact(Contact contact);


    // Delete contact
    void deleteContact(Long id);


    // Edit contact
    Contact updateContact(Long id, Contact contact);

}
