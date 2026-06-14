package ContactManagement.service;

import ContactManagement.dto.ContactRequestDTO;
import ContactManagement.dto.ContactResponseDTO;
import ContactManagement.entity.Contact;

import java.util.List;

public interface ContactService {

    // Get all contacts
    List<ContactResponseDTO> getAllContacts();


    // Get contact by Id
    ContactResponseDTO getContactById(Long id);


    // Create contact
    ContactResponseDTO createContact(ContactRequestDTO dto);


    // Delete contact
    void deleteContact(Long id);


    // Edit contact
    ContactResponseDTO updateContact(Long id, ContactRequestDTO dto);

}
