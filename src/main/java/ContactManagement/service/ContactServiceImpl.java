package ContactManagement.service;

import ContactManagement.dto.ContactRequestDTO;
import ContactManagement.dto.ContactResponseDTO;
import ContactManagement.entity.Contact;
import ContactManagement.mapper.ContactMapper;
import ContactManagement.repository.ContactRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactServiceImpl implements ContactService {


    private final ContactRepository contactRepository;
    private final ContactMapper contactMapper;


    public ContactServiceImpl(ContactRepository contactRepository, ContactMapper contactMapper) {
        this.contactRepository = contactRepository;
        this.contactMapper = contactMapper;
    }


    @Override
    public List<ContactResponseDTO> getAllContacts() {
        return contactRepository.findAll()
                .stream()
                .map(contactMapper::toResponseDTO)
                .collect(Collectors.toList());
    }


    @Override
    public ContactResponseDTO getContactById(Long id) {
        Contact contact = contactRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contact not found"));
        return contactMapper.toResponseDTO(contact);
    }


    @Override
    public ContactResponseDTO createContact(ContactRequestDTO dto) {
        Contact contact = contactMapper.toEntity(dto);
        Contact saved = contactRepository.save(contact);
        return contactMapper.toResponseDTO(saved);
    }


    @Override
    public void deleteContact(Long id) {
        if (!contactRepository.existsById(id)) {
            throw new RuntimeException("Contact not found");
        }
        contactRepository.deleteById(id);
    }

    @Override
    public ContactResponseDTO updateContact(Long id, ContactRequestDTO dto) {

        Contact existingContact = contactRepository.findById(id).orElseThrow(() -> new RuntimeException("Contact not found"));

        existingContact.setFirstName(dto.getFirstName());
        existingContact.setLastName(dto.getLastName());
        existingContact.setEmail(dto.getEmail());
        existingContact.setCellphone(dto.getCellphone());
        existingContact.setPhone(dto.getPhone());
        existingContact.setDateOfBirth(dto.getDateOfBirth());

        Contact updatedContact = contactRepository.save(existingContact);

        return  contactMapper.toResponseDTO(updatedContact);
    }

}
