package ContactManagement.service;

import ContactManagement.entity.Contact;
import ContactManagement.repository.ContactRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {


    private final ContactRepository contactRepository;

    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public List<Contact> getContacts() {
        return contactRepository.findAll();
    }

    @Override
    public Contact getContact(Long id) {
        return contactRepository.findById(id).orElse(null);
    }

    @Override
    public Contact createContact(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public void deleteContact(Long id) {
        contactRepository.deleteById(id);
    }

    @Override
    public Contact updateContact(Long id, Contact contact) {
        Contact existingContact = contactRepository.findById(id).orElseThrow(() -> new RuntimeException("Contact not found"));

        existingContact.setFirstName(contact.getFirstName());
        existingContact.setLastName(contact.getLastName());
        existingContact.setEmail(contact.getEmail());
        existingContact.setCellphone(contact.getCellphone());
        existingContact.setPhone(contact.getPhone());
        existingContact.setDateOfBirth(contact.getDateOfBirth());

        return contactRepository.save(existingContact);
    }
}
